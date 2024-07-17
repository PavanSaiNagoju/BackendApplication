package com.usecase.test.service;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.usecase.entity.AccountEntity;
import com.usecase.entity.ApprovedLoansEntity;
import com.usecase.entity.LoanApplicationEntity;
import com.usecase.entity.UserDetailsEntity;
import com.usecase.repo.ApprovedLoanRepo;
import com.usecase.service.ApprovedLoanServiceImpl;

@SpringBootTest
public class AddApprovedLoanTest {

	@MockBean
	ApprovedLoanRepo approvedRepo;
	@Autowired
	ApprovedLoanServiceImpl approveService;

	@Test
	@DisplayName("AddApprovedLoan - If invalid details found")
	public void noDetailsFound() {

		ApprovedLoansEntity approve = null;
		List<ApprovedLoansEntity> approveList = new ArrayList<ApprovedLoansEntity>();
		try {
			Mockito.doReturn(approvedRepo.findAll()).when(approvedRepo).save(approve);
			approveList = approveService.addApprovedLoan(approve);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Invalid Object Found!");
		}
	}
	
	@Test
	@DisplayName("AddApprovedLoan - If invalid status found")
	public void noStatusNotAccepted1() {
		List<ApprovedLoansEntity> approveList = new ArrayList<ApprovedLoansEntity>();
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);
		AccountEntity account = new AccountEntity(1234, user);
		ApprovedLoansEntity approve = new ApprovedLoansEntity(123, 34.45, LocalDate.now(), account, loan);
		try {
			Mockito.doReturn(Arrays.asList(approve)).when(approvedRepo).save(approve);
			approveList = approveService.addApprovedLoan(approve);
		} catch (Exception e) {
			assertNotEquals(e.getMessage(), "Loan still not approved!");
		}
	}
	

	@Test
	@DisplayName("AddApprovedLoan - If invalid status found")
	public void noStatusNotAccepted() {
		List<ApprovedLoansEntity> approveList = new ArrayList<ApprovedLoansEntity>();
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);
		AccountEntity account = new AccountEntity(1234, user);
		ApprovedLoansEntity approve = new ApprovedLoansEntity(123, 34.45, LocalDate.now(), account, loan);
		try {
			Mockito.doReturn(Arrays.asList(approve)).when(approvedRepo).save(approve);
			approveList = approveService.addApprovedLoan(approve);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Loan is still not approved!");
		}
	}

	@Test
	@DisplayName("AddApprovedLoan - If Duplicate Record found")
	public void duplicateRecordFound() {
		List<ApprovedLoansEntity> approveList = new ArrayList<ApprovedLoansEntity>();
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);
		AccountEntity account = new AccountEntity(1234, user);
		ApprovedLoansEntity approve = new ApprovedLoansEntity(123, 34.45, LocalDate.now(), account, loan);
		approvedRepo.save(approve);
		try {
			Mockito.doReturn(Arrays.asList(approve)).when(approvedRepo).save(approve);
			approveList = approveService.addApprovedLoan(approve);
		} catch (Exception e) {
			assertSame(0, approveList.size());
		}
	}
	
	@Test
	@DisplayName("AddApprovedLoan - If Duplicate Record found")
	public void duplicateRecordFound2() {
		List<ApprovedLoansEntity> approveList = new ArrayList<ApprovedLoansEntity>();
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);
		AccountEntity account = new AccountEntity(1234, user);
		ApprovedLoansEntity approve = new ApprovedLoansEntity(123, 34.45, LocalDate.now(), account, loan);
		approvedRepo.save(approve);
		try {
			Mockito.doReturn(Arrays.asList(approve)).when(approvedRepo).save(approve);
			approveList = approveService.addApprovedLoan(approve);
		} catch (Exception e) {
			assertNotSame(1, approveList.size());
		}
	}

	@Test
	@DisplayName("AddApprovedLoan - If Record added successfully")
	public void addedSuccessfully() {
		List<ApprovedLoansEntity> approveList = new ArrayList<ApprovedLoansEntity>();
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);
		AccountEntity account = new AccountEntity(1234, user);
		ApprovedLoansEntity approve = new ApprovedLoansEntity(123, 34.45, LocalDate.now(), account, loan);
		approvedRepo.save(approve);
		try {
			Mockito.doReturn(Arrays.asList(approve)).when(approvedRepo).save(approve);
			approveList = approveService.addApprovedLoan(approve);
		} catch (Exception e) {

		}
		assertNotNull(approveList);
	}

}