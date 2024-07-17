package com.usecase.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.usecase.entity.UserRegistrationEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.repo.UserRegistrationRepo;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

	public static Logger log = Logger.getLogger(UserRegisterServiceImpl.class.getName());
	
	@Autowired
	private UserRegistrationRepo userRegister;

	@Override
	public List<UserRegistrationEntity> passwordReset(UserRegistrationEntity userbasic) throws RecordNotFoundException {
		log.info("Service Layer - Entry - passwordReset");try {
			if (userbasic.getEmail().isEmpty()) {
				throw new RecordNotFoundException("User Email not found");
			}
			userRegister.save(userbasic);
			log.info("Service Layer - Exit - passwordReset");
			return userRegister.findAll();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
		}
	}
	
	@Override
	public UserRegistrationEntity userRegister(UserRegistrationEntity userbasic) throws RecordNotFoundException {
		log.info("Service Layer - Entry - userRegister");
		UserRegistrationEntity user = new UserRegistrationEntity();
		
			if (userbasic.getEmail().isEmpty()) {
				throw new RecordNotFoundException("User details should not be null");
			}
			user = userRegister.save(userbasic);
			log.info("Service Layer - Exit - userRegister");
			return user;
		
	}

	@Override
	public UserRegistrationEntity showUserRegistrationInformationByEmail(String email) throws RecordNotFoundException {
		log.info("Service Layer - Entry - showUserRegistrationInformationByEmail");
			if (email == null) {
				throw new RecordNotFoundException("Null email entered");
			}
			Optional<UserRegistrationEntity> userbasic = userRegister.findById(email);
			if (userbasic == null) {
				throw new RecordNotFoundException("User details not found");
			}
			log.info("Service Layer - Exit - showUserRegistrationInformationByEmail");
			return userbasic.get();
		
	}

	

	@Override
	public List<UserRegistrationEntity> getAllUsers() throws RecordNotFoundException {
		log.info("Service Layer - Entry - getAllUsers");
		log.info("Service Layer - Exit - getAllUsers");
		return userRegister.findAll();

	}

}
