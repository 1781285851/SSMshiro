package com.dancer.crud.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dancer.crud.dao.MemberRegistrationDao;
import com.dancer.crud.entity.MemberRegistration;

@Service
public class MemberRegistrationService implements IMemberRegistrationService{
	
	@Autowired
	MemberRegistrationDao memberRegistrationDao;
	
	@Autowired
	MemberRegistration memberRegistration;
	
	/**
	 * 根据根据身份证卡号查询用户
	 * @param IdentityCard
	 * @return
	 */
	@Override
	public MemberRegistration selectMenberByIdentityCardService(String IdentityCard) {
		MemberRegistration member = memberRegistrationDao.selectMenberByIdentityCard(IdentityCard);
		return member;
	}
	
	
	/**
	 * 添加会员  先判断改会员是否存在，如果不存在再添加
	 * @param memberRegistration
	 * @return
	 */
	@Override
	public String insertMenberService(String ClubCard,String Name,String IdentityCard,String Phone,String qq,String Wechat,String Administrator,String Gender,Integer DanceTypesId){
		MemberRegistration member = selectMenberByIdentityCardService(IdentityCard);
		if(null==member){
			memberRegistration.setClubCard(ClubCard);
			memberRegistration.setName(Name);
			memberRegistration.setIdentityCard(IdentityCard);
			memberRegistration.setPhone(Phone);
			memberRegistration.setQQ(qq);
			memberRegistration.setWechat(Wechat);
			memberRegistration.setAdministrator(Administrator);
			memberRegistration.setGender(Gender);
			memberRegistration.setDanceTypesId(DanceTypesId);
			Date creationTime=new Date();
			memberRegistration.setCreationTime(creationTime);
			memberRegistration.setState(0);
			int num =  memberRegistrationDao.insertMenber(memberRegistration);
			return "success";
		}else{
			return "failed";
		}
	}

	
	/**
	 * 查询所有会员总数
	 * @return
	 */
	@Override
	public int selectCountService() {
		int sum = memberRegistrationDao.selectCount();
		return sum;
	}

	
	/**
	 * 查询Breaking会员总数
	 * @return
	 */
	@Override
	public int selectCountByBreakingService() {
		int sumBreaking = memberRegistrationDao.selectCountByBreaking();
		return sumBreaking;
	}

	
	/**
	 * 查询Poppin会员总数
	 * @return
	 */
	@Override
	public int selectCountByPoppinService() {
		int sumPoppin = memberRegistrationDao.selectCountByPoppin();
		return sumPoppin;
	}

	/**
	 * 查询Locking会员总数
	 * @return
	 */
	@Override
	public int selectCountByLockingService() {
		int sumLocking = memberRegistrationDao.selectCountByLocking();
		return sumLocking;
	}

	/**
	 * 查询Hiphop会员总数
	 * @return
	 */
	@Override
	public int selectCountByHiphopService() {
		int sumHiphop = memberRegistrationDao.selectCountByHiphop();
		return sumHiphop;
	}

	/**
	 * 查询Jazz会员总数
	 * @return
	 */
	@Override
	public int selectCountByJazzService() {
		int sumJazz = memberRegistrationDao.selectCountByJazz();
		return sumJazz;
	}

	/**
	 * 查询Shuffle会员总数
	 * @return
	 */
	@Override
	public int selectCountByShuffleService() {
		int sumShuffle = memberRegistrationDao.selectCountByShuffle();
		return sumShuffle;
	}

	/**
	 * 查询Urban会员总数
	 * @return
	 */
	@Override
	public int selectCountByUrbanService() {
		int sumUrban = memberRegistrationDao.selectCountByUrban();
		return sumUrban;
	}

	/**
	 * 查询Wacking会员总数
	 * @return
	 */
	@Override
	public int selectCountByWackingService() {
		int sumWacking = memberRegistrationDao.selectCountByWacking();
		return sumWacking;
	}



	
}
