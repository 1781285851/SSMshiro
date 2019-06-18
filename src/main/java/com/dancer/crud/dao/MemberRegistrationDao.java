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
	
	/**
	 * 查询所有会员总数
	 * @return
	 */
	int selectCount();
	
	/**
	 * 查询Breaking会员总数
	 * @return
	 */
	int selectCountByBreaking();
	
	/**
	 * 查询Poppin会员总数
	 * @return
	 */
	int selectCountByPoppin();
	
	/**
	 * 查询Locking会员总数
	 * @return
	 */
	int selectCountByLocking();
	
	/**
	 * 查询Hiphop会员总数
	 * @return
	 */
	int selectCountByHiphop();
	
	/**
	 * 查询Jazz会员总数
	 * @return
	 */
	int selectCountByJazz();
	
	/**
	 * 查询Shuffle会员总数
	 * @return
	 */
	int selectCountByShuffle();
	
	/**
	 * 查询Urban会员总数
	 * @return
	 */
	int selectCountByUrban();
	
	/**
	 * 查询Wacking会员总数
	 * @return
	 */
	int selectCountByWacking();
	
}
