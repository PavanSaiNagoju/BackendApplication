package com.usecase.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.entity.LoanApplicationEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.service.LoanApplicationServiceImpl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/homeloan")
@Validated
public class LoanApplicationController {

	@Autowired
	private LoanApplicationServiceImpl loansAppService;

	// Working
	@PostMapping("/loanapplications/{userId}")
	public ResponseEntity<Optional<List<LoanApplicationEntity>>> applyLoan(
			@Valid @RequestBody LoanApplicationEntity loans, @PathVariable("userId") int id) throws RecordNotFoundException {

		Optional<List<LoanApplicationEntity>> loansApplied = null;
		if ((loansAppService.showLoanApplicationByDoorNo(loans.getDoorNo())).isEmpty())
			loansApplied = loansAppService.applyLoan(loans, id);
		else
			throw new RecordNotFoundException("Record already exists");
		return new ResponseEntity<Optional<List<LoanApplicationEntity>>>(loansApplied, HttpStatus.OK);
	}

	// Working
	@GetMapping("/loanapplications/bymail/{email}")
	public ResponseEntity<List<LoanApplicationEntity>> showLoanApplicationByEmail(
			@PathVariable("email") @Email(message = "email not valid") @NotNull(message = "email null") String email)
			throws RecordNotFoundException {
		List<LoanApplicationEntity> loansApplied = loansAppService.showAllLoanApplicationByEmail(email);

		if (loansApplied.isEmpty()) {
			throw new RecordNotFoundException("No Loans found");

		}

		return new ResponseEntity<List<LoanApplicationEntity>>(loansApplied, HttpStatus.OK);

	}

	// Working

	@GetMapping("/loanapplications/rejected/{email}")
	public ResponseEntity<List<LoanApplicationEntity>> RejectedLoansByEmail(
			@PathVariable("email") @Email(message = "email not valid") @NotNull(message = "email null") String email)
			throws RecordNotFoundException {
		List<LoanApplicationEntity> loansApplied = loansAppService.showRejectedLoansByEmail(email);
		if (loansApplied.isEmpty()) {
			throw new RecordNotFoundException("No rejected Loans found");
		}
		return new ResponseEntity<List<LoanApplicationEntity>>(loansApplied, HttpStatus.OK);
	}

//Wroking
//Modify loan application status
	@PutMapping("/loanapplications")
	public ResponseEntity<List<LoanApplicationEntity>> updateLoanApplication(
			@Valid @RequestBody LoanApplicationEntity loanApp) throws RecordNotFoundException {

		List<LoanApplicationEntity> loans = loansAppService.modifyLoanApplicationStatus(loanApp);

		if (loans.isEmpty()) {
			throw new RecordNotFoundException("Loan not found");
		}
		return new ResponseEntity<List<LoanApplicationEntity>>(loans, HttpStatus.OK);
	}

//working
	@GetMapping("/loanapplications/pendingloans/{email}")
	public ResponseEntity<List<LoanApplicationEntity>> getAllPendingLoans(@PathVariable("email") String email) throws RecordNotFoundException {
		List<LoanApplicationEntity> loanApplications = loansAppService.showAllPendingLoansByEmail(email);
		return new ResponseEntity<List<LoanApplicationEntity>>(loanApplications, HttpStatus.OK);
	}
	
	
	@GetMapping("/loanapplications/approvedloans/{email}")
	public ResponseEntity<List<LoanApplicationEntity>> getAllApprovedLoans(@PathVariable("email") String email) throws RecordNotFoundException {
		List<LoanApplicationEntity> loanApplications = loansAppService.showAllApprovedLoansByEmail(email);
		return new ResponseEntity<List<LoanApplicationEntity>>(loanApplications, HttpStatus.OK);
	}

	// Working
	@GetMapping("/loanapplications/rejectedloans")
	public ResponseEntity<List<LoanApplicationEntity>> getAllRejectedLoans() throws RecordNotFoundException {
		List<LoanApplicationEntity> loanApplications = loansAppService.getAllRejectedLoans();
		return new ResponseEntity<List<LoanApplicationEntity>>(loanApplications, HttpStatus.OK);
	}
	
	@GetMapping("/loanapplications/pendingloans")
	public ResponseEntity<List<LoanApplicationEntity>> getAllPendingLoans() throws RecordNotFoundException {
		List<LoanApplicationEntity> loanApplications = loansAppService.getAllPendingLoans();
		return new ResponseEntity<List<LoanApplicationEntity>>(loanApplications, HttpStatus.OK);
	}

//Working
	@GetMapping("/loanapplications/approvedloans")
	public ResponseEntity<List<LoanApplicationEntity>> getAllApprovedLoans() throws RecordNotFoundException {

		List<LoanApplicationEntity> loanApplications = loansAppService.getAllAcceptedLoans();

		return new ResponseEntity<List<LoanApplicationEntity>>(loanApplications, HttpStatus.OK);
	}
}
