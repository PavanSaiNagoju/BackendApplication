package com.usecase.model;

public class Account {
	private int accountNo;	
	private UserDetails user;
	
	public Account() {
		
	}
	public Account(int accountNo, UserDetails user) {
		super();
		this.accountNo = accountNo;
		this.user = user;
	}
	
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	
	
}
