package com.dancer.crud.service;

import com.dancer.crud.entity.Administrator;

public interface IAdministratorService {
	
	/**
	 * 根据姓名查询管理员账号
	 * @param name
	 * @return
	 */
	Administrator selectAdministrator(String name);
	
	/**
	 * 注册管理员账号
	 * @param administrator
	 * @return
	 */
	String insertAdministrator(String username,String password);
	
}	
