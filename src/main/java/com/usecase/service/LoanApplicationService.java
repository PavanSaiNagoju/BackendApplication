package com.usecase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.usecase.entity.LoanApplicationEntity;
import com.usecase.exception.RecordNotFoundException;

@Service
public interface LoanApplicationService {

	public List<LoanApplicationEntity> showAllLoanApplicationByEmail(String email) throws RecordNotFoundException;

	public List<LoanApplicationEntity> showRejectedLoansByEmail(String email) throws RecordNotFoundException;

	public Optional<List<LoanApplicationEntity>> applyLoan(LoanApplicationEntity loanapp, int userId)
			throws RecordNotFoundException;

	public List<LoanApplicationEntity> showAllLoanApplications() throws RecordNotFoundException;

	public Optional<LoanApplicationEntity> showLoanApplicationByDoorNo(String doorNo) throws RecordNotFoundException;

	public List<LoanApplicationEntity> modifyLoanApplicationStatus(LoanApplicationEntity loanApp)
			throws RecordNotFoundException;
	
	public List<LoanApplicationEntity> getAllPendingLoans() throws RecordNotFoundException;

	public List<LoanApplicationEntity> getAllRejectedLoans() throws RecordNotFoundException;

	public List<LoanApplicationEntity> getAllAcceptedLoans() throws RecordNotFoundException;

}
