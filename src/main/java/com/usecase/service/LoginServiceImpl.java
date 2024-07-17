package com.usecase.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.usecase.entity.AdminEntity;
import com.usecase.entity.UserRegistrationEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.repo.AdminRepo;
import com.usecase.repo.LoanApplicationRepo;
import com.usecase.repo.UserRegistrationRepo;

@Service
public class LoginServiceImpl implements LoginService {

	public static Logger log = Logger.getLogger(LoginServiceImpl.class.getName());

	@Autowired
	UserRegistrationRepo userRepo;
	@Autowired
	AdminRepo adminRepo;
	@Autowired
	LoanApplicationRepo loanRepo;

	@Override
	public UserRegistrationEntity authenticateUser(String userEmail, String password) throws RecordNotFoundException {

		log.info("Service Layer - Entry - getAllAdminDetails");

		if (userEmail.equals("") || password == null) {
			throw new RecordNotFoundException("Invalid Details! please enter correct details");
		} else {
			Optional<UserRegistrationEntity> user = userRepo.findById(userEmail);
			// condition if record not exists in database
			if (!user.isPresent())
				throw new RecordNotFoundException("No record exists for given user");
			// condition for if record present and password does not matches
			if (user.isPresent() && !(user.get().getPassword().equals(password)))
				throw new RecordNotFoundException("password does not matches");
			log.info("Service Layer - Exit - getAllAdminDetails");
			return user.get();
		}
	}

	@Override
	public List<UserRegistrationEntity> getAllUsersDetails() {
		log.info("Service Layer - Entry - getAllAdminDetails");
		try {
			return userRepo.findAll();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
		}

	}

	@Override
	public AdminEntity authenticateAdmin(String adminEmail, String password) throws RecordNotFoundException {
		// condition for improper details
		log.info("Service Layer - Entry - authenticateAdmin");
		if (adminEmail.equals("") || password == null)
			throw new RecordNotFoundException("Invalid Details! please enter correct details");
		else {
			Optional<AdminEntity> admin = adminRepo.findById(adminEmail);
			// condition if record not exists in database
			if (!admin.isPresent())
				throw new RecordNotFoundException("No Record Exists for given Admin");
			log.info("Service Layer - Exit - authenticateAdmin");
			// condition for if record present and password does not matches
			if (admin.isPresent() && !(admin.get().getPassword().equals(password)))
				throw new RecordNotFoundException("Password does not match");
			log.info("Service Layer - Exit - authenticateAdmin");
			return admin.get();
		}

	}

	@Override
	public List<AdminEntity> getAllAdminDetails() {
		log.info("Service Layer - Entry - getAllAdminDetails");
		log.info("Service Layer - Exit - getAllAdminDetails");
		return adminRepo.findAll();
	}

}