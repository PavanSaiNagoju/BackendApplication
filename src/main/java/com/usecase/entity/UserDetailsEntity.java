package com.usecase.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserDetailsEntity {
	public UserDetailsEntity() {
		super();
	}

	@Id
	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_address")
	private String address;

	@Column(name = "user_state")
	private String state;

	@Column(name = "user_city", length = 20)
	private String city;

	@Column(name = "user_pin", length = 20)
	private String pin;

	@Column(name = "user_emptype", length = 20)
	private String emptype;

	@Column(name = "user_salary")
	private double salary;

	@Column(name = "user_aadhar", length = 20)
	private String aadhar;

	@Column(name = "user_pan", length = 20)
	private String pan;

	@Column(name = "user_salary_slip", length = 20)
	private String salarySlip;

	@Column(name = "user_address_proof", length = 20)
	private String addressProof;

	public UserDetailsEntity(int userId, String address, String state, String city, String pin, String emptype,
			double salary, String aadhar, String pan, String salarySlip, String addressProof) {
		super();
		this.userId = userId;
		this.address = address;
		this.state = state;
		this.city = city;
		this.pin = pin;
		this.emptype = emptype;
		this.salary = salary;
		this.aadhar = aadhar;
		this.pan = pan;
		this.salarySlip = salarySlip;
		this.addressProof = addressProof;

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getEmptype() {
		return emptype;
	}

	public void setEmptype(String emptype) {
		this.emptype = emptype;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getSalarySlip() {
		return salarySlip;
	}

	public void setSalarySlip(String salarySlip) {
		this.salarySlip = salarySlip;
	}

	public String getAddressProof() {
		return addressProof;
	}

	public void setAddressProof(String addressProof) {
		this.addressProof = addressProof;
	}

}
