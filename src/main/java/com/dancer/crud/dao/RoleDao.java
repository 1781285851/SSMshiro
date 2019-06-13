package com.dancer.crud.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao {
	
	/**
	 * 根据姓名查询当前用户的角色
	 * @param name
	 * @return
	 */
	String selectRoleByName(String name);
	
}
