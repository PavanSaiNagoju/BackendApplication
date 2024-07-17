package com.usecase.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.usecase.entity.AccountEntity;
import com.usecase.entity.ApprovedLoansEntity;
import com.usecase.entity.UserDetailsEntity;
import com.usecase.entity.UserRegistrationEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.repo.ApprovedLoanRepo;
import com.usecase.repo.UserRegistrationRepo;
import com.usecase.service.ApprovedLoanServiceImpl;

@SpringBootTest
public class ShowAllApprovedByEmailTest {
	@BeforeEach
	public void setup() {
	}

	@MockBean
	ApprovedLoanRepo approvedRepo;

	@MockBean
	UserRegistrationRepo userRepo;

	@Autowired
	ApprovedLoanServiceImpl approvedService;

	// CORRECT EMAIL ENTERED
	@Test
	@DisplayName("Test - showAllApprovedByEmail - successful")
	public void showApprovedByEmailSuccessfull2() throws RecordNotFoundException {

		String email = "pavan@gmail.com";
		List<ApprovedLoansEntity> list = new ArrayList<>();
		List<ApprovedLoansEntity> returnlist = new ArrayList<>();
		UserDetailsEntity user = null;
		AccountEntity account = new AccountEntity(1452, user);
		UserRegistrationEntity userRegister = new UserRegistrationEntity("pavan@gmail.com", 21, "M", "9856435672",
				"abc", "hello", user);

		Mockito.when(userRepo.saveAndFlush(userRegister)).thenReturn(userRegister);
		Mockito.when(approvedRepo.showAllApprovedByEmail(email)).thenReturn(returnlist, null);

		try {
			returnlist = approvedService.showAllApprovedByEmail(email);
			assertNotNull(userRegister);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertEquals(e.getMessage(),"Email should not match");
		}

	}
	
	@Test
	@DisplayName("Test - showAllApprovedByEmail - successful")
	public void showApprovedByEmailSuccessfull() throws RecordNotFoundException {

		String email = "pavan@gmail.com";
		List<ApprovedLoansEntity> list = new ArrayList<>();
		List<ApprovedLoansEntity> returnlist = new ArrayList<>();
		UserDetailsEntity user = null;
		AccountEntity account = new AccountEntity(1452, user);
		UserRegistrationEntity userRegister = new UserRegistrationEntity("pavan@gmail.com", 21, "M", "9856435672",
				"abc", "hello", user);

		Mockito.when(userRepo.saveAndFlush(userRegister)).thenReturn(userRegister);
		Mockito.when(approvedRepo.showAllApprovedByEmail(email)).thenReturn(returnlist, null);

		try {
			returnlist = approvedService.showAllApprovedByEmail(email);
			assertNotNull(userRegister);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertNotEquals(e.getMessage(),"Email  no match");
		}

	}
	
	

	// NO EMAIL FOUND
	@Test
	@DisplayName("Test - showAllApprovedByEmail - no Email found")
	public void noEmailFound() {
		String email = "pavan@gmail.com";
		List<ApprovedLoansEntity> list = new ArrayList<>();
		List<ApprovedLoansEntity> returnlist = new ArrayList<>();
		UserDetailsEntity user = null;
		AccountEntity account = new AccountEntity(1452, user);
		UserRegistrationEntity userRegister = new UserRegistrationEntity("pavan@gmail.com", 21, "M", "9856435672",
				"abc", "hello", user);

		Mockito.when(userRepo.saveAndFlush(userRegister)).thenReturn(userRegister);
		Mockito.when(approvedRepo.showAllApprovedByEmail(email)).thenReturn(list);

		try {
			returnlist = approvedService.showAllApprovedByEmail(email);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertEquals(e.getMessage(), "Email should not match");
		}
	}
	
	@Test
	@DisplayName("Test - showAllApprovedByEmail - no Email found")
	public void noEmailFound2() {
		String email = "pavan@gmail.com";
		List<ApprovedLoansEntity> list = new ArrayList<>();
		List<ApprovedLoansEntity> returnlist = new ArrayList<>();
		UserDetailsEntity user = null;
		AccountEntity account = new AccountEntity(1452, user);
		UserRegistrationEntity userRegister = new UserRegistrationEntity("pavan@gmail.com", 21, "M", "9856435672",
				"abc", "hello", user);

		Mockito.when(userRepo.saveAndFlush(userRegister)).thenReturn(userRegister);
		Mockito.when(approvedRepo.showAllApprovedByEmail(email)).thenReturn(list);

		try {
			returnlist = approvedService.showAllApprovedByEmail(email);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertNotEquals(e.getMessage(), "Email not match");
		}
	}

	// WRONG EMAIL ENTERED
	@Test
	@DisplayName("Test - showAllApprovedByEmail - Wrong Email Entered")
	public void noEmailEntered() {
		String email = "WrongEmail";
		List<ApprovedLoansEntity> list = new ArrayList<>();
		List<ApprovedLoansEntity> returnlist = new ArrayList<>();
		UserDetailsEntity user = null;
		AccountEntity account = new AccountEntity(1452, user);
		UserRegistrationEntity userRegister = new UserRegistrationEntity("pavan@gmail.com", 21, "M", "9856435672",
				"abc", "hello", user);

		Mockito.when(userRepo.saveAndFlush(userRegister)).thenReturn(userRegister);
		Mockito.when(approvedRepo.showAllApprovedByEmail(email)).thenReturn(list);

		try {
			returnlist = approvedService.showAllApprovedByEmail(email);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertNotNull(e.getMessage());
			assertEquals(e.getMessage(), "Email should not match");

		}
	}

	
	@Test
	@DisplayName("Test - showAllApprovedByEmail - Wrong Email Entered")
	public void noEmailEntered2() {
		String email = "WrongEmail";
		List<ApprovedLoansEntity> list = new ArrayList<>();
		List<ApprovedLoansEntity> returnlist = new ArrayList<>();
		UserDetailsEntity user = null;
		AccountEntity account = new AccountEntity(1452, user);
		UserRegistrationEntity userRegister = new UserRegistrationEntity("pavan@gmail.com", 21, "M", "9856435672",
				"abc", "hello", user);

		Mockito.when(userRepo.saveAndFlush(userRegister)).thenReturn(userRegister);
		Mockito.when(approvedRepo.showAllApprovedByEmail(email)).thenReturn(list);

		try {
			returnlist = approvedService.showAllApprovedByEmail(email);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertNotNull(e.getMessage());
			assertNotEquals(e.getMessage(), "Email  not match");

		}
	}

}
