package com.dancer.crud.service;

import java.util.Date;
import java.util.UUID;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dancer.crud.dao.AdministratorMapperDao;
import com.dancer.crud.entity.Administrator;

@Service
public class AdministratorService implements IAdministratorService{
	
	@Autowired
	AdministratorMapperDao administratorMapperDao;
	
	@Autowired
	Administrator administrator;
	
	/**
	 * 根据姓名查询管理员账号
	 */
	@Override
	public Administrator selectAdministrator(String name) {
		//根据姓名查询是否为空
		Administrator administrator = administratorMapperDao.selectName(name);
		return administrator;
	}

	
	/**
	 * 注册管理员账号
	 */
	@Override
	public String insertAdministrator(String username,String password) {
		//根据姓名查询管理员账号
		Administrator administrator1 = selectAdministrator(username);
		//Administrator administrator1 = new Administrator();
		if(null == administrator1){
			//生成的随机数
			String salt = UUID.randomUUID().toString().toUpperCase();
			//进行md5加密
			Md5Hash hash = new Md5Hash(password, salt, 1024);
			String md5password = hash.toString();
			//创建时间
			Date date=new Date();
			administrator.setName(username);
			administrator.setUuid(salt);
			administrator.setPassword(md5password);
			administrator.setCreatetime(date);
			int num = administratorMapperDao.insert(administrator);
			System.out.println("账号注册成功");
			return "succeed";
		}else {
			System.out.println("该账号已经存在");
			return "failed";
		}
	}
	
	
}
