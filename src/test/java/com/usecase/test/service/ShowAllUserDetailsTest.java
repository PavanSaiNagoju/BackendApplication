package com.usecase.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class ShowAllUserDetailsTest {
	@BeforeEach
	public void setup() {

	}

	@MockBean
	UserDetailsRepo userDetailsRepo;

	@Autowired
	UserDetailsServiceImpl Service;

	// SHOWING USER DETAILS
	@Test
	@DisplayName("Show UserDetails- successful")
	public void showAllUserDetailsSuccessfull() throws RecordNotFoundException {
		List<UserDetailsEntity> list = new ArrayList<UserDetailsEntity>();
		UserDetailsEntity user1 = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		UserDetailsEntity user2 = new UserDetailsEntity(45, "Santhosapuram2", "Gujarat", "Gauhathi", "455773",
				"Full time", 7000000.0, "Yes", "Yes", "Yes", "Yes");
		Mockito.when(userDetailsRepo.findAll()).thenReturn(Arrays.asList(user1, user2));
		list = Service.showAllUserDetails();
		assertEquals(list.size(), 2);
	}
	
	@Test
	@DisplayName("Show UserDetails- successful")
	public void showAllUserDetailsSuccessfull1() throws RecordNotFoundException {
		List<UserDetailsEntity> list = new ArrayList<UserDetailsEntity>();
		UserDetailsEntity user1 = new UserDetailsEntity(12345, "Santhosapuram", "Tamil Nadu", "Chennai", "600073",
				"Full time", 5000000.0, "Yes", "Yes", "Yes", "Yes");
		UserDetailsEntity user2 = new UserDetailsEntity(45, "Santhosapuram2", "Gujarat", "Gauhathi", "455773",
				"Full time", 7000000.0, "Yes", "Yes", "Yes", "Yes");
		Mockito.when(userDetailsRepo.findAll()).thenReturn(Arrays.asList(user1, user2));
		list = Service.showAllUserDetails();
		assertNotEquals(list.size(), 8);
	}

	// NULL USER DETAILS
	@Test
	@DisplayName("Show UserDetails- Null")
	public void NullUserDetailsEntered() throws RecordNotFoundException {
		List<UserDetailsEntity> userDetails = new ArrayList<UserDetailsEntity>();
		List<UserDetailsEntity> user = null;
		Mockito.when(userDetailsRepo.findAll()).thenReturn(user);
		userDetails = Service.showAllUserDetails();
		assertEquals(user, userDetails);
	}
	
	@Test
	@DisplayName("Show UserDetails- Null")
	public void NullUserDetailsEntered1() throws RecordNotFoundException {
		List<UserDetailsEntity> userDetails = new ArrayList<UserDetailsEntity>();
		
		UserDetailsEntity user2 = new UserDetailsEntity(45, "Santhosapuram2", "Gujarat", "Gauhathi", "455773",
				"Full time", 7000000.0, "Yes", "Yes", "Yes", "Yes");
		List<UserDetailsEntity> user = null;
		Mockito.when(userDetailsRepo.findAll()).thenReturn(user);
		userDetails = Service.showAllUserDetails();
		assertNotEquals(user, user2.getAadhar());
	}

	// NO USERS FOUND
	@Test
	@DisplayName("Show All Users - no user found")
	public void noUserFound() {

		List<UserDetailsEntity> list = new ArrayList<UserDetailsEntity>();
		List<UserDetailsEntity> returnedList = new ArrayList<UserDetailsEntity>();

		Mockito.when(userDetailsRepo.findAll()).thenReturn(list);

		try {
			returnedList = Service.showAllUserDetails();
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(list, returnedList);

	}
	
	
}
