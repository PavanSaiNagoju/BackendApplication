package com.usecase.test.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
public class PasswordResetTest {

	@Autowired
	private UserRegisterServiceImpl userRegisterService;

	@MockBean
	UserRegistrationRepo userRegisterRepo;

	@Test
	@DisplayName("passwordReset - successful")
	public void updatepassword() throws RecordNotFoundException {
		String password = "SaiRam";
		UserRegistrationEntity userRegisterEntity = new UserRegistrationEntity("wonders@gmail.com", 41, "female",
				"9988745611", "wonderlands", "SaiRam", null);
		Mockito.when(userRegisterRepo.findAll()).thenReturn(Stream.of(userRegisterEntity).collect(Collectors.toList()));
		List<UserRegistrationEntity> updatelist = null;
		try {
			updatelist = userRegisterService.passwordReset(userRegisterEntity);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(updatelist.get(0).getPassword(), password);
	}

	@Test
	@DisplayName("passwordReset - successful")
	public void updatepassword2() throws RecordNotFoundException {
		String password = "SaiRam";
		UserRegistrationEntity userRegisterEntity = new UserRegistrationEntity("wonders@gmail.com", 41, "female",
				"9988745611", "wonderlands", "SaiRam", null);
		Mockito.when(userRegisterRepo.findAll()).thenReturn(Stream.of(userRegisterEntity).collect(Collectors.toList()));
		List<UserRegistrationEntity> updatelist = null;
		try {
			updatelist = userRegisterService.passwordReset(userRegisterEntity);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotEquals(updatelist.get(0).getAge(), password);
	}
	
	@Test
	@DisplayName("passwordReset - NotNull")
	public void passwordResetNotNull() throws RecordNotFoundException {
		UserRegistrationEntity userRegisterEntity = new UserRegistrationEntity("wonders@gmail.com", 41, "female",
				"9988776611", "wonderlands", null, null);
		Mockito.when(userRegisterRepo.findAll()).thenReturn(Stream.of(userRegisterEntity).collect(Collectors.toList()));
		List<UserRegistrationEntity> updatelist = null;
		try {
			updatelist = userRegisterService.passwordReset(userRegisterEntity);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNull(updatelist.get(0).getPassword());
	}
	
	@Test
	@DisplayName("passwordReset - NotNull")
	public void passwordResetNotNull2() throws RecordNotFoundException {
		UserRegistrationEntity userRegisterEntity = new UserRegistrationEntity("wonders@gmail.com", 41, "female",
				"9988776611", "wonderlands", null, null);
		Mockito.when(userRegisterRepo.findAll()).thenReturn(Stream.of(userRegisterEntity).collect(Collectors.toList()));
		List<UserRegistrationEntity> updatelist = null;
		try {
			updatelist = userRegisterService.passwordReset(userRegisterEntity);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNull(updatelist.get(0).getPassword());
		assertEquals(null,updatelist.get(0).getPassword());
	}

	@Test
	@DisplayName("passwordReset - Entered wrong password")
	public void passwordEnteredWrong() throws RecordNotFoundException {
		String password = "-0k9098877d";
		UserRegistrationEntity userRegisterEntity1 = new UserRegistrationEntity("wonders@gmail.com", 41, "female",
				"9988776611", "wonderlands", "SaiRam", null);
		Mockito.when(userRegisterRepo.findAll())
				.thenReturn(Stream.of(userRegisterEntity1).collect(Collectors.toList()));
		List<UserRegistrationEntity> userRegisterEntity2 = null;
		try {
			userRegisterEntity2 = userRegisterService.passwordReset(userRegisterEntity1);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(userRegisterEntity2.get(0), userRegisterEntity1);
	}
	
	

	// ENTERED ALREADY EXISTING PASSWORD
	@Test
	@DisplayName("passwordReset - Entered Already Existing password")
	public void AlreadyExistingpasswordEntered() throws RecordNotFoundException {
		String password = "SaiRam";
		UserRegistrationEntity userRegisterEntity = new UserRegistrationEntity("wonders@gmail.com", 41, "female",
				"9988776611", "wonderlands", "SaiRam", null);
		Mockito.when(userRegisterRepo.findAll()).thenReturn(Stream.of(userRegisterEntity).collect(Collectors.toList()));
		List<UserRegistrationEntity> updatelist = null;
		try {
			updatelist = userRegisterService.passwordReset(userRegisterEntity);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(updatelist.get(0).getPassword(), password);
	}
	
	
}
