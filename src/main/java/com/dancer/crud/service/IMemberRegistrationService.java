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

	
	/**
	 * 查询所有会员总数
	 * @return
	 */
	int selectCountService();
	
	
	/**
	 * 查询Breaking会员总数
	 * @return
	 */
	int selectCountByBreakingService();
	
	
	/**
	 * 查询Poppin会员总数
	 * @return
	 */
	int selectCountByPoppinService();
	
	
	/**
	 * 查询Locking会员总数
	 * @return
	 */
	int selectCountByLockingService();
	
	
	/**
	 * 查询Hiphop会员总数
	 * @return
	 */
	int selectCountByHiphopService();
	
	
	/**
	 * 查询Jazz会员总数
	 * @return
	 */
	int selectCountByJazzService();
	
	
	/**
	 * 查询Shuffle会员总数
	 * @return
	 */
	int selectCountByShuffleService();
	
	
	/**
	 * 查询Urban会员总数
	 * @return
	 */
	int selectCountByUrbanService();
	
	
	/**
	 * 查询Wacking会员总数
	 * @return
	 */
	int selectCountByWackingService();

}
