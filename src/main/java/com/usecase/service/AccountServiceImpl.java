package com.usecase.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.usecase.entity.AccountEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.repo.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService {

	public static Logger log = Logger.getLogger(AccountServiceImpl.class.getName());

	@Autowired
	private AccountRepo accountRepo;

	@Override
	public List<AccountEntity> addAccount(AccountEntity account) throws RecordNotFoundException {
		log.info("Service Layer - Entry - addAccountDetails");
		try {
			if (account.getAccountNo() == 0) {
				log.warn("WARN: AccountNumber Should not be empty");
				throw new RecordNotFoundException("Account number should not be null");
			}
			account = accountRepo.save(account);
			return accountRepo.findAll();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
		}

	}

	@Override
	public List<AccountEntity> updateAccount(AccountEntity account) throws RecordNotFoundException {
		log.info("Service Layer - Entry - UpdateAccountDetails");
		try {
			if (account.getAccountNo() == 0) {
				log.warn("WARN: AccountNumber Should not be empty");
				throw new RecordNotFoundException("No Accounts Found");
			}
			accountRepo.save(account);
			return accountRepo.findAll();

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
		}
	}

	@Override
	public AccountEntity getAccountByAccountNo(int accountNo) throws RecordNotFoundException {
		log.info("Service Layer - Entry - AccountDetails");
		Optional<AccountEntity> account = accountRepo.findById(accountNo);
		if (!account.isPresent()) {
			log.warn("WARN: Account Should not be empty");
			throw new RecordNotFoundException("Record doesn't exist");
		}

		return account.get();

	}

}
