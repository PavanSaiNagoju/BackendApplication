package com.usecase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.entity.UserRegistrationEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.service.LogOutServiceImpl;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/homeloan")
public class LogOutController {

	@Autowired
	private LogOutServiceImpl logo;

	// USED TO LOGOUT
	@PostMapping("/logout")
	public ResponseEntity<String> logout(@RequestBody UserRegistrationEntity userbasic) throws RecordNotFoundException {
		UserRegistrationEntity userRegis = logo.logout(userbasic);
		return new ResponseEntity("Logout Successful", HttpStatus.OK);

	}

}
