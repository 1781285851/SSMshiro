package com.dancer.crud.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedirectionController {
	
	/**
	 * 没登录是自动跳转这个页面
	 * @return
	 */
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String loginAndRegisterindexs(){
		return "modules/loginAndRegister/loginAndRegisterindexs";
	}
	
	
	@RequestMapping(value="components", method = RequestMethod.GET)
	@RequiresRoles(value={"T1","T2"},logical = Logical.OR)
	public String components(){
		return "modules/sys/components";
	}
	
	@RequestMapping(value="forms", method = RequestMethod.GET)
	@RequiresRoles(value={"T1","T2"},logical = Logical.OR)
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
	@RequiresRoles(value={"T1","T2"},logical = Logical.OR)
	public String index(){
		return "modules/sys/index";
	}
	
	@RequestMapping(value="memberRegistration", method = RequestMethod.GET)
	@RequiresRoles(value={"T1","T2"},logical = Logical.OR)
	public String notifications(){
		return "modules/sys/memberRegistration";
	}
	@RequestMapping(value="tables", method = RequestMethod.GET)
	@RequiresRoles(value={"T1","T2"},logical = Logical.OR)
	public String tables(){
		return "modules/sys/tables";
	}
	@RequestMapping(value="typography", method = RequestMethod.GET)
	@RequiresRoles(value={"T1","T2"},logical = Logical.OR)
	public String typography(){
		return "modules/sys/typography";
	}
	
}
