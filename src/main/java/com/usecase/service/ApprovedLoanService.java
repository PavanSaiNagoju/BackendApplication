package com.usecase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usecase.entity.ApprovedLoansEntity;
import com.usecase.exception.RecordNotFoundException;

@Service
public interface ApprovedLoanService 
{
 
    //GET APPROVED BY EMAIL
    public List<ApprovedLoansEntity> showAllApprovedByEmail(String email) throws RecordNotFoundException;
    
    //GET APPROVED BY LOANID
    public ApprovedLoansEntity showApprovedByLoanId(int loanId) throws RecordNotFoundException;
    
    
    public List<ApprovedLoansEntity> addApprovedLoan(ApprovedLoansEntity approved) throws RecordNotFoundException;

	public List<ApprovedLoansEntity> showall();
 
     
}