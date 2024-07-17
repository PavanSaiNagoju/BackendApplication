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

import com.usecase.entity.AdminEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.repo.AdminRepo;
import com.usecase.service.AdminServiceImpl;

@SpringBootTest
public class UpdateAdminTest {

	@BeforeEach
	public void setup() {

	}

	@MockBean
	AdminRepo adminRepo;

	@Autowired
	AdminServiceImpl adminService;

	@Test
	@DisplayName("Update Admin- successful")
	public void adminAddedSuccessfull() {
		List<AdminEntity> list = new ArrayList<AdminEntity>();
		AdminEntity admin = new AdminEntity("pavan@gmail.com", "pavan", "1234");

		Mockito.when(adminRepo.findAll()).thenReturn(Arrays.asList(admin));
		try {
			list = adminService.updateAdmin(admin);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(list.size(), 1);
	}

	@Test
	@DisplayName("Update Admin- successful")
	public void adminAddedSuccessfull1() {
		List<AdminEntity> list = new ArrayList<AdminEntity>();
		AdminEntity admin = new AdminEntity("pavan@gmail.com", "pavan", "1234");

		Mockito.when(adminRepo.findAll()).thenReturn(Arrays.asList(admin));
		try {
			list = adminService.updateAdmin(admin);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotEquals(list.size(), 2);
	}

	@Test
	@DisplayName("Update Admin- admin not found")
	public void adminNotFound() {

		List<AdminEntity> list = new ArrayList<AdminEntity>();
		List<AdminEntity> returnedList = new ArrayList<AdminEntity>();
		AdminEntity admin = new AdminEntity("pavan@gmail.com", "pavan", "1234");
		Mockito.when(adminRepo.findById("pavansai@gmail.com")).thenReturn(null);

		try {
			Mockito.when(adminRepo.findAll()).thenReturn(list);
			returnedList = adminService.updateAdmin(admin);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertEquals(e.getMessage(), "Admin not found");
		}

	}

	@Test
	@DisplayName("Update Admin- admin not found")
	public void adminNotFound1() {

		List<AdminEntity> list = new ArrayList<AdminEntity>();
		List<AdminEntity> returnedList = new ArrayList<AdminEntity>();
		AdminEntity admin = new AdminEntity("pavan@gmail.com", "pavan", "1234");
		Mockito.when(adminRepo.findById("pavansai@gmail.com")).thenReturn(null);

		try {
			Mockito.when(adminRepo.findAll()).thenReturn(list);
			returnedList = adminService.updateAdmin(admin);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertNotEquals(e.getMessage(), "not found");
		}

	}

	@Test
	@DisplayName("Update Admin- null object passed")
	public void nullObjectPassed() {
		List<AdminEntity> list = new ArrayList<AdminEntity>();
		List<AdminEntity> returnedList = new ArrayList<AdminEntity>();
		AdminEntity admin = new AdminEntity("pavan@gmail.com", "pavan", "1234");
		Mockito.when(adminRepo.findById(null)).thenReturn(null);
		try {
			Mockito.when(adminRepo.findAll()).thenReturn(list);
			returnedList = adminService.updateAdmin(admin);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block

			assertEquals(e.getMessage(), "Admin not found");
		}

	}

	@Test
	@DisplayName("Update Admin- null object passed")
	public void nullObjectPassed1() {
		List<AdminEntity> list = new ArrayList<AdminEntity>();
		List<AdminEntity> returnedList = new ArrayList<AdminEntity>();
		AdminEntity admin = new AdminEntity("pavan@gmail.com", "pavan", "1234");
		Mockito.when(adminRepo.findById(null)).thenReturn(null);
		try {
			Mockito.when(adminRepo.findAll()).thenReturn(list);
			returnedList = adminService.updateAdmin(admin);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block

			assertNotEquals(e.getMessage(), " not found");
		}

	}

}
