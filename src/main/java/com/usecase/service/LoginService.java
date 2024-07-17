package com.usecase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usecase.entity.AdminEntity;
import com.usecase.entity.UserRegistrationEntity;
import com.usecase.exception.RecordNotFoundException;

@Service
public interface LoginService {

	public UserRegistrationEntity authenticateUser(String userEmail, String password) throws RecordNotFoundException;

	public List<UserRegistrationEntity> getAllUsersDetails() throws RecordNotFoundException;

	public AdminEntity authenticateAdmin(String adminEmail, String password) throws RecordNotFoundException;

	public List<AdminEntity> getAllAdminDetails() throws RecordNotFoundException;

}