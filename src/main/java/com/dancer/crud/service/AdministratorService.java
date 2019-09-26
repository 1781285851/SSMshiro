package com.dancer.crud.service;

import java.util.Date;
import java.util.UUID;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dancer.crud.dao.AdministratorMapperDao;
import com.dancer.crud.entity.Administrator;

@Service
public class AdministratorService{
	
	@Autowired
	AdministratorMapperDao administratorMapperDao;
	
	@Autowired
	Administrator administrator;
	
	/**
	 * 查询管理员账号
	 */
	public Administrator selectAdministrator(String name) {
		Administrator administrator = administratorMapperDao.selectName(name);
		return administrator;
	}

	
	/**
	 * 加密添加管理员账号
	 */
	public String insertAdministrator(String username,String password) {
		//查询管理员账号
		Administrator administrator1 = selectAdministrator(username);
		if(null == administrator1){
			//获取UUID
			String salt = UUID.randomUUID().toString().toUpperCase();
			//MD5加密
			Md5Hash hash = new Md5Hash(password, salt, 1024);
			String md5password = hash.toString();
			Date date=new Date();
			administrator.setName(username);
			administrator.setUuid(salt);
			administrator.setPassword(md5password);
			administrator.setCreatetime(date);
			int num = administratorMapperDao.insert(administrator);
			return "succeed";
		}else {
			return "failed";
		}
	}
	
	
}
