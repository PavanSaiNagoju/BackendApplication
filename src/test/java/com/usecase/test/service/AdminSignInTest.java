package com.usecase.test.service;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
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

import com.usecase.entity.AdminEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.repo.AdminRepo;
import com.usecase.service.LoginService;

@SpringBootTest
public class AdminSignInTest {
	@MockBean
	AdminRepo adminRepo;

	@Autowired
	LoginService loginService;

	@Test
	@DisplayName("Admin Signin - If Invalid Details Found")
	public void invalidDetailsFound() {
		AdminEntity admin = null;
		AdminEntity retadmin = null;
		Mockito.doReturn(admin).when(adminRepo).findById("admin@gmail.com");
		try {

			retadmin = loginService.authenticateAdmin("admin@gmail.com", "password");

		} catch (Exception e) {
			assertNull(retadmin);
		}
	}

	@Test
	@DisplayName("Admin Signin - If Password Doest matches")
	public void invalidPasswordFound() {
		AdminEntity admin = new AdminEntity("admin@gmail.com", "admin", "password");
		Mockito.doReturn(Optional.of(admin)).when(adminRepo).findById("admin@gmail.com");
		try {
			AdminEntity retadmin = loginService.authenticateAdmin("admin@gmail.com", "pass");
		} catch (RecordNotFoundException e) {
			assertEquals(e.getMessage(), "Password does not match");
		}
	}
	
	@Test
	@DisplayName("Admin Signin - If Password Doest matches")
	public void invalidPasswordFound2() {
		AdminEntity admin = new AdminEntity("admin@gmail.com", "admin", "password");
		Mockito.doReturn(Optional.of(admin)).when(adminRepo).findById("admin@gmail.com");
		try {
			AdminEntity retadmin = loginService.authenticateAdmin("admin@gmail.com", "pass");
		} catch (RecordNotFoundException e) {
			assertNotEquals(e.getMessage(), "Password not match");
		}
	}

	@Test
	@DisplayName("Admin Signin - If Record Found")
	public void correctDetailsFound() {
		AdminEntity admin = new AdminEntity("admin@gmail.com", "admin", "password");
		Mockito.doReturn(Optional.of(admin)).when(adminRepo).findById("admin@gmail.com");
		try {
			AdminEntity retadmin = loginService.authenticateAdmin("admin@gmail.com", "password");
			assertSame(admin, retadmin);
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@DisplayName("Admin Signin - If Record Found")
	public void correctDetailsFound2() {
		AdminEntity admin = new AdminEntity("admin@gmail.com", "admin", "password");
		AdminEntity admin1 = new AdminEntity("adm@gmail.com", "admin", "password");
		Mockito.doReturn(Optional.of(admin)).when(adminRepo).findById("admin@gmail.com");
		try {
			AdminEntity retadmin = loginService.authenticateAdmin("admin@gmail.com", "password");
			assertSame(admin, retadmin);
			assertNotSame(admin1, retadmin);
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}

}
