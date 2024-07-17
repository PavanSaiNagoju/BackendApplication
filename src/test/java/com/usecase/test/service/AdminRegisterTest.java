package com.usecase.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
public class AdminRegisterTest {

	@MockBean
	AdminRepo adminRepo;

	@Autowired
	AdminServiceImpl adminService;

	@Test
	@DisplayName("Test add admin - correct values entered")
	public void correctDetailsEntered() throws RecordNotFoundException {

		AdminEntity adminEntity = new AdminEntity("pavan@gmail.com", "pavan", "1234");
		AdminEntity adminEntity2 = null;
		Mockito.when(adminRepo.saveAndFlush(adminEntity)).thenReturn(adminEntity);

		adminEntity2 = adminService.adminRegister(adminEntity);

		assertEquals(adminEntity, adminEntity2);

	}
	
	@Test
	@DisplayName("Test add admin - correct values entered")
	public void correctDetailsEntered2() throws RecordNotFoundException {

		AdminEntity adminEntity = new AdminEntity("pavan@gmail.com", "pavan", "1234");
		AdminEntity adminEntity3 = new AdminEntity("pavn@gmail.com", "pavan", "1234");
		AdminEntity adminEntity2 = null;
		Mockito.when(adminRepo.saveAndFlush(adminEntity)).thenReturn(adminEntity);

		adminEntity2 = adminService.adminRegister(adminEntity);

		assertEquals(adminEntity, adminEntity2);
		assertNotEquals(adminEntity3, adminEntity);

	}

	@Test
	@DisplayName("Test add admin - null email entered")
	public void nullObjectPassed() {

		AdminEntity adminEntity = null;
		AdminEntity admin = new AdminEntity("", "sai", "5678");
		Mockito.when(adminRepo.saveAndFlush(admin)).thenReturn(admin);

		try {
			adminEntity = adminService.adminRegister(admin);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertEquals(e.getMessage(), "Admin details should not be null");
		}
	}
	
	@Test
	@DisplayName("Test add admin - null email entered")
	public void nullObjectPassed2() {

		AdminEntity adminEntity = null;
		AdminEntity admin = new AdminEntity("", "sai", "5678");
		Mockito.when(adminRepo.saveAndFlush(admin)).thenReturn(admin);

		try {
			adminEntity = adminService.adminRegister(admin);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertNotEquals(e.getMessage(), "Admin should not be null");
		}
	}

	@Test
	@DisplayName("Test add admin - wrong email entered")
	public void wrongEmailEntered() {
		AdminEntity adminEntity = null;
		AdminEntity adminEntity2 = null;
		AdminEntity admin = new AdminEntity("wrongEmail", "sai", "5678");
		Mockito.when(adminRepo.saveAndFlush(admin)).thenReturn(admin);
		AdminEntity admin2 = new AdminEntity("pavan@gmail.com", "sai", "5678");
		Mockito.when(adminRepo.saveAndFlush(admin2)).thenReturn(admin2);
		try {
			adminEntity = adminService.adminRegister(admin);
			adminEntity2 = adminService.adminRegister(admin2);
			assertNotEquals(adminEntity, adminEntity2);

		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

}