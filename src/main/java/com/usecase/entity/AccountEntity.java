package com.usecase.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class AccountEntity {

	@Id
	@Column(name = "account_no")
	private int accountNo;

	@JoinColumn(name = "user_id")
	@OneToOne(cascade = CascadeType.ALL)
	private UserDetailsEntity user;

	public AccountEntity() {
	}

	public AccountEntity(int accountNo, UserDetailsEntity user) {
		super();
		this.accountNo = accountNo;
		this.user = user;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public UserDetailsEntity getUser() {
		return user;
	}

	public void setUser(UserDetailsEntity user) {
		this.user = user;
	}

}
