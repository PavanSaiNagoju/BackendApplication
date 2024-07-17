package com.usecase.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.usecase.entity.UserDetailsEntity;
import com.usecase.entity.UserRegistrationEntity;
import com.usecase.repo.UserDetailsRepo;
import com.usecase.repo.UserRegistrationRepo;
import com.usecase.service.UserDetailsServiceImpl;

@SpringBootTest
public class AddUserDetailsTest {

	@MockBean
	UserDetailsRepo userDetailsRepo;
	@MockBean
	UserRegistrationRepo userRegisterRepo;
	@Autowired
	UserDetailsServiceImpl Service;

	// ADDING CORRECT USER DETAILS
	@Test
	@DisplayName("Test - Add User details by email - successful")
	public void correctDetailstPassed() {
		String email = "hello@gmail.com";
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu",
				"Chennai", "600073", "Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");

		UserRegistrationEntity userRegister = new UserRegistrationEntity("hello@gmail.com", 21, "M", "9856435672",
				"abc", "hello", user);

		Mockito.doReturn(Arrays.asList(user)).when(userRegisterRepo).save(userRegister);
		try {
			List<UserDetailsEntity> list = Service.addUserDetails(user, email);
			assertEquals(1, list.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@DisplayName("Test - Add User details by email - successful")
	public void correctDetailstPassed2() {
		String email = "hello@gmail.com";
		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu",
				"Chennai", "600073", "Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");

		UserRegistrationEntity userRegister = new UserRegistrationEntity("hello@gmail.com", 21, "M", "9856435672",
				"abc", "hello", user);

		Mockito.doReturn(Arrays.asList(user)).when(userRegisterRepo).save(userRegister);
		try {
			List<UserDetailsEntity> list = Service.addUserDetails(user, email);
			assertNotEquals(0, list.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
