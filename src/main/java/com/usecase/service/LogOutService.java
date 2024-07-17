package com.usecase.service;

import com.usecase.entity.UserRegistrationEntity;
import com.usecase.exception.RecordNotFoundException;

public interface LogOutService {

	// USED TO LOGOUT FOR USER
	public UserRegistrationEntity logout(UserRegistrationEntity userbasic) throws RecordNotFoundException;

}