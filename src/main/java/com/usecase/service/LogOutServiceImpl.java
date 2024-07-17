package com.usecase.service;

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
public class LogOutServiceImpl implements LogOutService {

	public static Logger log = Logger.getLogger(LogOutServiceImpl.class.getName());
	@Autowired
	private UserRegistrationRepo userRegisterRepo;

	// USED TO LOGOUT
	@Override
	public UserRegistrationEntity logout(UserRegistrationEntity userbasic) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		log.info("Service Layer - Entry - logout");
		Optional<UserRegistrationEntity> userbasics = userRegisterRepo.findById(userbasic.getEmail());
		try {
			if (!userbasics.isPresent()) {
				log.info("UserBasics not present");
				return null;
			} else
				log.info("Service Layer - Exit - logout");
				return userbasics.get();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
		}
	}
}