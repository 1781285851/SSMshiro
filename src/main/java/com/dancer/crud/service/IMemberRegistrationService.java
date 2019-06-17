package com.dancer.crud.service;

import com.dancer.crud.entity.MemberRegistration;

public interface IMemberRegistrationService {
	
	/**
	 * 身份证号码判断该用户是否存在
	 * @param IdentityCard
	 * @return
	 */
	MemberRegistration selectMenberByIdentityCardService(String IdentityCard);
	
	
	/**
	 * 添加会员
	 * @param memberRegistration
	 * @return
	 */
	String insertMenberService(String ClubCard,String Name,String IdentityCard,String Phone,String qq,String Wechat,String Administrator,String Gender,Integer DanceTypesId);

	

}
