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
import com.usecase.exception.RecordNotFoundException;
import com.usecase.repo.LoanApplicationRepo;
import com.usecase.service.LoanApplicationServiceImpl;

@SpringBootTest
public class ShowAllAcceptedLoansTest {
	@BeforeEach
	public void setup() {

	}

	@MockBean
	LoanApplicationRepo loanRepo;

	@Autowired
	LoanApplicationServiceImpl loanService;

	/* Test case for no Accepted Loans */

	@Test
	@DisplayName("Show All Accepted Loans - No Accepted Loans")
	public void showNoRejectedLoans() {
		List<LoanApplicationEntity> loans = new ArrayList<LoanApplicationEntity>();
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);
		try {
			Mockito.when(loanRepo.showAllAcceptedLoans()).thenReturn(loans);
			loans = loanService.getAllAcceptedLoans();
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block

			assertEquals(e.getMessage(), "No Approved Loans");
		}

	}
	
	@Test
	@DisplayName("Show All Accepted Loans - No Accepted Loans")
	public void showNoRejectedLoans1() {
		List<LoanApplicationEntity> loans = new ArrayList<LoanApplicationEntity>();
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);
		try {
			Mockito.when(loanRepo.showAllAcceptedLoans()).thenReturn(loans);
			loans = loanService.getAllAcceptedLoans();
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block

			assertNotEquals(e.getMessage(), "No Loans");
		}

	}

	/* Test Case for one accepted loans */

	@Test
	@DisplayName("Show All Accepted Loans - Accepted Loans exists")
	public void pendingLoansExists() {
		List<LoanApplicationEntity> loans2 = new ArrayList<LoanApplicationEntity>();
		UserDetailsEntity user = new UserDetailsEntity(2345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Approved", user);

		try {
			Mockito.when(loanRepo.showAllAcceptedLoans()).thenReturn(Arrays.asList(loan));
			loans2 = loanService.getAllAcceptedLoans();
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(1, loans2.size());

	}
	
	@Test
	@DisplayName("Show All Accepted Loans - Accepted Loans exists")
	public void pendingLoansExists1() {
		List<LoanApplicationEntity> loans2 = new ArrayList<LoanApplicationEntity>();
		UserDetailsEntity user = new UserDetailsEntity(2345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Approved", user);

		try {
			Mockito.when(loanRepo.showAllAcceptedLoans()).thenReturn(Arrays.asList(loan));
			loans2 = loanService.getAllAcceptedLoans();
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotEquals(2, loans2.size());

	}

}