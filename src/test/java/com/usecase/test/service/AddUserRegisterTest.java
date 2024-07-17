package com.usecase.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.usecase.entity.UserRegistrationEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.repo.UserRegistrationRepo;
import com.usecase.service.UserRegisterServiceImpl;

@SpringBootTest
public class AddUserRegisterTest {

	@Autowired
	private UserRegisterServiceImpl userRegisterService;

	@MockBean
	UserRegistrationRepo userRegisterRepo;

	// NO EMAIL ENTERED
	@Test
	@DisplayName("userRegister - no email")
	public void emailNotEntered() throws RecordNotFoundException {
		String email = null;
		UserRegistrationEntity userRegisterEntity = new UserRegistrationEntity("", 41, "female", "9988776611",
				"wonderlands", "SaiRam", null);
		Mockito.when(userRegisterRepo.saveAndFlush(userRegisterEntity)).thenReturn(userRegisterEntity);
		UserRegistrationEntity updatelist = null;
		try {
			updatelist = userRegisterService.userRegister(userRegisterEntity);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			assertEquals(e.getMessage(), "User details should not be null");
		}

	}

	@Test
	@DisplayName("userRegister - no email")
	public void emailNotEntered2() throws RecordNotFoundException {
		String email = null;
		UserRegistrationEntity userRegisterEntity = new UserRegistrationEntity("", 41, "female", "9988776611",
				"wonderlands", "SaiRam", null);
		Mockito.when(userRegisterRepo.saveAndFlush(userRegisterEntity)).thenReturn(userRegisterEntity);
		UserRegistrationEntity updatelist = null;
		try {
			updatelist = userRegisterService.userRegister(userRegisterEntity);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			assertNotEquals(e.getMessage(), "User details should be null");
		}

	}

}