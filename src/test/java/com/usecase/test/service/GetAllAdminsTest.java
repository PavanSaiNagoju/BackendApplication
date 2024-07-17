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
public class GetAllAdminsTest {

	@BeforeEach
	public void setup() {

	}

	@MockBean
	AdminRepo adminRepo;

	@Autowired
	AdminServiceImpl adminService;

	@Test
	@DisplayName("Show All Admins - successful")
	public void showAllAdminsSuccessfull() {

		List<AdminEntity> list = new ArrayList<AdminEntity>();

		AdminEntity adminEntity = new AdminEntity("pavan@gmail.com", "pavan", "1234");

		AdminEntity adminEntity2 = new AdminEntity("pavansai@gmail.com", "pavansai", "5678");

		Mockito.when(adminRepo.findAll()).thenReturn(Arrays.asList(adminEntity, adminEntity2));

		try {
			list = adminService.getAllAdmins();
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(list.size(), 2);
	}
	
	@Test
	@DisplayName("Show All Admins - successful")
	public void showAllAdminsSuccessfull2() {

		List<AdminEntity> list = new ArrayList<AdminEntity>();

		AdminEntity adminEntity = new AdminEntity("pavan@gmail.com", "pavan", "1234");

		AdminEntity adminEntity2 = new AdminEntity("pavansai@gmail.com", "pavansai", "5678");

		Mockito.when(adminRepo.findAll()).thenReturn(Arrays.asList(adminEntity, adminEntity2));

		try {
			list = adminService.getAllAdmins();
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotEquals(list.size(), 3);
	}

	@Test
	@DisplayName("Show All Admins - no admin found")
	public void noAdminFound() {

		List<AdminEntity> list = new ArrayList<AdminEntity>();
		List<AdminEntity> returnedList = new ArrayList<AdminEntity>();

		Mockito.when(adminRepo.findAll()).thenReturn(list);

		try {
			returnedList = adminService.getAllAdmins();
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(list, returnedList);

	}
	
	@Test
	@DisplayName("Show All Admins - no admin found")
	public void noAdminFound2() {

		List<AdminEntity> list = new ArrayList<AdminEntity>();
		List<AdminEntity> returnedList = new ArrayList<AdminEntity>();
		List<AdminEntity> list1 = null;
		

		Mockito.when(adminRepo.findAll()).thenReturn(list);

		try {
			returnedList = adminService.getAllAdmins();
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotEquals(list1, returnedList);

	}

}
