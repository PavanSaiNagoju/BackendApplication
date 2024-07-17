package com.usecase.model;


import com.usecase.entity.UserDetailsEntity;

public class LoanApplication {
	
	private String doorNo;
	private double existingEMI;
	
	private int tenure;
	private double interest;
	private double amount;
	private String appdate;
	private String status;
	private double squarefeet;
	private double governmentValue;
	private UserDetailsEntity user;
	
	public LoanApplication() {
		
	}
	
	public LoanApplication(String doorNo, double existingEMI, int tenure, double interest, double amount,
			String appdate, String status, double squarefeet, double governmentValue, UserDetailsEntity user) {
		super();
		this.doorNo = doorNo;
		this.existingEMI = existingEMI;
		this.tenure = tenure;
		this.interest = interest;
		this.amount = amount;
		this.appdate = appdate;
		this.status = status;
		this.squarefeet = squarefeet;
		this.governmentValue = governmentValue;
		this.user = user;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public double getExistingEMI() {
		return existingEMI;
	}

	public void setExistingEMI(double existingEMI) {
		this.existingEMI = existingEMI;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAppdate() {
		return appdate;
	}

	public void setAppdate(String appdate) {
		this.appdate = appdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getSquarefeet() {
		return squarefeet;
	}

	public void setSquarefeet(double squarefeet) {
		this.squarefeet = squarefeet;
	}

	public double getGovernmentValue() {
		return governmentValue;
	}

	public void setGovernmentValue(double governmentValue) {
		this.governmentValue = governmentValue;
	}

	public UserDetailsEntity getUser() {
		return user;
	}

	public void setUser(UserDetailsEntity user) {
		this.user = user;
	}
	

}
