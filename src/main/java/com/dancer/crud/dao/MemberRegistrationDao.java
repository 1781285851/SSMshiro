package com.dancer.crud.dao;

import org.springframework.stereotype.Repository;

import com.dancer.crud.entity.MemberRegistration;

@Repository
public interface MemberRegistrationDao {
	
	/**
	 * ��ӻ�Ա
	 * @param memberRegistration
	 * @return
	 */
	int insertMenber(MemberRegistration memberRegistration);
	
	/**
	 * �������֤�жϸ��û��Ƿ����
	 * @param IdentityCard
	 * @return
	 */
	MemberRegistration selectMenberByIdentityCard(String IdentityCard);
	
}
