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

import com.usecase.entity.AdminEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.repo.AdminRepo;
import com.usecase.service.AdminServiceImpl;

@SpringBootTest
public class ShowAdminDetailsByEmailTest {

	@BeforeEach
	public void setup() {

	}

	@MockBean
	AdminRepo adminRepo;

	@Autowired
	AdminServiceImpl adminService;

	@Test
	@DisplayName("Test - show admin details by email - successful")
	public void correctObjectPassed() {
		String email = "pavan@gmail.com";
		Optional<AdminEntity> adminEntity = null;

		AdminEntity admin = new AdminEntity("pavan@gmail.com", "pavansai", "1234");

		Mockito.when(adminRepo.saveAndFlush(admin)).thenReturn(admin);
		Mockito.when(adminRepo.findById(email)).thenReturn(Optional.of(admin));

		try {
			adminEntity = Optional.of(adminService.showAdminDetailsByEmail(email));
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(adminEntity.get(), admin);

	}
	
	@Test
	@DisplayName("Test - show admin details by email - successful")
	public void correctObjectPassed1() {
		String email = "pavan@gmail.com";
		Optional<AdminEntity> adminEntity = null;

		AdminEntity admin = new AdminEntity("pavan@gmail.com", "pavansai", "1234");

		AdminEntity admin1 = null;
		Mockito.when(adminRepo.saveAndFlush(admin)).thenReturn(admin);
		Mockito.when(adminRepo.findById(email)).thenReturn(Optional.of(admin));

		try {
			adminEntity = Optional.of(adminService.showAdminDetailsByEmail(email));
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotEquals(adminEntity.get(), admin1);

	}
	

	@Test
	@DisplayName("Show admin details by email - wrong email entered")
	public void wrongEmailEntered() {

		String email = "pavansai@gmail.com";

		AdminEntity admin = new AdminEntity("pavan@gmail.com", "pavansai", "1234");
		Optional<AdminEntity> admin1 = null;
		AdminEntity admin2 = null;
		Mockito.when(adminRepo.saveAndFlush(admin)).thenReturn(admin);
		Mockito.when(adminRepo.findById(email)).thenReturn(admin1);

		try {
			admin2 = adminService.showAdminDetailsByEmail(email);
			assertEquals(admin1, admin2);
		} catch (RecordNotFoundException e) {

		}

	}
	
	@Test
	@DisplayName("Show admin details by email - wrong email entered")
	public void wrongEmailEntered2() {

		String email = "pavansai@gmail.com";

		AdminEntity admin = new AdminEntity("pavan@gmail.com", "pavansai", "1234");
		Optional<AdminEntity> admin1 = null;
		AdminEntity admin2 = null;
		Mockito.when(adminRepo.saveAndFlush(admin)).thenReturn(admin);
		Mockito.when(adminRepo.findById(email)).thenReturn(admin1);

		try {
			admin2 = adminService.showAdminDetailsByEmail(email);
			assertEquals(admin1, admin2);
			assertNotEquals(admin2.getName(), email);
		} catch (RecordNotFoundException e) {

		}

	}

}