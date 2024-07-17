package com.usecase.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.usecase.entity.LoanApplicationEntity;

@Repository
public interface LoanApplicationRepo extends JpaRepository<LoanApplicationEntity, String> {

	@Query("Select l FROM LoanApplicationEntity l where l.user.userId=(select u.userdetails.userId from UserRegistrationEntity u where u.email=:mail)")
	public List<LoanApplicationEntity> showAllLoanApplicationByEmail(@Param("mail") String email);

	@Query("Select l FROM LoanApplicationEntity l where l.status='Rejected' and l.user.userId=(select u.userdetails.userId from UserRegistrationEntity u where u.email =:em)")
	public List<LoanApplicationEntity> showAllRejectedLoansByEmail(@Param("em") String email);

	
	@Query("Select l FROM LoanApplicationEntity l where l.status='Approved' and l.user.userId=(select u.userdetails.userId from UserRegistrationEntity u where u.email =:em)")
	public List<LoanApplicationEntity> showAllApprovedLoansByEmail(@Param("em") String email);
	
	@Query("Select l FROM LoanApplicationEntity l where l.status='Pending' and l.user.userId=(select u.userdetails.userId from UserRegistrationEntity u where u.email =:em)")
	public List<LoanApplicationEntity> showAllPendingLoansByEmail(@Param("em") String email);
	
	
	@Query("Select loans FROM LoanApplicationEntity loans where loans.status='Pending'")
	public List<LoanApplicationEntity> showAllPendingLoans();

	@Query("Select loans FROM LoanApplicationEntity loans where loans.status='Rejected'")
	public List<LoanApplicationEntity> showAllRejectedLoans();

	@Query("Select loans FROM LoanApplicationEntity loans where loans.status='Approved'")
	public List<LoanApplicationEntity> showAllAcceptedLoans();

}
