package com.usecase.model;

import java.util.List;

public class CreateAccountResponse {
 private List<Account> accountList;

public CreateAccountResponse(List<Account> accountList) {
	super();
	this.accountList = accountList;
}

public List<Account> getAccountList() {
	return accountList;
}

public void setAccountList(List<Account> accountList) {
	this.accountList = accountList;
}
 
 
}
