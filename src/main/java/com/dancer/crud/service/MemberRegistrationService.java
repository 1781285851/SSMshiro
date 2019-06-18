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
	 * ���ݸ������֤���Ų�ѯ�û�
	 * @param IdentityCard
	 * @return
	 */
	@Override
	public MemberRegistration selectMenberByIdentityCardService(String IdentityCard) {
		MemberRegistration member = memberRegistrationDao.selectMenberByIdentityCard(IdentityCard);
		return member;
	}
	
	
	/**
	 * ��ӻ�Ա  ���жϸĻ�Ա�Ƿ���ڣ���������������
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
	 * ��ѯ���л�Ա����
	 * @return
	 */
	@Override
	public int selectCountService() {
		int sum = memberRegistrationDao.selectCount();
		return sum;
	}

	
	/**
	 * ��ѯBreaking��Ա����
	 * @return
	 */
	@Override
	public int selectCountByBreakingService() {
		int sumBreaking = memberRegistrationDao.selectCountByBreaking();
		return sumBreaking;
	}

	
	/**
	 * ��ѯPoppin��Ա����
	 * @return
	 */
	@Override
	public int selectCountByPoppinService() {
		int sumPoppin = memberRegistrationDao.selectCountByPoppin();
		return sumPoppin;
	}

	/**
	 * ��ѯLocking��Ա����
	 * @return
	 */
	@Override
	public int selectCountByLockingService() {
		int sumLocking = memberRegistrationDao.selectCountByLocking();
		return sumLocking;
	}

	/**
	 * ��ѯHiphop��Ա����
	 * @return
	 */
	@Override
	public int selectCountByHiphopService() {
		int sumHiphop = memberRegistrationDao.selectCountByHiphop();
		return sumHiphop;
	}

	/**
	 * ��ѯJazz��Ա����
	 * @return
	 */
	@Override
	public int selectCountByJazzService() {
		int sumJazz = memberRegistrationDao.selectCountByJazz();
		return sumJazz;
	}

	/**
	 * ��ѯShuffle��Ա����
	 * @return
	 */
	@Override
	public int selectCountByShuffleService() {
		int sumShuffle = memberRegistrationDao.selectCountByShuffle();
		return sumShuffle;
	}

	/**
	 * ��ѯUrban��Ա����
	 * @return
	 */
	@Override
	public int selectCountByUrbanService() {
		int sumUrban = memberRegistrationDao.selectCountByUrban();
		return sumUrban;
	}

	/**
	 * ��ѯWacking��Ա����
	 * @return
	 */
	@Override
	public int selectCountByWackingService() {
		int sumWacking = memberRegistrationDao.selectCountByWacking();
		return sumWacking;
	}



	
}
