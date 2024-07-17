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
public class ShowAllPendingLoansTest {
	@BeforeEach
	public void setup() {

	}

	@MockBean
	LoanApplicationRepo loanRepo;

	@Autowired
	LoanApplicationServiceImpl loanService;

	/* Test case for no Pending Loans */

	@Test
	@DisplayName("Show All Pending Loans - No Pending Loans")
	public void showNoPendingLoans() {
		List<LoanApplicationEntity> loans = new ArrayList<LoanApplicationEntity>();
		List<LoanApplicationEntity> loans1 = new ArrayList<LoanApplicationEntity>();
		try {
			Mockito.when(loanRepo.showAllPendingLoans()).thenReturn(loans);
			loans1 = loanService.getAllPendingLoans();
			assertEquals(loans, loans1);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block

			assertEquals(e.getMessage(), "No Pending Loans");
		}

	}
	
	@Test
	@DisplayName("Show All Pending Loans - No Pending Loans")
	public void showNoPendingLoans1() {
		List<LoanApplicationEntity> loans = new ArrayList<LoanApplicationEntity>();
		List<LoanApplicationEntity> loans1 = new ArrayList<LoanApplicationEntity>();
		try {
			Mockito.when(loanRepo.showAllPendingLoans()).thenReturn(loans);
			loans1 = loanService.getAllPendingLoans();
			assertEquals(loans, loans1);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block

			assertNotEquals(e.getMessage(), "No Loans");
		}

	}

	/* Test case for one Pending Loans */

	@Test
	@DisplayName("Show All Pending Loans - Pending Loans exists")
	public void pendingLoansExists() {
		List<LoanApplicationEntity> loans1 = new ArrayList<LoanApplicationEntity>();
		List<LoanApplicationEntity> loans2 = new ArrayList<LoanApplicationEntity>();
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);

		try {
			Mockito.when(loanRepo.showAllPendingLoans()).thenReturn(Arrays.asList(loan));
			loans2 = loanService.getAllPendingLoans();
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block

			assertEquals(e.getMessage(), "No Pending Loans");
		}
		assertEquals(1, loans2.size());

	}
	
	@Test
	@DisplayName("Show All Pending Loans - Pending Loans exists")
	public void pendingLoansExists2() {
		List<LoanApplicationEntity> loans1 = new ArrayList<LoanApplicationEntity>();
		List<LoanApplicationEntity> loans2 = new ArrayList<LoanApplicationEntity>();
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);

		try {
			Mockito.when(loanRepo.showAllPendingLoans()).thenReturn(Arrays.asList(loan));
			loans2 = loanService.getAllPendingLoans();
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block

			assertNotEquals(e.getMessage(), "No  Loans");
		}
		assertEquals(1, loans2.size());

	}

}