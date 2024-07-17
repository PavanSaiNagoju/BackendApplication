package com.usecase.test.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
public class UserSignInTest {

	@MockBean
	UserRegistrationRepo userRepo;
	@Autowired
	LoginService loginService;

	@Test
	@DisplayName("UserAuthentication - If Invalid User Found")
	public void invalidUserFound() {
		Optional<UserRegistrationEntity> mockUser = null;
		UserRegistrationEntity retUser = null;
		try {
			Mockito.doReturn(Optional.of(mockUser)).when(userRepo).findById("Pavan24@gmail.com");

			retUser = loginService.authenticateUser("Pavan24@gmail.com", "pass");

		} catch (Exception exception) {
			assertNull(retUser);

		}
	}
	
	

	@Test
	@DisplayName("User Authentication - If No Email Entered")
	public void nullDetailsFound() throws RecordNotFoundException {
		UserRegistrationEntity user = null;

		try {
			Mockito.doReturn(Optional.of(user)).when(userRepo).findById("saranya@gmail.com");
			UserRegistrationEntity retUser = (loginService.authenticateUser("", "password"));
			assertEquals(user, retUser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertNotNull(e);
		}

	}

	
	@Test
	@DisplayName("User Authentication - If No Email Entered")
	public void nullDetailsFound1() throws RecordNotFoundException {
		UserRegistrationEntity user = null;

		try {
			Mockito.doReturn(Optional.of(user)).when(userRepo).findById("Pavan.com");
			UserRegistrationEntity retUser = (loginService.authenticateUser("Pavan@gmail.com", "password"));
			assertNotEquals(user, retUser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertNotNull(e);
		}

	}

	@Test
	@DisplayName("User Authentication - If Password Incorrect for given Email")
	public void incorrectPasswordFound() {
		UserDetailsEntity userdetails = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai",
				"600073", "Full time", 5000000.0, "Yes", "Yes", "sYes", "Yes");
		UserRegistrationEntity user = new UserRegistrationEntity("Pavan24@gmail.com", 20, "Female", "98877766555",
				"saranya", "password", userdetails);

		Mockito.doReturn(Optional.of(user)).when(userRepo).findById("Pavan24@gmail.com");

		try {
			UserRegistrationEntity retUser = (loginService.authenticateUser("Pavan24@gmail.com", "pass"));
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			assertEquals(e.getMessage(), "password does not matches");
		}

	}
	
	@Test
	@DisplayName("User Authentication - If Password Incorrect for given Email")
	public void incorrectPasswordFound1() {
		UserDetailsEntity userdetails = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai",
				"600073", "Full time", 5000000.0, "Yes", "Yes", "sYes", "Yes");
		UserRegistrationEntity user = new UserRegistrationEntity("Pavan24@gmail.com", 20, "Female", "98877766555",
				"saranya", "password", userdetails);

		Mockito.doReturn(Optional.of(user)).when(userRepo).findById("Pavan24@gmail.com");

		try {
			UserRegistrationEntity retUser = (loginService.authenticateUser("Pavan24@gmail.com", "pass"));
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			assertNotEquals(e.getMessage(), "password not matches");
		}

	}

	@Test
	@DisplayName("User Authentication - If User SignIn sucessful")
	public void successfulLogin() {
		UserDetailsEntity userdetails = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai",
				"600073", "Full time", 5000000.0, "Yes", "Yes", "sYes", "Yes");
		UserRegistrationEntity user = new UserRegistrationEntity("Pavan24@gmail.com", 20, "Female", "98877766555",
				"saranya", "password", userdetails);

		Mockito.doReturn(Optional.of(user)).when(userRepo).findById("Pavan24@gmail.com");

		try {
			UserRegistrationEntity retUser = (loginService.authenticateUser("Pavan24@gmail.com", "password"));
			assertSame(user, retUser);
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	@DisplayName("User Authentication - If User SignIn sucessful")
	public void successfulLogin1() {
		UserDetailsEntity userdetails = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai",
				"600073", "Full time", 5000000.0, "Yes", "Yes", "sYes", "Yes");
		UserRegistrationEntity user = new UserRegistrationEntity("Pavan24@gmail.com", 20, "Female", "98877766555",
				"saranya", "password", userdetails);

		Mockito.doReturn(Optional.of(user)).when(userRepo).findById("Pavan24@gmail.com");

		try {
			UserRegistrationEntity retUser = (loginService.authenticateUser("Pavan24@gmail.com", "password"));
			assertSame(user.getAge(), retUser.getAge());
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}

	}

}
