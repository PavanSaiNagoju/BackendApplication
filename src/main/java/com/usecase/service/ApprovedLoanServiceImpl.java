package com.usecase.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.usecase.entity.ApprovedLoansEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.repo.ApprovedLoanRepo;

@Service
public class ApprovedLoanServiceImpl implements ApprovedLoanService {

	EmiServiceImpl emiService;

	static Logger log = Logger.getLogger(ApprovedLoanServiceImpl.class.getClass());

	@Autowired
	private ApprovedLoanRepo approvedRepo;

	// GET APPROVED BY LOANID
	@Override
	public ApprovedLoansEntity showApprovedByLoanId(int loanId) throws RecordNotFoundException {
		log.info("Service Layer - Entry - showAllApprovedByEmail");
		Optional<ApprovedLoansEntity> approved = approvedRepo.findById(loanId);
		try {
			if (!approved.isPresent()) {
				log.warn("WARN:  LoanId should not be match");
				throw new RecordNotFoundException("LoanId should not be match");
			}
			log.info("Service Layer - Exit - showApprovedByLoanId");
			return approved.get();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
		}
	}

	// GET APPROVED BY EMAIL
	@Override
	public List<ApprovedLoansEntity> showAllApprovedByEmail(String email) throws RecordNotFoundException {
		log.info("Service Layer - Entry - showAllApprovedByEmail");
		try {
			if (email == null) {
				log.warn("WARN:  Email should not match");
				throw new RecordNotFoundException("Email should not match");
			}
			return approvedRepo.findAll();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
		}

	}

	@Override
	public List<ApprovedLoansEntity> showall() {
		// TODO Auto-generated method stub
		try {
			return approvedRepo.findAll();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
		}
	}

	@Override
	public List<ApprovedLoansEntity> addApprovedLoan(ApprovedLoansEntity approved) throws RecordNotFoundException {
		log.info("Service Layer - Entry - addApprovedLoan");
		if (approved == null)
			throw new RecordNotFoundException("Invalid Object Found!");
		if (!(approved.getLoanapp().getStatus().equalsIgnoreCase("Accepted")))
			throw new RecordNotFoundException("Loan is still not approved!");
		double loanAmount = approved.getLoanapp().getAmount();
		int tenure = approved.getLoanapp().getTenure();
		double interestRate = approved.getLoanapp().getInterest();
		double emi = emiService.EMICalculate(loanAmount, 12, interestRate);
		approved.setEmi(emi);

		Optional<ApprovedLoansEntity> retApproved = approvedRepo.findById(approved.getLoanId());
		if (retApproved.isPresent())
			throw new RecordNotFoundException("The Loan is already added");
		approvedRepo.saveAndFlush(approved);
		log.info("Service Layer - Exit - addApprovedLoan");
		return approvedRepo.findAll();

	}

}
