package com.dancer.crud.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dancer.realm.UserUtils;
/**
 * 给页面传当前登录用户的角色
 * @author Nian
 *
 */
@Controller
@RequestMapping("/")
public class ShiroController {
	@RequestMapping(value = "ShiroRole", method = RequestMethod.POST)
	@ResponseBody
	public String index(HttpServletRequest request,HttpServletResponse response){
		System.out.println("UserUtils.getUserRoleId():"+UserUtils.getUserRoleId());
	    return UserUtils.getUserRoleId();
	}
}
