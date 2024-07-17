package com.usecase.test.service;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.usecase.entity.UserDetailsEntity;
import com.usecase.entity.UserRegistrationEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.repo.UserRegistrationRepo;
import com.usecase.service.LoginService;

@SpringBootTest
public class AuthenticateUserTest {

	@MockBean
	UserRegistrationRepo userRepo;
	@Autowired
	LoginService loginService;

	@Test
	@DisplayName("User Authentication - If Invalid User Found")
	public void invalidUserFound() {
		UserDetailsEntity userdetails = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		UserRegistrationEntity user = new UserRegistrationEntity("hello@gmail.com", 21, "M", "9856435672", "abc",
				"hello", userdetails);

		try {
			Mockito.doReturn(Optional.of(user)).when(userRepo).findById("saranya@gmail.com");

			UserRegistrationEntity retUser = loginService.authenticateUser("saranya@gmailcom", "pass");
		} catch (Exception exception) {
			assertEquals(exception.getMessage(), "No record exists for given user");
		}
	}

	@Test
	@DisplayName("User Authentication - If Invalid User Found")
	public void invalidUserFound2() {
		UserDetailsEntity userdetails = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		UserRegistrationEntity user = new UserRegistrationEntity("hello@gmail.com", 21, "M", "9856435672", "abc",
				"hello", userdetails);

		try {
			Mockito.doReturn(Optional.of(user)).when(userRepo).findById("saranya@gmail.com");

			UserRegistrationEntity retUser = loginService.authenticateUser("saranya@gmailcom", "pass");
		} catch (Exception exception) {
			assertNotEquals(exception.getMessage(), "No record for given user");
		}
	}

	@Test
	@DisplayName("User Authentication - If No Email Entered")
	public void nullDetailsFound() throws RecordNotFoundException {
		UserDetailsEntity userdetails = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		UserRegistrationEntity user = new UserRegistrationEntity("hello@gmail.com", 21, "M", "9856435672", "abc",
				"hello", userdetails);

		Mockito.doReturn(Optional.of(user)).when(userRepo).findById("saranya@gmail.com");

		try {
			UserRegistrationEntity retUser = (loginService.authenticateUser("", "password"));
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			assertEquals(e.getMessage(), "Invalid Details! please enter correct details");
		}

	}

	@Test
	@DisplayName("User Authentication - If No Email Entered")
	public void nullDetailsFound2() throws RecordNotFoundException {
		UserDetailsEntity userdetails = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		UserRegistrationEntity user = new UserRegistrationEntity("hello@gmail.com", 21, "M", "9856435672", "abc",
				"hello", userdetails);

		Mockito.doReturn(Optional.of(user)).when(userRepo).findById("saranya@gmail.com");

		try {
			UserRegistrationEntity retUser = (loginService.authenticateUser("", "password"));
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			assertNotEquals(e.getMessage(), "Invalid ! please enter correct details");
		}

	}

	@Test
	@DisplayName("User Authentication - If Password Incorrect for given Email")
	public void incorrectPasswordFound() {
		UserDetailsEntity userdetails = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		UserRegistrationEntity user = new UserRegistrationEntity("hello@gmail.com", 21, "M", "9856435672", "abc",
				"hello", userdetails);

		Mockito.doReturn(Optional.of(user)).when(userRepo).findById("saranya24@gmail.com");

		try {
			UserRegistrationEntity retUser = (loginService.authenticateUser("saranya24@gmail.com", "pass"));
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			assertEquals(e.getMessage(), "password does not matches");
		}

	}

	@Test
	@DisplayName("User Authentication - If Password Incorrect for given Email")
	public void incorrectPasswordFound2() {
		UserDetailsEntity userdetails = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		UserRegistrationEntity user = new UserRegistrationEntity("hello@gmail.com", 21, "M", "9856435672", "abc",
				"hello", userdetails);

		Mockito.doReturn(Optional.of(user)).when(userRepo).findById("saranya24@gmail.com");

		try {
			UserRegistrationEntity retUser = (loginService.authenticateUser("saranya24@gmail.com", "pass"));
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			assertNotEquals(e.getMessage(), "password not matches");
		}

	}

	@Test
	@DisplayName("User Authentication - If User SignIn successful")
	public void successfulLogin() {
		UserDetailsEntity userdetails = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		UserRegistrationEntity user = new UserRegistrationEntity("hello@gmail.com", 21, "M", "9856435672", "abc",
				"hello", userdetails);

		Mockito.doReturn(Optional.of(user)).when(userRepo).findById("saranya24@gmail.com");

		try {
			UserRegistrationEntity retUser = (loginService.authenticateUser("saranya24@gmail.com", "password"));
			assertSame(user, retUser);
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Test
	@DisplayName("User Authentication - If User SignIn successful")
	public void successfulLogin2() {
		UserDetailsEntity userdetails = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		UserRegistrationEntity user = new UserRegistrationEntity("hello@gmail.com", 21, "M", "9856435672", "abc",
				"hello", userdetails);
		UserRegistrationEntity user1 = null;
		Mockito.doReturn(Optional.of(user)).when(userRepo).findById("saranya24@gmail.com");

		try {
			UserRegistrationEntity retUser = (loginService.authenticateUser("saranya24@gmail.com", "password"));
			assertSame(user, retUser);
			assertNotSame(retUser, user1);
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}

	}

}