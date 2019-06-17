package com.dancer.crud.entity;

import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository
public class MemberRegistration {
	private Integer Id;
	//��Ա��
	private String ClubCard;
	//����
	private String Name;
	//�Ա�
	private String Gender;
	//����id
	private Integer DanceTypesId;
	//���֤����
	private String IdentityCard;
	//�绰
	private String Phone;
	//qq
	private String QQ;
	//΢��
	private String Wechat;
	//����ʱ��
	private Date CreationTime;
	//����Ա
	private String Administrator;
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
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
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getWechat() {
		return Wechat;
	}
	public void setWechat(String wechat) {
		Wechat = wechat;
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
