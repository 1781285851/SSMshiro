package com.dancer.crud.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao {
	
	/**
	 * ����������ѯ��ǰ�û��Ľ�ɫ
	 * @param name
	 * @return
	 */
	String selectRoleByName(String name);
	
}
