package com.usecase.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.usecase.entity.LoanApplicationEntity;
import com.usecase.entity.UserDetailsEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.repo.LoanApplicationRepo;
import com.usecase.repo.UserDetailsRepo;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {

	static Logger log = Logger.getLogger(ApprovedLoanServiceImpl.class.getClass());

	@Autowired
	private LoanApplicationRepo loansRepo;

	@Autowired
	private UserDetailsRepo userDetailsRepo;

	@Override
	public Optional<List<LoanApplicationEntity>> applyLoan(LoanApplicationEntity loanApp, int userId)
			throws RecordNotFoundException {
		log.info("Service Layer - Entry - applyLoan");
		try {
			if (loanApp == null) {
				log.warn("WARN:  LoanApp should not be empty");
				return null;
			} else {
				Optional<UserDetailsEntity> user = userDetailsRepo.findById(userId);
				loanApp.setUser(user.get());
				if (loanApp.getStatus().equalsIgnoreCase("pending"))
					loansRepo.save(loanApp);
				return Optional.of(loansRepo.findAll());
			}
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
		}
	}

	@Override
	public Optional<LoanApplicationEntity> showLoanApplicationByDoorNo(String doorNo) throws RecordNotFoundException {
		log.info("Service Layer - Entry - showLoanApplicationByDoorNo");
		try {
			if (doorNo == null) {
				log.warn("WARN:  DoorNo should not be empty");
				throw new RecordNotFoundException("Null Door number Entered");
			}
			Optional<LoanApplicationEntity> loanApp = loansRepo.findById(doorNo);
			if (loanApp == null)
				throw new RecordNotFoundException("Loan Application Not Found");
			log.info("Service Layer - Entry - showLoanApplicationByDoorNo");
			return loanApp;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
		}
	}

	@Override
	public List<LoanApplicationEntity> showAllLoanApplicationByEmail(String email) throws RecordNotFoundException {
		log.info("Service Layer - Entry - showAllApprovedByEmail");
		if (email == null) {
			throw new RecordNotFoundException("Null Email Entered");
		}
		List<LoanApplicationEntity> loansApp = loansRepo.showAllLoanApplicationByEmail(email);

		if (loansApp.isEmpty())
			throw new RecordNotFoundException("No loans applied");
		log.info("Service Layer - Exit - showAllApprovedByEmail");
		return loansApp;

	}

	@Override
	public List<LoanApplicationEntity> showRejectedLoansByEmail(String email) throws RecordNotFoundException {
		log.info("Service Layer - Entry - showRejectedLoansByEmail");
		if (email == null) {

			throw new RecordNotFoundException("Null Email Entered");
		}
		List<LoanApplicationEntity> loansApp = loansRepo.showAllRejectedLoansByEmail(email);
		if (loansApp.isEmpty())
			throw new RecordNotFoundException("No Rejected loans found");
		log.info("Service Layer - Exit - showRejectedLoansByEmail");
		return loansApp;

	}

	@Override
	public List<LoanApplicationEntity> modifyLoanApplicationStatus(LoanApplicationEntity loanApp)
			throws RecordNotFoundException {
		log.info("Service Layer - Entry - modifyLoanApplicationStatus");

	    if (loanApp == null) {
	        throw new RecordNotFoundException("Loan Application Not Found");
	    }

	    // Assume loansRepo.findById() returns an Optional<LoanApplicationEntity>
	    Optional<LoanApplicationEntity> existingLoan = loansRepo.findById(loanApp.getDoorNo());

	    if (!existingLoan.isPresent()) {
	        throw new RecordNotFoundException("Loan Application Not Found");
	    }

	    LoanApplicationEntity existingLoanApp = existingLoan.get();
	    double userSalary = existingLoanApp.getUser().getSalary();
	    double loanAmount = existingLoanApp.getAmount();
	    double existingEMI = existingLoanApp.getExistingEMI();
	    int tenureInMonths = existingLoanApp.getTenure() * 12;
	    
	    if (loanAmount <= userSalary * 2 && existingEMI <= loanAmount / tenureInMonths) {
	        existingLoanApp.setStatus("Approved");
	    } else {
	        existingLoanApp.setStatus("Rejected");
	    }

	    // Save the modified loan application status
	    loansRepo.save(existingLoanApp);

	    log.info("Service Layer - Exit - modifyLoanApplicationStatus");

	    // Return all loan applications after modification
	    return loansRepo.findAll();
	}

	@Override
	public List<LoanApplicationEntity> showAllLoanApplications() throws RecordNotFoundException {
		log.info("Service Layer - Entry - showAllLoanApplications");
		if (loansRepo.findAll().isEmpty())
			throw new RecordNotFoundException("No Loan Applications available");

		log.info("Service Layer - Exit - showAllLoanApplications");
		return loansRepo.findAll();

	}

	@Override
	public List<LoanApplicationEntity> getAllPendingLoans() throws RecordNotFoundException {
		log.info("Service Layer - Entry - getAllPendingLoans");
		List<LoanApplicationEntity> pendingLoans = loansRepo.showAllPendingLoans();
		if (pendingLoans.isEmpty())
			throw new RecordNotFoundException("No Pending Loans");
		else
			log.info("Service Layer - Exit - getAllPendingLoans");
		return pendingLoans;

	}

	@Override
	public List<LoanApplicationEntity> getAllRejectedLoans() throws RecordNotFoundException {
		log.info("Service Layer - Entry - getAllRejectedLoans");
		List<LoanApplicationEntity> rejectedLoans = loansRepo.showAllRejectedLoans();
		if (rejectedLoans.isEmpty())
			throw new RecordNotFoundException("No Rejected Loans");
		else
			log.info("Service Layer - Exit - getAllRejectedLoans");
		return rejectedLoans;

	}

	@Override
	public List<LoanApplicationEntity> getAllAcceptedLoans() throws RecordNotFoundException {
		log.info("Service Layer - Entry - getAllAcceptedLoans");
		List<LoanApplicationEntity> approveLoans = loansRepo.showAllAcceptedLoans();
		if (approveLoans.isEmpty())
			throw new RecordNotFoundException("No Approved Loans");
		else
			log.info("Service Layer - Exit - getAllAcceptedLoans");
		return approveLoans;

	}

	public List<LoanApplicationEntity> showAllPendingLoansByEmail(String email) throws RecordNotFoundException {
		log.info("Service Layer - Entry - showPendingLoansByEmail");
		if (email == null) {

			throw new RecordNotFoundException("Null Email Entered");
		}
		List<LoanApplicationEntity> loansApp = loansRepo.showAllPendingLoansByEmail(email);
		if (loansApp.isEmpty())
			throw new RecordNotFoundException("No Pending loans found");
		log.info("Service Layer - Exit - showPendingLoansByEmail");
		return loansApp;

	}
	

	public List<LoanApplicationEntity> showAllApprovedLoansByEmail(String email)  throws RecordNotFoundException {
		log.info("Service Layer - Entry - showApprovedLoansByEmail");
		if (email == null) {

			throw new RecordNotFoundException("Null Email Entered");
		}
		List<LoanApplicationEntity> loansApp = loansRepo.showAllApprovedLoansByEmail(email);
		if (loansApp.isEmpty())
			throw new RecordNotFoundException("No Rejected loans found");
		log.info("Service Layer - Exit - showApprovedLoansByEmail");
		return loansApp;

	}

}
