package com.usecase.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.usecase.entity.LoanApplicationEntity;
import com.usecase.entity.UserDetailsEntity;
import com.usecase.entity.UserRegistrationEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.repo.LoanApplicationRepo;
import com.usecase.repo.UserRegistrationRepo;
import com.usecase.service.LoanApplicationServiceImpl;

@SpringBootTest
public class ShowRejectedLoansByEmailTest {

	@BeforeEach
	public void setup() {

	}

	@MockBean
	UserRegistrationRepo userRepo;

	@MockBean
	LoanApplicationRepo loanRepo;

	@Autowired
	LoanApplicationServiceImpl loanService;

//Successfully shown rejected loan applications by email
	@Test
	@DisplayName("Show Rejected Loan Application By Email- successful")
	public void RejectedLoanApplicationByEmailSuccessfull() throws RecordNotFoundException {
		String email = "hello@gmail.com";

		List<LoanApplicationEntity> list = new ArrayList<LoanApplicationEntity>();

		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu",
				"Chennai", "600073", "Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");

		UserRegistrationEntity userRegister = new UserRegistrationEntity("hello@gmail.com", 21, "M", "9856435672",
				"abc", "hello", user);

		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024", "Rejected", user);

		LoanApplicationEntity loan1 = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Rejected", user);

		Mockito.when(loanRepo.showAllRejectedLoansByEmail(email)).thenReturn(Arrays.asList(loan, loan1));
		list = loanService.showRejectedLoansByEmail(email);
		assertEquals(list.size(), 2);

	}
	
	@Test
	@DisplayName("Show Rejected Loan Application By Email- successful")
	public void RejectedLoanApplicationByEmailSuccessfull2() throws RecordNotFoundException {
		String email = "hello@gmail.com";

		List<LoanApplicationEntity> list = new ArrayList<LoanApplicationEntity>();

		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu",
				"Chennai", "600073", "Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");

		UserRegistrationEntity userRegister = new UserRegistrationEntity("hello@gmail.com", 21, "M", "9856435672",
				"abc", "hello", user);

		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024", "Rejected", user);

		LoanApplicationEntity loan1 = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Rejected", user);

		Mockito.when(loanRepo.showAllRejectedLoansByEmail(email)).thenReturn(Arrays.asList(loan, loan1));
		list = loanService.showRejectedLoansByEmail(email);
		assertNotEquals(list.size(), 5);

	}

//No rejected loan applications found
	@Test
	@DisplayName("Show Rejected Loan Application By Email- no loan applications found")
	public void noRejectedLoanApplicationsFound() {
		String email = "hello@gmail.com";

		List<LoanApplicationEntity> list = new ArrayList<LoanApplicationEntity>();

		List<LoanApplicationEntity> returnedList = new ArrayList<LoanApplicationEntity>();

		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai",
				"600073", "Full time", 5000000.0, "Yes", "Yes", "sYes", "Yes");

		UserRegistrationEntity userRegister = new UserRegistrationEntity("hello@gmail.com", 21, "M", "9856435672",
				"abc", "hello", user);

		Mockito.when(userRepo.saveAndFlush(userRegister)).thenReturn(userRegister);

		try {
			Mockito.when(loanRepo.showAllRejectedLoansByEmail(email)).thenReturn(list);
			returnedList = loanService.showRejectedLoansByEmail(email);
			assertEquals(list, returnedList);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block

			assertEquals(e.getMessage(), "No Rejected loans found");
			
		}

	}
	
	@Test
	@DisplayName("Show Rejected Loan Application By Email- no loan applications found")
	public void noRejectedLoanApplicationsFound1() {
		String email = "hello@gmail.com";

		List<LoanApplicationEntity> list = new ArrayList<LoanApplicationEntity>();

		List<LoanApplicationEntity> returnedList = new ArrayList<LoanApplicationEntity>();

		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai",
				"600073", "Full time", 5000000.0, "Yes", "Yes", "sYes", "Yes");

		UserRegistrationEntity userRegister = new UserRegistrationEntity("hello@gmail.com", 21, "M", "9856435672",
				"abc", "hello", user);

		Mockito.when(userRepo.saveAndFlush(userRegister)).thenReturn(userRegister);

		try {
			Mockito.when(loanRepo.showAllRejectedLoansByEmail(email)).thenReturn(list);
			returnedList = loanService.showRejectedLoansByEmail(email);
			assertEquals(list, returnedList);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block

			assertNotEquals(e.getMessage(), "No loans found");
		}

	}

//Email not entered
	@Test
	@DisplayName("Show Rejected Loan Applications By Email- no email entered")
	public void nullEmailEntered() {
		String email = null;

		List<LoanApplicationEntity> list = new ArrayList<LoanApplicationEntity>();

		List<LoanApplicationEntity> returnedList = new ArrayList<LoanApplicationEntity>();

		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai",
				"600073", "Full time", 5000000.0, "Yes", "Yes", "sYes", "Yes");

		UserRegistrationEntity userRegister = new UserRegistrationEntity(null, 21, "M", "9856435672", "abc", "hello",
				user);

		try {
			Mockito.when(loanRepo.showAllRejectedLoansByEmail(email)).thenReturn(list);
			returnedList = loanService.showRejectedLoansByEmail(email);
			assertEquals(list, returnedList);
		} catch (Exception e) {
			assertNotNull(e.getMessage());
		}

	}
	
	@Test
	@DisplayName("Show Rejected Loan Applications By Email- no email entered")
	public void nullEmailEntered1() {
		String email = null;

		List<LoanApplicationEntity> list = new ArrayList<LoanApplicationEntity>();

		List<LoanApplicationEntity> returnedList = new ArrayList<LoanApplicationEntity>();

		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai",
				"600073", "Full time", 5000000.0, "Yes", "Yes", "sYes", "Yes");

		UserRegistrationEntity userRegister = new UserRegistrationEntity(null, 21, "M", "9856435672", "abc", "hello",
				user);

		try {
			Mockito.when(loanRepo.showAllRejectedLoansByEmail(email)).thenReturn(list);
			returnedList = loanService.showRejectedLoansByEmail(email);
			assertNotEquals(list, userRegister);
		} catch (Exception e) {
			assertNotNull(e.getMessage());
		}

	}
}
