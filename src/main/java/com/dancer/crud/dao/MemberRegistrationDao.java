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
	
	/**
	 * ��ѯ���л�Ա����
	 * @return
	 */
	int selectCount();
	
	/**
	 * ��ѯBreaking��Ա����
	 * @return
	 */
	int selectCountByBreaking();
	
	/**
	 * ��ѯPoppin��Ա����
	 * @return
	 */
	int selectCountByPoppin();
	
	/**
	 * ��ѯLocking��Ա����
	 * @return
	 */
	int selectCountByLocking();
	
	/**
	 * ��ѯHiphop��Ա����
	 * @return
	 */
	int selectCountByHiphop();
	
	/**
	 * ��ѯJazz��Ա����
	 * @return
	 */
	int selectCountByJazz();
	
	/**
	 * ��ѯShuffle��Ա����
	 * @return
	 */
	int selectCountByShuffle();
	
	/**
	 * ��ѯUrban��Ա����
	 * @return
	 */
	int selectCountByUrban();
	
	/**
	 * ��ѯWacking��Ա����
	 * @return
	 */
	int selectCountByWacking();
	
}
