package com.dancer.crud.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedirectionController {
	
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
	
	@RequestMapping(value="memberRegistration", method = RequestMethod.GET)
	public String notifications(){
		return "modules/sys/memberRegistration";
	}
	@RequestMapping(value="tables", method = RequestMethod.GET)
	public String tables(){
		return "modules/sys/tables";
	}
	@RequestMapping(value="typography", method = RequestMethod.GET)
	public String typography(){
		return "modules/sys/typography";
	}
	
}
