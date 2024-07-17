package com.usecase.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class GetAllUsersTest {
	
	@Autowired
	private UserRegisterServiceImpl userRegisterService;
	
	@MockBean
	UserRegistrationRepo userRegisterRepo;

	@Test
	@DisplayName("Get All Users - successful")
	public void getAllUsersSuccessfull() {

		List<UserRegistrationEntity> list = new ArrayList<UserRegistrationEntity>();

		UserRegistrationEntity userRegisterEntity = new UserRegistrationEntity("wonders@gmail.com", 41, "female",
				"9988776611", "wonderlands", "SaiRam", null);

		UserRegistrationEntity userRegisterEntity2 = new UserRegistrationEntity("wondersland@gmail.com", 50, "female",
				"9989776611", "wonderllands", "SaiiRam", null);

		Mockito.when(userRegisterRepo.findAll()).thenReturn(Arrays.asList(userRegisterEntity, userRegisterEntity2));

		try {
			list = userRegisterService.getAllUsers();
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(list.size(), 2);
	}

	@Test
	@DisplayName("Show All Users - no user found")
	public void noUserFound() {

		List<UserRegistrationEntity> list = new ArrayList<UserRegistrationEntity>();
		List<UserRegistrationEntity> returnedList = new ArrayList<UserRegistrationEntity>();

		Mockito.when(userRegisterRepo.findAll()).thenReturn(list);

		try {
			returnedList = userRegisterService.getAllUsers();
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(list, returnedList);

	}

}
