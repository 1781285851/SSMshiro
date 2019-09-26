package com.dancer.crud.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dancer.crud.dao.MemberRegistrationDao;
import com.dancer.crud.entity.MemberRegistration;
import com.dancer.crud.entity.MemberRegistrationVo;
import com.dancer.crud.entity.MemberVo;

@Service
public class MemberRegistrationService{
	
	@Autowired
	MemberRegistrationDao memberRegistrationDao;
	
	@Autowired
	MemberRegistration memberRegistration;
	
	/**
	 * 根据身份号码查询该会员是否存在
	 * @param IdentityCard
	 * @return
	 */
	public MemberRegistration selectMenberByIdentityCardService(String IdentityCard) {
		MemberRegistration member = memberRegistrationDao.selectMenberByIdentityCard(IdentityCard);
		return member;
	}
	
	
	/**
	 * 添加会员
	 * @param memberRegistration
	 * @return
	 */
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
			//state状态0表示该用户未删除
			memberRegistration.setState("0");
			Date creationTime=new Date();
			memberRegistration.setCreationTime(creationTime);
			int num =  memberRegistrationDao.insertMenber(memberRegistration);
			return "success";
		}else{
			return "failed";
		}
	}
	
/**
 * 给用户添加照片	
 * @param file
 * @param IdentityCard
 * @param memberRegistration
 * @return
 * @throws IOException
 */
public String insertPhotoService(MultipartFile file, String IdentityCard,MemberRegistration memberRegistration) throws IOException {
		// 保存图片的路径，图片上传成功后，将路径保存到数据库
		String filePath = "E:\\imgs";
		// 获取原始图片的扩展名
		String originalFilename = file.getOriginalFilename();
		System.out.println("获取原始图片的扩展名:"+originalFilename);
		// 生成文件新的名字
		String newFileName = UUID.randomUUID() + originalFilename;
		System.out.println("生成文件新的名字:"+newFileName);
		// 封装上传文件位置的全路径
		File targetFile = new File(filePath, newFileName);
		System.out.println("封装上传文件位置的全路径："+targetFile);
		file.transferTo(targetFile);	
		String phoString = targetFile.toString();
		// 保存到数据库
		memberRegistration.setPhoto(phoString);
		memberRegistration.setIdentityCard(IdentityCard);
		memberRegistrationDao.insertPhoto(memberRegistration);
		return "ok";
	}

	/**
	 * 根据身份证号码删除用户
	 * @param IdentityCard
	 * @return
	 */
	public int deleteMemService(String IdentityCard) {
		int num = memberRegistrationDao.deleteMem(IdentityCard);
		System.out.println("service:"+num);
		return num;
	}


	
	/**
	 * 查询会员总数
	 * @return
	 */
	public int selectCountService() {
		int sum = memberRegistrationDao.selectCount();
		return sum;
	}

	
	/**
	 * 查询Breaking会员总数
	 * @return
	 */
	public int selectCountByBreakingService() {
		int sumBreaking = memberRegistrationDao.selectCountByBreaking();
		return sumBreaking;
	}

	
	/**
	 * 查询yPoppin会员总数
	 * @return
	 */
	public int selectCountByPoppinService() {
		int sumPoppin = memberRegistrationDao.selectCountByPoppin();
		return sumPoppin;
	}

	/**
	 * 查询Locking会员总数
	 * @return
	 */
	public int selectCountByLockingService() {
		int sumLocking = memberRegistrationDao.selectCountByLocking();
		return sumLocking;
	}

	/**
	 * 查询Hiphop会员总数
	 * @return
	 */
	public int selectCountByHiphopService() {
		int sumHiphop = memberRegistrationDao.selectCountByHiphop();
		return sumHiphop;
	}

	/**
	 * 查询Jazz会员总数
	 * @return
	 */
	public int selectCountByJazzService() {
		int sumJazz = memberRegistrationDao.selectCountByJazz();
		return sumJazz;
	}

	/**
	 * 查寻Shuffle会员总数
	 * @return
	 */
	public int selectCountByShuffleService() {
		int sumShuffle = memberRegistrationDao.selectCountByShuffle();
		return sumShuffle;
	}

	/**
	 * 查询Urban会员总数
	 * @return
	 */
	public int selectCountByUrbanService() {
		int sumUrban = memberRegistrationDao.selectCountByUrban();
		return sumUrban;
	}

	/**
	 * 查询Wacking会员总数
	 * @return
	 */
	public int selectCountByWackingService() {
		int sumWacking = memberRegistrationDao.selectCountByWacking();
		return sumWacking;
	}
	
	/**
	 * 根据条件查询会员数据
	 * @param memberVo
	 * @return
	 */
	public List<MemberRegistrationVo> selectMenberService(String ClubCard,String Name,
			 												String Administrator,String Phone,
			 												String IdentityCard,String Gender,
			 												String DanceTypesId,String Startdate,
			 												String Enddate) {
		List<MemberRegistrationVo> mem = memberRegistrationDao.selectMenber(ClubCard,Name,
				Administrator,Phone,IdentityCard,Gender,DanceTypesId,Startdate,Enddate);
		return mem;
	}

}
