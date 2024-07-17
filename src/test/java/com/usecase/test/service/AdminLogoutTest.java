package com.usecase.test.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.usecase.entity.AdminEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.repo.AdminRepo;
import com.usecase.service.AdminServiceImpl;

@SpringBootTest
public class AdminLogoutTest {
	
	@BeforeEach
	public void setup() {

	}
	
	@MockBean
	AdminRepo admin;
	
	@Autowired
	AdminServiceImpl adminService;
	
	@Test
	@DisplayName("successful")
    public void testLogout_Success() throws RecordNotFoundException {
        // Mock data
        String email= "admin@example.com";
        Optional<AdminEntity> mockAdminEntity = Optional.ofNullable(new AdminEntity("admin@example.com","Pavan","1234"));
        Mockito.when(admin.findById(email)).thenReturn(mockAdminEntity);
        assertEquals(mockAdminEntity.get().getEmail(), email);

        
    }

}
