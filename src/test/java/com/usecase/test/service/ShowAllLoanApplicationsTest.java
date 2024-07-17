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

import com.usecase.entity.LoanApplicationEntity;
import com.usecase.entity.UserDetailsEntity;
import com.usecase.entity.UserRegistrationEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.repo.LoanApplicationRepo;
import com.usecase.service.LoanApplicationServiceImpl;

@SpringBootTest
public class ShowAllLoanApplicationsTest {

	@BeforeEach
	public void setup() {

	}

	@MockBean
	LoanApplicationRepo loanRepo;

	@Autowired
	LoanApplicationServiceImpl loanService;

//All loan applications shown successfully
	@Test
	@DisplayName("Show All Loan Applications - successful")
	public void showAllLoanApplicationsSuccessfull() throws RecordNotFoundException {

		List<LoanApplicationEntity> list = new ArrayList<LoanApplicationEntity>();

		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");

		UserRegistrationEntity userRegister = new UserRegistrationEntity("hello@gmail.com", 21, "M", "9856435672",
				"abc", "hello", user);

		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);

		LoanApplicationEntity loan1 = new LoanApplicationEntity("30-11/8", 800000.0, 10, 5.0, 8000000, "06-06-2024",
				"Pending", user);

		Mockito.when(loanRepo.findAll()).thenReturn(Arrays.asList(loan, loan1));
		list = loanService.showAllLoanApplications();
		assertEquals(list.size(), 2);

	}
	
	@Test
	@DisplayName("Show All Loan Applications - successful")
	public void showAllLoanApplicationsSuccessfull1() throws RecordNotFoundException {

		List<LoanApplicationEntity> list = new ArrayList<LoanApplicationEntity>();

		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");

		UserRegistrationEntity userRegister = new UserRegistrationEntity("hello@gmail.com", 21, "M", "9856435672",
				"abc", "hello", user);

		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);

		LoanApplicationEntity loan1 = new LoanApplicationEntity("30-11/8", 800000.0, 10, 5.0, 8000000, "06-06-2024",
				"Pending", user);

		Mockito.when(loanRepo.findAll()).thenReturn(Arrays.asList(loan, loan1));
		list = loanService.showAllLoanApplications();
		assertNotEquals(list.size(), 1);

	}

//No loan applications found
	@Test
	@DisplayName("Show All Loan Applications - no loan applications found")
	public void noLoanApplicationFound() {

		List<LoanApplicationEntity> list = new ArrayList<LoanApplicationEntity>();

		List<LoanApplicationEntity> returnedList = new ArrayList<LoanApplicationEntity>();

		try {
			Mockito.when(loanRepo.findAll()).thenReturn(list);
			returnedList = loanService.showAllLoanApplications();
			assertEquals(list, returnedList);
		} catch (RecordNotFoundException e) {

			assertEquals(e.getMessage(), "No Loan Applications available");
		}

	}
	
	@Test
	@DisplayName("Show All Loan Applications - no loan applications found")
	public void noLoanApplicationFound1() {

		List<LoanApplicationEntity> list = new ArrayList<LoanApplicationEntity>();

		List<LoanApplicationEntity> returnedList = new ArrayList<LoanApplicationEntity>();

		try {
			Mockito.when(loanRepo.findAll()).thenReturn(list);
			returnedList = loanService.showAllLoanApplications();
			assertEquals(list, returnedList);
		} catch (RecordNotFoundException e) {

			assertNotEquals(e.getMessage(), "No Loan available");
		}

	}

}
