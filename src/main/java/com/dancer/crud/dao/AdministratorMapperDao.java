package com.dancer.crud.dao;

import org.springframework.stereotype.Repository;

import com.dancer.crud.entity.Administrator;

@Repository
public interface AdministratorMapperDao {
	
	/**
	 * ע�����Ա�����ӹ���Ա�˺ţ�
	 * @param administrator
	 * @return
	 */
	int insert(Administrator administrator);
	
	/**
	 * ��ѯ����Ա��Ϣ
	 * @param name
	 * @return
	 */
	Administrator selectName(String name);
	
}