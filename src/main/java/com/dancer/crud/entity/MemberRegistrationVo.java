package com.dancer.crud.entity;

import java.util.Date;

import org.springframework.stereotype.Repository;
@Repository
public class MemberRegistrationVo {
	//姓名
	private String Name;
	//性别
	private String Gender;
	//会员卡号
	private String ClubCard;
	//舞种名称
	private String DanceName;
	//身份证号码
	private String IdentityCard;
	//电话
	private String Phone;
	//创建时间
	private Date CreationTime;
	//注册人
	private String Administrator;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getClubCard() {
		return ClubCard;
	}
	public void setClubCard(String clubCard) {
		ClubCard = clubCard;
	}
	public String getDanceName() {
		return DanceName;
	}
	public void setDanceName(String danceName) {
		DanceName = danceName;
	}
	public String getIdentityCard() {
		return IdentityCard;
	}
	public void setIdentityCard(String identityCard) {
		IdentityCard = identityCard;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public Date getCreationTime() {
		return CreationTime;
	}
	public void setCreationTime(Date creationTime) {
		CreationTime = creationTime;
	}
	public String getAdministrator() {
		return Administrator;
	}
	public void setAdministrator(String administrator) {
		Administrator = administrator;
	}
	
}
