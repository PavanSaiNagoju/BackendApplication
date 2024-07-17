package com.usecase.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan")
public class LoanApplicationEntity {

	@Id
	@Column(name = "door_no", length = 20)
	private String doorNo;

	@Column(name = "existing_emi")
	private double existingEMI;

	@Column(name = "loan_tenure")
	private int tenure;

	@Column(name = "loan_interest")
	private double interest;

	@Column(name = "loan_amount")
	private double amount;

	@Column(name = "loan_application_date")
	private String appdate;

	@Column(name = "loan_application_status", length = 20)
	private String status = "Pending";

	

	@JoinColumn(name = "user_id")
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE })
	private UserDetailsEntity user;

	public LoanApplicationEntity() {
		super();
	}

	public LoanApplicationEntity(String doorNo, double existingEMI, int tenure, double interest, double amount,
			String appdate, String status, UserDetailsEntity user) {
		super();
		this.doorNo = doorNo;
		this.existingEMI = existingEMI;
		this.tenure = tenure;
		this.interest = interest;
		this.amount = amount;
		this.appdate = appdate;
		this.status = status;
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


	public UserDetailsEntity getUser() {
		return user;
	}

	public void setUser(UserDetailsEntity user) {
		this.user = user;
	}

}