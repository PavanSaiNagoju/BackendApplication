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
public class ShowAllRejectedLoansTest {
	@BeforeEach
	public void setup() {

	}

	@MockBean
	LoanApplicationRepo loanRepo;

	@Autowired
	LoanApplicationServiceImpl loanService;

	/* Test case for no Rejected Loans */

	@Test
	@DisplayName("Show All Rejected Loans - No Rejected Loans")
	public void showNoRejectedLoans() {
		List<LoanApplicationEntity> loans = new ArrayList<LoanApplicationEntity>();
		List<LoanApplicationEntity> loans1 = new ArrayList<LoanApplicationEntity>();

		try {
			Mockito.when(loanRepo.showAllRejectedLoans()).thenReturn(loans);
			loans1 = loanService.getAllRejectedLoans();
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block

			assertEquals(e.getMessage(), "No Rejected Loans");
		}

	}
	
	@Test
	@DisplayName("Show All Rejected Loans - No Rejected Loans")
	public void showNoRejectedLoans1() {
		List<LoanApplicationEntity> loans = new ArrayList<LoanApplicationEntity>();
		List<LoanApplicationEntity> loans1 = new ArrayList<LoanApplicationEntity>();

		try {
			Mockito.when(loanRepo.showAllRejectedLoans()).thenReturn(loans);
			loans1 = loanService.getAllRejectedLoans();
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block

			assertNotEquals(e.getMessage(), "No Loans");
		}

	}

	/* Test case for one Rejected Loan */

	@Test
	@DisplayName("Show All Rejected Loans - Rejected Loans exists")
	public void pendingLoansExists() {
		List<LoanApplicationEntity> loans1 = new ArrayList<LoanApplicationEntity>();
		List<LoanApplicationEntity> loans = new ArrayList<LoanApplicationEntity>();
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);

		try {
			Mockito.when(loanRepo.showAllRejectedLoans()).thenReturn(Arrays.asList(loan));
			loans1 = loanService.getAllRejectedLoans();
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(loans1.size(), 1);

	}
	
	@Test
	@DisplayName("Show All Rejected Loans - Rejected Loans exists")
	public void pendingLoansExists1() {
		List<LoanApplicationEntity> loans1 = new ArrayList<LoanApplicationEntity>();
		List<LoanApplicationEntity> loans = new ArrayList<LoanApplicationEntity>();
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);

		try {
			Mockito.when(loanRepo.showAllRejectedLoans()).thenReturn(Arrays.asList(loan));
			loans1 = loanService.getAllRejectedLoans();
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotEquals(loans1.size(), 2);

	}

}