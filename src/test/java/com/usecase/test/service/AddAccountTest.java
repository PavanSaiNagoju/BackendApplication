package com.usecase.test.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.usecase.entity.AccountEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.repo.AccountRepo;
import com.usecase.service.AccountServiceImpl;

@SpringBootTest
public class AddAccountTest {

	@MockBean
	AccountRepo accountRepo;

	@Autowired
	AccountServiceImpl accountService;

	@Test
	@DisplayName("addAccount ")
	public void testAddAccount_ValidAccount() throws RecordNotFoundException {
		// Create a mock AccountEntity
		AccountEntity account = new AccountEntity();
		account.setAccountNo(12345); // Set a valid account number

		// Mock behavior of save method
		when(accountRepo.save(any(AccountEntity.class))).thenReturn(account);

		// Call the method
		List<AccountEntity> accounts = accountService.addAccount(account);

		// Verify outcome
		assertNotNull(accounts);

	}

	@Test
	@DisplayName("addAccount - no accountNo")
	public void emailNotEntered2() throws RecordNotFoundException {
		int accountNo = 0;
		List<AccountEntity> account = null;

		try {
			account = accountService.addAccount(null);
		} catch (Exception e) {
			assertNotEquals(e.getMessage(), "Account number should not be null");

		}
	}

}
