package com.dancer.crud.dao;

import java.util.List;

public interface PermissionDao {
	
	/**
	 * ����������ѯ��ǰ�û���Ȩ��
	 * @param name
	 * @return
	 */
	List<String> selectPermissionByName(String name);

}
