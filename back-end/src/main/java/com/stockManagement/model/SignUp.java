package com.stockManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="signup")
public class SignUp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	 
	@Column(name = "fullName")
	private String fullName;
	
	@Column(name = "mobile")
	private String  mobile;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;

	public SignUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SignUp(String fullName, String mobile, String email, String password) {
		super();
		this.fullName = fullName;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SignUp [id=" + id + ", fullName=" + fullName + ", mobile=" + mobile + ", email=" + email + ", password="
				+ password + "]";
	}
	
	
	
	
	

}
