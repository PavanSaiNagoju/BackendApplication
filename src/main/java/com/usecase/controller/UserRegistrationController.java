package com.usecase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.entity.UserRegistrationEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.service.UserRegisterServiceImpl;

import jakarta.validation.Valid;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/homeloan")
public class UserRegistrationController {

	@Autowired
	private UserRegisterServiceImpl userRegis;

	// Working
	@PostMapping("/userregister")
	public ResponseEntity<UserRegistrationEntity> userRegister(@RequestBody UserRegistrationEntity userbasic)
			throws RecordNotFoundException {
		UserRegistrationEntity userRegister = userRegis.userRegister(userbasic);
		return new ResponseEntity<UserRegistrationEntity>(userRegister, HttpStatus.OK);
	}

	// workings
	@GetMapping("/userregister/{email}")
	public ResponseEntity<UserRegistrationEntity> showUserRegistrationInformation(@PathVariable("email") String email)
			throws RecordNotFoundException {
		UserRegistrationEntity userRegister = userRegis.showUserRegistrationInformationByEmail(email);
		return new ResponseEntity<UserRegistrationEntity>(userRegister, HttpStatus.OK);
	}

	// Working
	@GetMapping("/userregister")
	public ResponseEntity<List<UserRegistrationEntity>> getAllUsers() throws RecordNotFoundException {
		List<UserRegistrationEntity> userRegister = userRegis.getAllUsers();
		return new ResponseEntity<List<UserRegistrationEntity>>(userRegister, HttpStatus.OK);
	}

	// Working
	@PutMapping("/userregister")
	public ResponseEntity<List<UserRegistrationEntity>> passwordReset(
			@Valid @RequestBody UserRegistrationEntity userbasic) throws RecordNotFoundException {
		List<UserRegistrationEntity> userRegister = userRegis.passwordReset(userbasic);
		return new ResponseEntity<List<UserRegistrationEntity>>(userRegister, HttpStatus.OK);
	}

}