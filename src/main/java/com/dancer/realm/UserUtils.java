package com.dancer.realm;

import org.apache.shiro.SecurityUtils;

public class UserUtils {
	/**
	 * 
	* @Title: getCurrentUser 
	* @Description: 获取当前登录用户
	* @author chenqf
	* @param @return
	* @return SysUser
	* @throws
	 */
	/*
	public static SysUser getCurrentUser(){
		org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
	    SysUser currentUser = (SysUser)subject.getPrincipal();
	    return currentUser;
	}*/
	
	public static String getUserRoleId(){
		org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
		if(subject.hasRole("T1")){
			return "1";
		}else if (subject.hasRole("T2")){
			return "2";
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//下边没用
	/**
	 * 代理商
	 * @return
	 */
	public static boolean isAgentUser(){
		org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
	    return subject.hasRole("1");
	}
	
	/**
	 * 渠道商
	 * @return
	 */
	public static boolean isChannelUser(){
		org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
	    return subject.hasRole("2");
	}
	
	public static boolean isAfterSale(){
		org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
	    return subject.hasRole("4");
	}
	
	/**
	 * 是否账务 
	 * @return
	 */
	public static boolean isFinance(){
		org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
	    return subject.hasRole("5") || subject.hasRole("6");
	}
	
	
	
	/**
	 * 检查当前用户的权限
	 * @return
	 */
	public static  Boolean  checkUserPermission(){
		org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
		if(subject.hasRole("superadmin") || subject.hasRole("0")){
			return true;
		}
		return false;
	}
	
	/**
	 * 检查当前用户的权限
	 * 根绝传入的参数
	 * @return
	 */
	public static  Boolean  checkUserPermissionByParams(String params){
		org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
		if(subject.hasRole(params)){
			return true;
		}
		return false;
	}
}

