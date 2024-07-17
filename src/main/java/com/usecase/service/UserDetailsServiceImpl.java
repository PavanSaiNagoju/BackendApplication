package com.usecase.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.usecase.entity.UserDetailsEntity;
import com.usecase.entity.UserRegistrationEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.repo.UserDetailsRepo;
import com.usecase.repo.UserRegistrationRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	public static Logger log = Logger.getLogger(UserDetailsServiceImpl.class.getName());

	@Autowired
	private UserDetailsRepo userDetailsRepo;

	@Autowired
	private UserRegistrationRepo userRegisterRepo;

	@Override
	public List<UserDetailsEntity> addUserDetails(UserDetailsEntity userDetails, String email)
			throws RecordNotFoundException {
		log.info("Service Layer - Entry - addUserDetails");
		UserDetailsEntity user = new UserDetailsEntity();
		try {
			if (userDetails.getAadhar().isEmpty() || userDetails.getAddress().isEmpty()
					|| userDetails.getCity().isEmpty()) {
				throw new RecordNotFoundException("User details should not be null");
			} else if (userRegisterRepo.findById(email) == null) {
				throw new RecordNotFoundException("User not registered");
			}

			Optional<UserRegistrationEntity> userRegister = userRegisterRepo.findById(email);
			UserRegistrationEntity userReg = userRegister.get();

			if (userReg != null && userReg.getUserdetails() == null) {
				user = userDetailsRepo.saveAndFlush(userDetails);
				userReg.setUserdetails(userDetails);
				userRegisterRepo.saveAndFlush(userReg);
			}
			List<UserDetailsEntity> list = userDetailsRepo.findAll();
			log.info("Service Layer - Exit - addUserDetails");
			return list;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
		}
	}

	@Override
	public List<UserDetailsEntity> editUserDetails(UserDetailsEntity user) throws RecordNotFoundException {
		log.info("Service Layer - Entry - editUserDetails");
		try {
			if (user.getUserId() == 0) {

				throw new RecordNotFoundException("User Not Found...");
			}
			userDetailsRepo.save(user);
			log.info("Service Layer - Entry - editUserDetails");
			return userDetailsRepo.findAll();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
		}
	}

	@Override
	public UserDetailsEntity showUserDetailsInformationByUserId(int userId) throws RecordNotFoundException {
		log.info("Service Layer - Entry - showUserDetailsInformationByUserId");
		Optional<UserDetailsEntity> user = userDetailsRepo.findById(userId);

		if (user == null) {

			throw new RecordNotFoundException("No Records Found");
		}
		log.info("Service Layer - Exit - showUserDetailsInformationByUserId");
		return user.get();

	}

	@Override
	public List<UserDetailsEntity> showAllUserDetails() throws RecordNotFoundException {

		log.info("Service Layer - Entry - showAllUserDetails");
		log.info("Service Layer - Exit - showAllUserDetails");
		return userDetailsRepo.findAll();

	}
}
