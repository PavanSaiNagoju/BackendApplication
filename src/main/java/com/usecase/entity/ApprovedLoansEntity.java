package com.usecase.entity;

import java.time.LocalDate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "approved_loans")
public class ApprovedLoansEntity {
	public ApprovedLoansEntity() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "approved_loan_id")
	private int loanId;

	@Column(name = "emi_amount")
	private double emi;

	@Column(name = "emi_starting_date")
	private LocalDate emidate;

	@JoinColumn(name = "account_no")
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
	private AccountEntity account;

	@JoinColumn(name = "door_no")
	@OneToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
	private LoanApplicationEntity loanapp;

	public ApprovedLoansEntity(int loanId, double emi, LocalDate emidate, AccountEntity account,
			LoanApplicationEntity loanapp) {
		super();
		this.loanId = loanId;
		this.emi = emi;
		this.emidate = emidate;
		this.account = account;
		this.loanapp = loanapp;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public double getEmi() {
		return emi;
	}

	public void setEmi(double emi) {
		this.emi = emi;
	}

	public LocalDate getEmidate() {
		return emidate;
	}

	public void setEmidate(LocalDate emidate) {
		this.emidate = emidate;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

	public LoanApplicationEntity getLoanapp() {
		return loanapp;
	}

	public void setLoanapp(LoanApplicationEntity loanapp) {
		this.loanapp = loanapp;
	}

}