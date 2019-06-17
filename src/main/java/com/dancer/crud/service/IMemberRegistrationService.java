package com.dancer.crud.service;

import com.dancer.crud.entity.MemberRegistration;

public interface IMemberRegistrationService {
	
	/**
	 * ���֤�����жϸ��û��Ƿ����
	 * @param IdentityCard
	 * @return
	 */
	MemberRegistration selectMenberByIdentityCardService(String IdentityCard);
	
	
	/**
	 * ��ӻ�Ա
	 * @param memberRegistration
	 * @return
	 */
	String insertMenberService(String ClubCard,String Name,String IdentityCard,String Phone,String qq,String Wechat,String Administrator,String Gender,Integer DanceTypesId);

	

}
