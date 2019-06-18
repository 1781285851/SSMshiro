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

	
	/**
	 * ��ѯ���л�Ա����
	 * @return
	 */
	int selectCountService();
	
	
	/**
	 * ��ѯBreaking��Ա����
	 * @return
	 */
	int selectCountByBreakingService();
	
	
	/**
	 * ��ѯPoppin��Ա����
	 * @return
	 */
	int selectCountByPoppinService();
	
	
	/**
	 * ��ѯLocking��Ա����
	 * @return
	 */
	int selectCountByLockingService();
	
	
	/**
	 * ��ѯHiphop��Ա����
	 * @return
	 */
	int selectCountByHiphopService();
	
	
	/**
	 * ��ѯJazz��Ա����
	 * @return
	 */
	int selectCountByJazzService();
	
	
	/**
	 * ��ѯShuffle��Ա����
	 * @return
	 */
	int selectCountByShuffleService();
	
	
	/**
	 * ��ѯUrban��Ա����
	 * @return
	 */
	int selectCountByUrbanService();
	
	
	/**
	 * ��ѯWacking��Ա����
	 * @return
	 */
	int selectCountByWackingService();

}
