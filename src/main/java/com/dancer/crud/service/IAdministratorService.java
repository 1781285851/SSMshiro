package com.dancer.crud.service;

import com.dancer.crud.entity.Administrator;

public interface IAdministratorService {
	
	/**
	 * ����������ѯ����Ա�˺�
	 * @param name
	 * @return
	 */
	Administrator selectAdministrator(String name);
	
	/**
	 * ע�����Ա�˺�
	 * @param administrator
	 * @return
	 */
	String insertAdministrator(String username,String password);
	
}	
