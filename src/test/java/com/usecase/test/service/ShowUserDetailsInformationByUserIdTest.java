package com.usecase.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.usecase.entity.UserDetailsEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.repo.UserDetailsRepo;
import com.usecase.service.UserDetailsServiceImpl;

@SpringBootTest
public class ShowUserDetailsInformationByUserIdTest {
	@BeforeEach
	public void setup() {
	}

	@MockBean
	UserDetailsRepo userDetailsRepo;
	@Autowired
	UserDetailsServiceImpl Service;

	@Test
	@DisplayName("Show User details by Id- no UserId entered")
	public void noUserIdEntered() {

		int user_id=0;
		Optional<UserDetailsEntity> user = Optional.of(new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu",
				"Chennai", "600073", "Full time", 5000000.0, "Yes", "Yes", "sYes", "Yes"));
		Optional<UserDetailsEntity> user1 = null;
		UserDetailsEntity user2 = null;
		Mockito.when(userDetailsRepo.findById(user_id)).thenReturn(user1);
		
			try {
				user2 = Service.showUserDetailsInformationByUserId(user_id);
				assertEquals(user1, user2);
			} catch (RecordNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		

	}
	
	@Test
	@DisplayName("Show User details by Id- no UserId entered")
	public void noUserIdEntered1() {

		int user_id = 0;
		Optional<UserDetailsEntity> user = Optional.of(new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu",
				"Chennai", "600073", "Full time", 5000000.0, "Yes", "Yes", "sYes", "Yes"));
		Optional<UserDetailsEntity> user1 = null;
		UserDetailsEntity user2 = null;
		Mockito.when(userDetailsRepo.findById(user_id)).thenReturn(user1);
		
			try {
				user2 = Service.showUserDetailsInformationByUserId(user_id);
			} catch (RecordNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		assertNotEquals(user, user2);

	}

	@Test
	@DisplayName("Test - show User details by UserId - UserId Entered")
	public void correctObjectPassed() {
		int user_id = 1;
		Optional<UserDetailsEntity> userDetailsEntity = null;

		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "sYes", "Yes");

		Mockito.when(userDetailsRepo.saveAndFlush(user)).thenReturn(user);
		Mockito.when(userDetailsRepo.findById(user_id)).thenReturn(Optional.of(user));

		try {
			userDetailsEntity = Optional.of(Service.showUserDetailsInformationByUserId(user_id));
		} catch (RecordNotFoundException e) {

		}
		assertEquals(userDetailsEntity.get(), user);

	}
	
	@Test
	@DisplayName("Test - show User details by UserId - UserId Entered")
	public void correctObjectPassed1() {
		int user_id = 1;
		Optional<UserDetailsEntity> userDetailsEntity = null;

		UserDetailsEntity user = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "sYes", "Yes");

		Mockito.when(userDetailsRepo.saveAndFlush(user)).thenReturn(user);
		Mockito.when(userDetailsRepo.findById(user_id)).thenReturn(Optional.of(user));

		try {
			userDetailsEntity = Optional.of(Service.showUserDetailsInformationByUserId(user_id));
		} catch (RecordNotFoundException e) {

		}
		assertEquals(userDetailsEntity.get().getAadhar(), user.getAadhar());

	}

	@Test
	@DisplayName("Show UserDetails By UserId-  UserDetails not present")
	public void UserDetailsNotEntered() {
		int user_id = 1;
		UserDetailsEntity userDetails = null;
		Optional<UserDetailsEntity> user = null;
		Mockito.when(userDetailsRepo.findById(user_id)).thenReturn((user));
		try {
			userDetails = Service.showUserDetailsInformationByUserId(user_id);
		} catch (RecordNotFoundException e) {
			assertEquals(e.getMessage(), "No Records Found");
		}

	}
	
	@Test
	@DisplayName("Show UserDetails By UserId-  UserDetails not present")
	public void UserDetailsNotEntered1() {
		int user_id = 1;
		UserDetailsEntity userDetails = null;
		Optional<UserDetailsEntity> user = null;
		Mockito.when(userDetailsRepo.findById(user_id)).thenReturn((user));
		try {
			userDetails = Service.showUserDetailsInformationByUserId(user_id);
		} catch (RecordNotFoundException e) {
			assertNotEquals(e.getMessage(), "No Found");
		}

	}
}
