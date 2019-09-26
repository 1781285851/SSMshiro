package com.dancer.crud.entity;

import java.util.Date;
//
public class MemberVo {
	private String ClubCard;
	private String Name;
	private String Administrator;
	private String Phone;
	private String IdentityCard;
	private String Gender;
	private Integer DanceTypesId;
	private String Startdate;
	private String Enddate;
	public String getClubCard() {
		return ClubCard;
	}
	public void setClubCard(String clubCard) {
		ClubCard = clubCard;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAdministrator() {
		return Administrator;
	}
	public void setAdministrator(String administrator) {
		Administrator = administrator;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getIdentityCard() {
		return IdentityCard;
	}
	public void setIdentityCard(String identityCard) {
		IdentityCard = identityCard;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public Integer getDanceTypesId() {
		return DanceTypesId;
	}
	public void setDanceTypesId(Integer danceTypesId) {
		DanceTypesId = danceTypesId;
	}
	public String getStartdate() {
		return Startdate;
	}
	public void setStartdate(String startdate) {
		Startdate = startdate;
	}
	public String getEnddate() {
		return Enddate;
	}
	public void setEnddate(String enddate) {
		Enddate = enddate;
	}
	
}
