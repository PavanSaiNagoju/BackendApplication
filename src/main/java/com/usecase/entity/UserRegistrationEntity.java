package com.usecase.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_registration")
public class UserRegistrationEntity {

	@Id
	@Column(name = "user_email", length = 20)
	private String email;

	@Column(name = "user_name", length = 20)
	private String name;

	@Column(name = "user_gender", length = 20)
	private String gender;

	@Column(name = "user_mobile", length = 20)
	private String mobile;

	@Column(name = "user_age")
	private int age;

	@Column(name = "user_password", length = 20)
	private String password;

	@JoinColumn(name = "user_id")
	@OneToOne(cascade = CascadeType.ALL)
	private UserDetailsEntity userdetails;

	public UserRegistrationEntity() {
		super();
	}

	public UserRegistrationEntity(String email, int age, String gender, String mobile, String name, String password,
			UserDetailsEntity userdetails) {
		super();
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.mobile = mobile;
		this.name = name;
		this.password = password;
		this.userdetails = userdetails;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDetailsEntity getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserDetailsEntity userdetails) {
		this.userdetails = userdetails;
	}
}
