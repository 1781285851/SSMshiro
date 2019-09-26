package com.dancer.crud.controller;
//�����޸ĺ��qqqqq11111QWQW
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dancer.crud.service.AdministratorService;

/**
 * 管理员的注册和登陆
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {
	
	@Autowired
	AdministratorService administratorService;
	
	
	/**
	 * 管理员的注册
	 * @param name
	 * @param password
	 * @param boss
	 * @param session
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping(value="register", method = RequestMethod.POST)
	@ResponseBody		
	public String register(@RequestParam("name") String name, @RequestParam("pwd") String password, Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException{
		String a = administratorService.insertAdministrator(name,password);
		if(a == "succeed"){
			return "true";
		}else {
			return "false";
		}	
		
	}
	
	/**
	 * 登陆
	 * @param session
	 * @param model
	 * @param request
	 * @param name
	 * @param password
	 * @return
	 */
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String login(HttpSession session, Model model, HttpServletRequest request,@RequestParam("name") String name, @RequestParam("pwd") String password) {
		//创建当前登录的主体，注意：此时主体没有经过认证
		Subject currentUser = SecurityUtils.getSubject();
		System.out.println("currentUser:"+currentUser);
		System.out.println("currentUser:"+currentUser.isAuthenticated());
		//判断当前主体是否已经登录
		if (currentUser.isAuthenticated() == false) {
			//收集主体登录的身份凭证，即账号密码
			//参数1：将要登录的用户名
			//参数2：登录的密码
			UsernamePasswordToken token = new UsernamePasswordToken(name, password);
			try {
				//主体登录
				currentUser.login(token);
			} catch (UnknownAccountException e) {
				model.addAttribute("errorMsg", "找不到账户-----当前账户不存在");
				return "modules/loginAndRegister/loginAndRegisterindexs";
			} catch (IncorrectCredentialsException e) {
				model.addAttribute("errorMsg", "密码错误");
				return "modules/loginAndRegister/loginAndRegisterindexs";
			} catch (Exception e) {
				model.addAttribute("errorMsg", "登陆出错");
				return "modules/loginAndRegister/loginAndRegisterindexs";
			}
		}
		session.setAttribute("name", name);
		return "modules/sys/index";
		
	}
	
	/**
	 * 退出
	 */
	@RequestMapping(value="logout")
	public void logout() {
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
		}
	}
	
	/*
	@RequestMapping(value="loginOk", method = RequestMethod.POST)
	public String loginOk() {
		return "modules/sys/index";
	}
		*/
}
