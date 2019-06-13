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
	 * ����������ѯ����Ա�˺�
	 */
	@Override
	public Administrator selectAdministrator(String name) {
		//����������ѯ�Ƿ�Ϊ��
		Administrator administrator = administratorMapperDao.selectName(name);
		return administrator;
	}

	
	/**
	 * ע�����Ա�˺�
	 */
	@Override
	public String insertAdministrator(String username,String password) {
		//����������ѯ����Ա�˺�
		Administrator administrator1 = selectAdministrator(username);
		//Administrator administrator1 = new Administrator();
		if(null == administrator1){
			//���ɵ������
			String salt = UUID.randomUUID().toString().toUpperCase();
			//����md5����
			Md5Hash hash = new Md5Hash(password, salt, 1024);
			String md5password = hash.toString();
			//����ʱ��
			Date date=new Date();
			administrator.setName(username);
			administrator.setUuid(salt);
			administrator.setPassword(md5password);
			administrator.setCreatetime(date);
			int num = administratorMapperDao.insert(administrator);
			System.out.println("�˺�ע��ɹ�");
			return "succeed";
		}else {
			System.out.println("���˺��Ѿ�����");
			return "failed";
		}
	}
	
	
}
