package com.usecase.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
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
import com.usecase.exception.RecordNotFoundException;
import com.usecase.repo.ApprovedLoanRepo;
import com.usecase.service.ApprovedLoanServiceImpl;

@SpringBootTest
public class ShowApprovedByLoanIdTest {

	@BeforeEach
	public void setup() {
	}

	@MockBean
	ApprovedLoanRepo approvedRepo;

	@Autowired
	ApprovedLoanServiceImpl approvedService;

	@Test
	@DisplayName("Test - showApprovedByLoanId - successful")
	public void correctEnteryPassed() throws RecordNotFoundException {

		int loanId = 1234;
		Optional<ApprovedLoansEntity> returned = null;

		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		AccountEntity account = new AccountEntity(100, user);

		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);

		ApprovedLoansEntity app = new ApprovedLoansEntity(1234, 20.0, LocalDate.now(), account, loan);

		Mockito.when(approvedRepo.saveAndFlush(app)).thenReturn(app);
		Mockito.when(approvedRepo.findById(loanId)).thenReturn(Optional.of(app));

		returned = Optional.of(approvedService.showApprovedByLoanId(loanId));
		assertEquals(returned.get(), app);
	}
	
	@Test
	@DisplayName("Test - showApprovedByLoanId - successful")
	public void correctEnteryPassed2() throws RecordNotFoundException {

		int loanId = 1234;
		Optional<ApprovedLoansEntity> returned = null;

		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		AccountEntity account = new AccountEntity(100, user);

		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);

		ApprovedLoansEntity app = new ApprovedLoansEntity(1234, 20.0, LocalDate.now(), account, loan);

		Mockito.when(approvedRepo.saveAndFlush(app)).thenReturn(app);
		Mockito.when(approvedRepo.findById(loanId)).thenReturn(Optional.of(app));

		returned = Optional.of(approvedService.showApprovedByLoanId(loanId));
		assertEquals(returned.get().getAccount(), app.getAccount());
	}

	@Test
	@DisplayName("Test - showApprovedByLoanId - no loanId Entered")
	public void noLoanIdEntered() {
		int loanId = 0;

		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");

		AccountEntity account = new AccountEntity(100, user);
		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);
		Optional<ApprovedLoansEntity> app = Optional
				.of(new ApprovedLoansEntity(123, 20.0, LocalDate.now(), account, loan));

		ApprovedLoansEntity returned = null;
		// Optional<ApprovedLoansEntity> app2 = null;

		Mockito.when(approvedRepo.findById(loanId)).thenReturn(app);
		try {
			returned = approvedService.showApprovedByLoanId(loanId);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotEquals(returned, app);

	}

	@Test
	@DisplayName("Test - showApprovedByLoanId - wrong loanId Entered")
	public void wrongLoanIdEntered() {
		int loanId = 6789;

		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		AccountEntity account = new AccountEntity(100, user);
		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);
		Optional<ApprovedLoansEntity> app = Optional
				.of(new ApprovedLoansEntity(123, 20.0, LocalDate.now(), account, loan));

		ApprovedLoansEntity returned = null;
		Mockito.when(approvedRepo.findById(loanId)).thenReturn(app);
		try {
			returned = approvedService.showApprovedByLoanId(loanId);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotEquals(returned, app);

	}
	
	@Test
	@DisplayName("Test - showApprovedByLoanId - wrong loanId Entered")
	public void wrongLoanIdEntered1() {
		int loanId = 6789;

		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		AccountEntity account = new AccountEntity(100, user);
		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);
		Optional<ApprovedLoansEntity> app = Optional
				.of(new ApprovedLoansEntity(123, 20.0, LocalDate.now(), account, loan));

		ApprovedLoansEntity returned = null;
		Mockito.when(approvedRepo.findById(loanId)).thenReturn(app);
		try {
			returned = approvedService.showApprovedByLoanId(loanId);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotEquals(user.getAadhar(), app);

	}

}
