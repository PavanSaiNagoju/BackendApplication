package com.usecase.test.service;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.usecase.repo.ApprovedLoanRepo;
import com.usecase.service.ApprovedLoanServiceImpl;

public class ShowAllApprovedLoans {
	
	@BeforeEach
	public void setup() {

	}

	@MockBean
	ApprovedLoanRepo approvedRepo;

	@Autowired
	ApprovedLoanServiceImpl approvedLoansService;

}