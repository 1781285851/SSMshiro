package com.dancer.crud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dancer.crud.entity.MemberRegistration;
import com.dancer.crud.entity.MemberRegistrationVo;
import com.dancer.crud.entity.MemberVo;

@Repository
public interface MemberRegistrationDao {
	
	/**
	 * 添加会员
	 * @param memberRegistration
	 * @return
	 */
	int insertMenber(MemberRegistration memberRegistration);
	
	/**
	 * 添加照片地址信息
	 * @param memberRegistration
	 * @return
	 */
	int insertPhoto(MemberRegistration memberRegistration);
	
	/**
	 * 删除用户（将状态改为1）
	 * @param IdentityCard
	 * @return
	 */
	int deleteMem(String IdentityCard);
	
	/**
	 * 根据身份号码查询该会员是否存在
	 * @param IdentityCard
	 * @return
	 */
	MemberRegistration selectMenberByIdentityCard(String IdentityCard);
	
	/**
	 * 查询会员总数
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
	
	/**
	 * 根据条件查询会员数据
	 * @param memberRegistrationVo
	 * @return
	 */
	List<MemberRegistrationVo> selectMenber(@Param("ClubCard") String ClubCard,
											@Param("Name") String Name,
											@Param("Administrator") String Administrator,
											@Param("Phone") String Phone,
											@Param("IdentityCard") String IdentityCard,
											@Param("Gender") String Gender,
											@Param("DanceTypesId") String DanceTypesId,
											@Param("Startdate") String Startdate,
											@Param("Enddate") String Enddate
											);
	
}
