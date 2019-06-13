package com.dancer.crud.dao;

import java.util.List;

public interface PermissionDao {
	
	/**
	 * 根据姓名查询当前用户的权限
	 * @param name
	 * @return
	 */
	List<String> selectPermissionByName(String name);

}
