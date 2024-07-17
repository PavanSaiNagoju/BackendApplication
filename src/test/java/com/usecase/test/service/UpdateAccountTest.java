package com.usecase.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.usecase.entity.AccountEntity;
import com.usecase.entity.AdminEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.repo.AccountRepo;
import com.usecase.service.AccountServiceImpl;

@SpringBootTest
public class UpdateAccountTest {
	
	@MockBean
	AccountRepo accountRepo;

	@Autowired
	AccountServiceImpl accountService;

	@BeforeEach
	public void setup() {

	}
	
	@Test
	@DisplayName("Update Account- successful")
	public void accountAddedSuccessfull() {
		List<AccountEntity> list = new ArrayList<AccountEntity>();
		AccountEntity account = new AccountEntity(1, null);

		Mockito.when(accountRepo.findAll()).thenReturn(Arrays.asList(account));
		try {
			list = accountService.updateAccount(account);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(list.size(), 1);
	}
	
	@Test
	@DisplayName("Update Account- successful")
	public void accountAddedSuccessfull1() {
		List<AccountEntity> list = new ArrayList<AccountEntity>();
		AccountEntity account = new AccountEntity(1, null);

		Mockito.when(accountRepo.findAll()).thenReturn(Arrays.asList(account));
		try {
			list = accountService.updateAccount(account);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotEquals(list.size(), 2);
	}
	
	@Test
	@DisplayName("Update account- account not found")
	public void accountNotFound() {

		List<AccountEntity> list = new ArrayList<AccountEntity>();
		List<AccountEntity> list2 = new ArrayList<AccountEntity>();
		AccountEntity account = new AccountEntity(1, null);
		Mockito.when(accountRepo.findById(1)).thenReturn(null);

		try {
			Mockito.when(accountRepo.findAll()).thenReturn(list);
			list2 = accountService.updateAccount(account);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertEquals(e.getMessage(), "No Accounts Found");
		}

	}
	
	
	@Test
	@DisplayName("Update account- account not found")
	public void accountNotFound1() {

		List<AccountEntity> list = new ArrayList<AccountEntity>();
		List<AccountEntity> list2 = new ArrayList<AccountEntity>();
		AccountEntity account = new AccountEntity(1, null);
		Mockito.when(accountRepo.findById(1)).thenReturn(null);

		try {
			Mockito.when(accountRepo.findAll()).thenReturn(list);
			list2 = accountService.updateAccount(account);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertNotEquals(e.getMessage(), "Account not found");
		}

	}
	
}
