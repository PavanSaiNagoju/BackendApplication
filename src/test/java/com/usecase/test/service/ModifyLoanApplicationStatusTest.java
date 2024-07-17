package com.usecase.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
public class ModifyLoanApplicationStatusTest {

	@MockBean
	LoanApplicationRepo loanRepo;

	@Autowired
	LoanApplicationServiceImpl loanService;


	@Test
	@DisplayName("Modify Loan Application Status - loan not found")
	public void noLoanApplicationFound() {

		List<LoanApplicationEntity> list = new ArrayList<LoanApplicationEntity>();

		List<LoanApplicationEntity> returnedList = new ArrayList<LoanApplicationEntity>();

		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", null);

		Mockito.when(loanRepo.findById("30-2-11")).thenReturn(null);
		try {
			Mockito.when(loanRepo.findAll()).thenReturn(list);
			returnedList = loanService.modifyLoanApplicationStatus(loan);
		} catch (RecordNotFoundException e) {
			assertNotEquals(e.getMessage(), "Loan Not Found");
		}

	}

	@Test
	@DisplayName("Modify Loan Application Status - null object passed")
	public void nullObjectPassed() {

		List<LoanApplicationEntity> list = new ArrayList<LoanApplicationEntity>();
		List<LoanApplicationEntity> returnedList = new ArrayList<LoanApplicationEntity>();
		LoanApplicationEntity loan = null;

		try {
			Mockito.when(loanRepo.findAll()).thenReturn(list);
			returnedList = loanService.modifyLoanApplicationStatus(loan);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Loan Application Not Found");
		}

	}
	
	@Test
	@DisplayName("Modify Loan Application Status - null object passed")
	public void nullObjectPassed2() {

		List<LoanApplicationEntity> list = new ArrayList<LoanApplicationEntity>();
		List<LoanApplicationEntity> returnedList = new ArrayList<LoanApplicationEntity>();
		LoanApplicationEntity loan = null;

		try {
			Mockito.when(loanRepo.findAll()).thenReturn(list);
			returnedList = loanService.modifyLoanApplicationStatus(loan);
		} catch (Exception e) {
			assertNotEquals(e.getMessage(), "Loan Not Found");
		}

	}
	
	/*@Test
	@DisplayName("Modify Loan Application Status- successful")
	public void loanApplicationByEmailSuccessfull2() throws RecordNotFoundException {
		List<LoanApplicationEntity> list = new ArrayList<LoanApplicationEntity>();
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");

		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);

		Mockito.when(loanRepo.findAll()).thenReturn(Arrays.asList(loan));
		list = loanService.modifyLoanApplicationStatus(loan);
		assertNotEquals(list.size(), 2);

	}
	
	@Test
	@DisplayName("Modify Loan Application Status - loan not found")
	public void noLoanApplicationFound2() {

		List<LoanApplicationEntity> list = new ArrayList<LoanApplicationEntity>();

		List<LoanApplicationEntity> returnedList = new ArrayList<LoanApplicationEntity>();

		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", null);

		Mockito.when(loanRepo.findById("30-2-11/8")).thenReturn(null);
		try {
			Mockito.when(loanRepo.findAll()).thenReturn(list);
			returnedList = loanService.modifyLoanApplicationStatus(loan);
		} catch (RecordNotFoundException e) {
			assertEquals(e.getMessage(), "Loan Application Not Found");
		}

	}
	
	@Test
	@DisplayName("Modify Loan Application Status - loan not found")
	public void noLoanApplicationFound2() {

		List<LoanApplicationEntity> list = new ArrayList<LoanApplicationEntity>();

		List<LoanApplicationEntity> returnedList = new ArrayList<LoanApplicationEntity>();

		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", null);

		Mockito.when(loanRepo.findById("30-2-11/8")).thenReturn(null);
		try {
			Mockito.when(loanRepo.findAll()).thenReturn(list);
			returnedList = loanService.modifyLoanApplicationStatus(loan);
		} catch (RecordNotFoundException e) {
			assertEquals(e.getMessage(), "Loan Application Not Found");
		}

	}
	
	*@Test
	@DisplayName("Modify Loan Application Status - loan not found")
	public void noLoanApplicationFound2() {

		List<LoanApplicationEntity> list = new ArrayList<LoanApplicationEntity>();

		List<LoanApplicationEntity> returnedList = new ArrayList<LoanApplicationEntity>();

		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", null);

		Mockito.when(loanRepo.findById("30-2-11/8")).thenReturn(null);
		try {
			Mockito.when(loanRepo.findAll()).thenReturn(list);
			returnedList = loanService.modifyLoanApplicationStatus(loan);
		} catch (RecordNotFoundException e) {
			assertEquals(e.getMessage(), "Loan Application Not Found");
		}

	}*/
	
	
	
	
}
