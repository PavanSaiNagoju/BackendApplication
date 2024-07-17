package com.usecase.service;

import java.util.List;

import com.usecase.entity.AccountEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.model.Account;
import com.usecase.model.CreateAccountResponse;

public interface AccountService {
	
	public AccountEntity getAccountByAccountNo(int accountNo) throws RecordNotFoundException;
    public List<AccountEntity> addAccount(AccountEntity account) throws RecordNotFoundException;
	//public CreateAccountResponse AddAccount(Account account) throws GlobalException;
    public List<AccountEntity> updateAccount(AccountEntity account)throws RecordNotFoundException;


}
