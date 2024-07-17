package com.usecase.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.usecase.entity.AccountEntity;
import com.usecase.entity.UserDetailsEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.repo.AccountRepo;
import com.usecase.repo.UserRegistrationRepo;
import com.usecase.service.AccountServiceImpl;

@SpringBootTest
public class GetAccountByUserIdTest {

	@BeforeEach
	public void setup() {

	}

	@MockBean
	AccountRepo accountRepo;
	@MockBean
	UserRegistrationRepo userRegisterRepo;
	@Autowired
	AccountServiceImpl service;

	@Test
	@DisplayName("Test - show User details by accountNo - successful")
	public void correctObjectPassed() {
		int accountNo = 123;
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");

		AccountEntity accountEntity = new AccountEntity(123, user);

		AccountEntity acc = new AccountEntity();
		Mockito.when(accountRepo.saveAndFlush(accountEntity)).thenReturn(accountEntity);
		try {
			acc = service.getAccountByAccountNo(accountNo);
			assertEquals(accountEntity.getAccountNo(), accountNo);

		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	@DisplayName("Test - show User details by accountNo - successful")
	public void correctObjectPassed2() {
		int accountNo = 123;
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");

		AccountEntity accountEntity = new AccountEntity(123, user);

		AccountEntity acc = new AccountEntity();
		Mockito.when(accountRepo.saveAndFlush(accountEntity)).thenReturn(accountEntity);
		try {
			acc = service.getAccountByAccountNo(accountNo);
			assertEquals(accountEntity.getAccountNo(), accountNo);
			assertNotEquals(accountEntity, user);

		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// NO EMAIL ENTERED
	@Test
	@DisplayName("Show User details by AccountNo- no account number entered")
	public void accountNoNotPassed() {
		int accountNo = 0;
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		AccountEntity accountEntity = new AccountEntity(123, user);

		AccountEntity acc = new AccountEntity();
		Mockito.when(accountRepo.saveAndFlush(accountEntity)).thenReturn(accountEntity);
		try {
			acc = service.getAccountByAccountNo(accountNo);

		} catch (RecordNotFoundException e) {
			assertEquals(e.getMessage(), "Record doesn't exist");
		}

	}

	@Test
	@DisplayName("Show User details by AccountNo- no account number entered")
	public void accountNoNotPassed2() {
		int accountNo = 0;
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		AccountEntity accountEntity = new AccountEntity(123, user);

		AccountEntity acc = new AccountEntity();
		Mockito.when(accountRepo.saveAndFlush(accountEntity)).thenReturn(accountEntity);
		try {
			acc = service.getAccountByAccountNo(accountNo);

		} catch (RecordNotFoundException e) {
			assertNotEquals(e.getMessage(), "Record  exist");
		}

	}

}
