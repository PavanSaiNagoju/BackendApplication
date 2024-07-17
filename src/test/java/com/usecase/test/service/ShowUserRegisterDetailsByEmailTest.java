package com.usecase.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Optional;

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
public class ShowUserRegisterDetailsByEmailTest {

	@Autowired
	private UserRegisterServiceImpl userRegisterService;

	@MockBean
	UserRegistrationRepo userRegisterRepo;

	// NO EMAIL ENTERED
	@Test
	@DisplayName("Show user details by email- no email entered")
	public void noEmailEntered() {

		String email = null;
		Optional<UserRegistrationEntity> user = Optional.of(new UserRegistrationEntity("wonders@gmail.com", 41,
				"female", "9988776611", "wonderlands", "SaiRam", null));
		UserRegistrationEntity user2 = null;
		Optional<UserRegistrationEntity> user1 = null;
		Mockito.when(userRegisterRepo.findById(email)).thenReturn(user1);

		try {
			user2 = userRegisterService.showUserRegistrationInformationByEmail(email);
			assertEquals(user1, user2);
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	@DisplayName("Show user details by email- no email entered")
	public void noEmailEntered1() {

		String email = null;
		Optional<UserRegistrationEntity> user = Optional.of(new UserRegistrationEntity("wonders@gmail.com", 41,
				"female", "9988776611", "wonderlands", "SaiRam", null));
		UserRegistrationEntity user2 = null;
		Optional<UserRegistrationEntity> user1 = null;
		Mockito.when(userRegisterRepo.findById(email)).thenReturn(user1);

		try {
			user2 = userRegisterService.showUserRegistrationInformationByEmail(email);
			assertNotEquals(user1.get().getAge(), user2.getEmail());
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}

	}

	// WRONG EMAIL ENTERED
	@Test
	@DisplayName("Show user details by email - wrong email entered")
	public void wrongEmailEntered() {

		String email = "wondersree@gmail.com";

		Optional<UserRegistrationEntity> user = Optional.of(new UserRegistrationEntity("wonders@gmail.com", 41,
				"female", "9988776611", "wonderlands", "SaiRam", null));

		Optional<UserRegistrationEntity> user1 = null;
		UserRegistrationEntity user2 = null;
		Mockito.when(userRegisterRepo.findById(email)).thenReturn(user1);

		try {
			user2 = userRegisterService.showUserRegistrationInformationByEmail(email);
			assertEquals(user1, user2);
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Test
	@DisplayName("Show user details by email - wrong email entered")
	public void wrongEmailEntered1() {

		String email = "wondersree@gmail.com";

		Optional<UserRegistrationEntity> user = Optional.of(new UserRegistrationEntity("wonders@gmail.com", 41,
				"female", "9988776611", "wonderlands", "SaiRam", null));

		Optional<UserRegistrationEntity> user1 = null;
		UserRegistrationEntity user2 = null;
		Mockito.when(userRegisterRepo.findById(email)).thenReturn(user1);

		try {
			user2 = userRegisterService.showUserRegistrationInformationByEmail(email);
			assertNotEquals(user1.get().getEmail(), user2.getEmail());
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	// SHOW USER DETAILS BY EMAIL
	@Test
	@DisplayName("Test - show user details by email - successful")
	public void correctObjectPassed() {
		String email = "wonders@gmail.com";
		Optional<UserRegistrationEntity> userRegisterEntity = null;

		UserRegistrationEntity user = new UserRegistrationEntity("wonders@gmail.com", 41, "female", "9988776611",
				"wonderlands", "SaiRam", null);

		Mockito.when(userRegisterRepo.saveAndFlush(user)).thenReturn(user);
		Mockito.when(userRegisterRepo.findById(email)).thenReturn(Optional.of(user));

		try {
			userRegisterEntity = Optional.of(userRegisterService.showUserRegistrationInformationByEmail(email));
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(userRegisterEntity.get(), user);

	}
	
	@Test
	@DisplayName("Test - show user details by email - successful")
	public void correctObjectPassed2() {
		String email = "wonders@gmail.com";
		Optional<UserRegistrationEntity> userRegisterEntity = null;

		UserRegistrationEntity user = new UserRegistrationEntity("wonders@gmail.com", 41, "female", "9988776611",
				"wonderlands", "SaiRam", null);

		Mockito.when(userRegisterRepo.saveAndFlush(user)).thenReturn(user);
		Mockito.when(userRegisterRepo.findById(email)).thenReturn(Optional.of(user));

		try {
			userRegisterEntity = Optional.of(userRegisterService.showUserRegistrationInformationByEmail(email));
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(userRegisterEntity.get().getEmail(), user.getEmail());

	}
}
