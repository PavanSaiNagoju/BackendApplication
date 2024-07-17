package com.usecase.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

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
import com.usecase.repo.UserRegistrationRepo;
import com.usecase.service.LoanApplicationServiceImpl;

@SpringBootTest
public class ShowLoanApplicationByDoorNo {

	@BeforeEach
	public void setup() {

	}

	@MockBean
	UserRegistrationRepo userRepo;

	@MockBean
	LoanApplicationRepo loanRepo;

	@Autowired
	LoanApplicationServiceImpl loanService;

//Loan applications shown successfully
	@Test
	@DisplayName("Show Loan Application By DoorNo- successful")
	public void loanApplicationByDoorNoSuccessfull() throws RecordNotFoundException {
		String doorNo = "30-2-11/8";
		Optional<LoanApplicationEntity> returnedLoan = null;
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);

		Mockito.when(loanRepo.saveAndFlush(loan)).thenReturn(loan);
		Mockito.when(loanRepo.findById(doorNo)).thenReturn(Optional.of(loan));
		returnedLoan = loanService.showLoanApplicationByDoorNo(doorNo);
		assertEquals(returnedLoan.get(), loan);

	}
	
	@Test
	@DisplayName("Show Loan Application By DoorNo- successful")
	public void loanApplicationByDoorNoSuccessfull1() throws RecordNotFoundException {
		String doorNo = "30-2-11/8";
		Optional<LoanApplicationEntity> returnedLoan = null;
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);

		Mockito.when(loanRepo.saveAndFlush(loan)).thenReturn(loan);
		Mockito.when(loanRepo.findById(doorNo)).thenReturn(Optional.of(loan));
		returnedLoan = loanService.showLoanApplicationByDoorNo(doorNo);
		assertEquals(returnedLoan.get().getDoorNo(), loan.getDoorNo());
		assertNotEquals(returnedLoan.get().getDoorNo(), loan.getAppdate());

	}

//No loan applications found for given DoorNo number
	@Test
	@DisplayName("Show Loan Application By DoorNo- no loan applications found")
	public void noLoanApplicationFound() {
		String doorNo = "30-2-11/8";
		Optional<LoanApplicationEntity> ReturnedLoan = null;
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		UserRegistrationEntity userRegister = new UserRegistrationEntity("hello@gmail.com", 21, "M", "9856435672",
				"abc", "hello", user);

		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);

		Mockito.when(userRepo.saveAndFlush(userRegister)).thenReturn(userRegister);
		try {
			Mockito.when(loanRepo.findById(doorNo)).thenReturn(Optional.of(loan));
			ReturnedLoan = loanService.showLoanApplicationByDoorNo(doorNo);
			assertEquals(loan, ReturnedLoan.get());
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			assertEquals(e.getMessage(), "Loan Application Not Found");
		}

	}
	
	@Test
	@DisplayName("Show Loan Application By DoorNo- no loan applications found")
	public void noLoanApplicationFound1() {
		String doorNo = "30-2-11/8";
		Optional<LoanApplicationEntity> ReturnedLoan = null;
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		UserRegistrationEntity userRegister = new UserRegistrationEntity("hello@gmail.com", 21, "M", "9856435672",
				"abc", "hello", user);

		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);

		Mockito.when(userRepo.saveAndFlush(userRegister)).thenReturn(userRegister);
		try {
			Mockito.when(loanRepo.findById(doorNo)).thenReturn(Optional.of(loan));
			ReturnedLoan = loanService.showLoanApplicationByDoorNo(doorNo);
			assertEquals(loan, ReturnedLoan.get());
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			assertNotEquals(e.getMessage(), "Loan Not Found");
		}

	}

//DoorNo Number not entered
	@Test
	@DisplayName("Show Loan Application By Door Number- no door number entered")
	public void nullDoorNumberEntered() {
		String chassisNo = null;
		LoanApplicationEntity loanApp = null;
		Optional<LoanApplicationEntity> returnedLoan = null;
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		UserRegistrationEntity userRegister = new UserRegistrationEntity(null, 21, "M", "9856435672", "abc", "hello",
				user);

		try {
			Mockito.when(loanRepo.findById(chassisNo).get()).thenReturn(loanApp);
			returnedLoan = loanService.showLoanApplicationByDoorNo(chassisNo);
			assertEquals(loanApp, returnedLoan);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertNotNull(e.getMessage());
		}

	}
	
	@Test
	@DisplayName("Show Loan Application By Door Number- no door number entered")
	public void nullDoorNumberEntered2() {
		String chassisNo = null;
		LoanApplicationEntity loanApp = null;
		Optional<LoanApplicationEntity> returnedLoan = null;
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		UserRegistrationEntity userRegister = new UserRegistrationEntity(null, 21, "M", "9856435672", "abc", "hello",
				user);

		try {
			Mockito.when(loanRepo.findById(chassisNo).get()).thenReturn(loanApp);
			returnedLoan = loanService.showLoanApplicationByDoorNo(chassisNo);
			assertEquals(loanApp.getAmount(), returnedLoan.get().getAmount());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertNotNull(e.getMessage());
		}

	}
}