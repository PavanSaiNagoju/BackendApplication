package com.usecase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.entity.AccountEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.service.AccountServiceImpl;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/homeloan")
public class AccountController {
	@Autowired
	private AccountServiceImpl service;

	// Adding an Account
	@PostMapping("/accounts")
	public ResponseEntity<List<AccountEntity>> insertAccount(@RequestBody AccountEntity account)
			throws RecordNotFoundException {
		List<AccountEntity> accounts;
		try {
			accounts = service.addAccount(account);
			return new ResponseEntity<List<AccountEntity>>(accounts, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// Get Account by AccountNumber
	@GetMapping("/accounts/{accountNo}")
	public ResponseEntity<AccountEntity> findAccount(@PathVariable("accountNo") int accountNo)
			throws RecordNotFoundException {
		try {
			AccountEntity accounts = service.getAccountByAccountNo(accountNo);

			return new ResponseEntity<AccountEntity>(accounts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Edit Account by AccountNumber
	@PutMapping("/account/{accountNo}")
	public ResponseEntity<List<AccountEntity>> updateAccount(@RequestBody AccountEntity account)
			throws RecordNotFoundException {

		try {
			List<AccountEntity> accounts = service.updateAccount(account);
			return new ResponseEntity<List<AccountEntity>>(accounts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
