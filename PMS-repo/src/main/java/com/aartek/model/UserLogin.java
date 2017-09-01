package com.aartek.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_LOGIN")
public class UserLogin {

	@Id
	@Column(name="mailId",length = 25)
	private String mailId;

	@Column(name="PASS",length=10)
	private String pass;
	@Column(name="F_NAME",length=20)
	private String fName;
	
	@Column(name="L_NAME",length=10)
	private String lName;
	
	@Column(name="MOB",length=10)
	private String mob;
	
	@OneToOne(targetEntity=AddressDto.class,cascade=CascadeType.ALL)
	@JoinColumn(name="emailId")
	private AddressDto address=null;
	
	
	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}
}
