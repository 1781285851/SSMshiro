package com.dancer.crud.entity;

import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository
public class Administrator {
    private Integer Id;

    private String Name;

    private String Uuid;

    private String Password;

    private Date Createtime;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getUuid() {
		return Uuid;
	}

	public void setUuid(String uuid) {
		Uuid = uuid;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Date getCreatetime() {
		return Createtime;
	}

	public void setCreatetime(Date createtime) {
		Createtime = createtime;
	}

    
}