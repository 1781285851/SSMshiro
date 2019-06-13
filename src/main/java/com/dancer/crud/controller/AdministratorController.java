package com.dancer.crud.controller;
//这是修改后的qqqqq11111QWQW
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
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
 * 处理CRUD请求
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {
	
	@Autowired
	AdministratorService administratorService;
	
	
	/**
	 * 映射,打开loginAndRegisterindexs.jsp页面,此处是登录和注册的页面
	 * @return
	 */
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String loginAndRegisterindexs(){
		return "modules/loginAndRegister/loginAndRegisterindexs";
	}
	
	
	@RequestMapping(value="components", method = RequestMethod.GET)
	public String components(){
		return "modules/sys/components";
	}
	
	@RequestMapping(value="forms", method = RequestMethod.GET)
	public String forms(){
		return "modules/sys/forms";
	}
	
	@RequestMapping(value="icons", method = RequestMethod.GET)
	//@RequiresPermissions("one:asdsawwwwsas")
	@RequiresRoles("T1")
	public String icons(){
		return "modules/sys/icons";
	}
	
	@RequestMapping(value="dashboard", method = RequestMethod.GET)
	public String index(){
		return "modules/sys/index";
	}
	
	@RequestMapping(value="notifications", method = RequestMethod.GET)
	public String notifications(){
		return "modules/sys/notifications";
	}
	@RequestMapping(value="tables", method = RequestMethod.GET)
	public String tables(){
		return "modules/sys/tables";
	}
	@RequestMapping(value="typography", method = RequestMethod.GET)
	public String typography(){
		return "modules/sys/typography";
	}
	

	
	/**
	 * 用户注册
	 * @param name
	 * @param password
	 * @param boss
	 * @param session
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping(value="register", method = RequestMethod.POST)
	@ResponseBody		//@ResponseBody表示告诉控制器，我只返回数据内容，而不是转发回网页	(Ajax传递参数)
	public String register(@RequestParam("name") String name, @RequestParam("pwd") String password, Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String a = administratorService.insertAdministrator(name,password);
		if(a == "succeed"){
			return "true";
		}else {
			return "false";
		}	
		
	}
	
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request,@RequestParam("name") String name, @RequestParam("pwd") String password) {
		// 创建Subject实例对象
		Subject currentUser = SecurityUtils.getSubject();
		// 判断当前用户是否已登录
		if (currentUser.isAuthenticated() == false) {
			UsernamePasswordToken token = new UsernamePasswordToken(name, password);
			try {
				currentUser.login(token);
			} catch (UnknownAccountException e) {
				model.addAttribute("errorMsg", "账号不存在");
				return "modules/loginAndRegister/loginAndRegisterindexs";
			} catch (IncorrectCredentialsException e) {
				model.addAttribute("errorMsg", "用户名/密码错误");
				return "modules/loginAndRegister/loginAndRegisterindexs";
			} catch (Exception e) {
				model.addAttribute("errorMsg", "其他异常信息");
				return "modules/loginAndRegister/loginAndRegisterindexs";
			}
		}
		return "modules/sys/index";
		
	}

}
