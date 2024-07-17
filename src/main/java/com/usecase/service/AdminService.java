package com.usecase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usecase.entity.AdminEntity;
import com.usecase.exception.RecordNotFoundException;
@Service
public interface AdminService {
	
    public AdminEntity adminRegister(AdminEntity admin) throws RecordNotFoundException;            
    
    public AdminEntity showAdminDetailsByEmail(String email) throws RecordNotFoundException;        
    
    public List<AdminEntity> updateAdmin(AdminEntity admin) throws RecordNotFoundException;    
     
    public List<AdminEntity> getAllAdmins() throws RecordNotFoundException;

	AdminEntity logout(AdminEntity admin) throws RecordNotFoundException;  
}
