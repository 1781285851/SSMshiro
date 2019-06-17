package com.dancer.crud.dao;

import org.springframework.stereotype.Repository;

import com.dancer.crud.entity.MemberRegistration;

@Repository
public interface MemberRegistrationDao {
	
	/**
	 * 添加会员
	 * @param memberRegistration
	 * @return
	 */
	int insertMenber(MemberRegistration memberRegistration);
	
	/**
	 * 根据身份证判断该用户是否存在
	 * @param IdentityCard
	 * @return
	 */
	MemberRegistration selectMenberByIdentityCard(String IdentityCard);
	
}
