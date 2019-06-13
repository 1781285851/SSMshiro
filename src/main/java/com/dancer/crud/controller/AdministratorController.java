package com.dancer.crud.controller;
//�����޸ĺ��qqqqq11111QWQW
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
 * ����CRUD����
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {
	
	@Autowired
	AdministratorService administratorService;
	
	
	/**
	 * ӳ��,��loginAndRegisterindexs.jspҳ��,�˴��ǵ�¼��ע���ҳ��
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
	 * �û�ע��
	 * @param name
	 * @param password
	 * @param boss
	 * @param session
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping(value="register", method = RequestMethod.POST)
	@ResponseBody		//@ResponseBody��ʾ���߿���������ֻ�����������ݣ�������ת������ҳ	(Ajax���ݲ���)
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
		// ����Subjectʵ������
		Subject currentUser = SecurityUtils.getSubject();
		// �жϵ�ǰ�û��Ƿ��ѵ�¼
		if (currentUser.isAuthenticated() == false) {
			UsernamePasswordToken token = new UsernamePasswordToken(name, password);
			try {
				currentUser.login(token);
			} catch (UnknownAccountException e) {
				model.addAttribute("errorMsg", "�˺Ų�����");
				return "modules/loginAndRegister/loginAndRegisterindexs";
			} catch (IncorrectCredentialsException e) {
				model.addAttribute("errorMsg", "�û���/�������");
				return "modules/loginAndRegister/loginAndRegisterindexs";
			} catch (Exception e) {
				model.addAttribute("errorMsg", "�����쳣��Ϣ");
				return "modules/loginAndRegister/loginAndRegisterindexs";
			}
		}
		return "modules/sys/index";
		
	}

}
