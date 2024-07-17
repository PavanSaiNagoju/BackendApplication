package com.usecase.test.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
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
public class ApplyLoanTest {

	@MockBean
	LoanApplicationRepo loanRepo;

	@Autowired
	LoanApplicationServiceImpl loanService;

	
	@Test
	@DisplayName("Test apply loan - null value entered")
	public void nullLoanObjectPassed() throws RecordNotFoundException {
		LoanApplicationEntity loan = null;
		List<LoanApplicationEntity> list = null;
		Optional<List<LoanApplicationEntity>> list1 = null;
		Mockito.when(loanRepo.findAll()).thenReturn(list);
		list1 = loanService.applyLoan(loan, 1);
		assertNull(list);

	}

	// Apply loan successful
	@Test
	@DisplayName("Test apply loan successful")
	public void applyLoanSuccessful() throws RecordNotFoundException {
		Optional<List<LoanApplicationEntity>> list = Optional.of(new ArrayList<LoanApplicationEntity>());
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		LoanApplicationEntity loan = new LoanApplicationEntity("30-2-11/8", 200000.0, 10, 5.0, 5000000, "06-06-2024",
				"Pending", user);
		Mockito.when(loanRepo.findAll()).thenReturn(Arrays.asList(loan));
		list = loanService.applyLoan(loan, 1);
		assertEquals(list.get(), Arrays.asList(loan));
	}

}
