package com.usecase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.entity.ApprovedLoansEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.service.ApprovedLoanServiceImpl;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/homeloan")
public class ApprovedLoanController {

	@Autowired
	private ApprovedLoanServiceImpl approvedLoanService;

	// GET APPROVED DETAILS BY EMAIL
	@GetMapping("/approvedloans/{email}")
	public ResponseEntity<List<ApprovedLoansEntity>> showAllApprovedByEmail(@PathVariable("email") String email)
			throws RecordNotFoundException {

		List<ApprovedLoansEntity> approvedLoans = approvedLoanService.showAllApprovedByEmail(email);
		return new ResponseEntity<List<ApprovedLoansEntity>>(approvedLoans, HttpStatus.OK);

	}

	// SHOW APPROVED DETAILS BY LOANID
	@GetMapping("/approvedloan/{loanId}")
	public ResponseEntity<ApprovedLoansEntity> showApprovedByLoanId(@PathVariable("loanId") int loanId)
			throws RecordNotFoundException {

		ApprovedLoansEntity approvedLoans = approvedLoanService.showApprovedByLoanId(loanId);
		return new ResponseEntity<ApprovedLoansEntity>(approvedLoans, HttpStatus.OK);

	}

	
	@PostMapping("/approvedloans")
	public ResponseEntity<List<ApprovedLoansEntity>> addApprovedLoan(@RequestBody ApprovedLoansEntity approved)
			throws RecordNotFoundException {

		List<ApprovedLoansEntity> approvedLoans = approvedLoanService.addApprovedLoan(approved);
		return new ResponseEntity<List<ApprovedLoansEntity>>(approvedLoans, HttpStatus.OK);
	}

	@GetMapping("/loans")
	public ResponseEntity<List<ApprovedLoansEntity>> getAllProducts() {
		List<ApprovedLoansEntity> approvedLoans = approvedLoanService.showall();
		return new ResponseEntity<List<ApprovedLoansEntity>>(approvedLoans, HttpStatus.OK);
	}

}
