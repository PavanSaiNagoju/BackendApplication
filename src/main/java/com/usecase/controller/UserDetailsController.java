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

import com.usecase.entity.UserDetailsEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.service.UserDetailsServiceImpl;

import jakarta.validation.Valid;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/homeloan")
public class UserDetailsController {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@PostMapping("/userdetails/{email}")
	public ResponseEntity<List<UserDetailsEntity>> addUserDetails(@PathVariable("email") String email,
			@Valid @RequestBody UserDetailsEntity user) throws RecordNotFoundException {
		List<UserDetailsEntity> users = userDetailsService.addUserDetails(user, email);
		return new ResponseEntity<List<UserDetailsEntity>>(users, HttpStatus.OK);
	}

	
	@PutMapping("/userdetails")
	public ResponseEntity<List<UserDetailsEntity>> updateUser(@RequestBody UserDetailsEntity user)
			throws RecordNotFoundException {
		List<UserDetailsEntity> users = userDetailsService.editUserDetails(user);
		return new ResponseEntity<List<UserDetailsEntity>>(users, HttpStatus.OK);
	}

	@GetMapping("/userdetails/{user_id}")
	public ResponseEntity<UserDetailsEntity> findUser(@PathVariable("user_id") Integer userId) throws RecordNotFoundException {
		UserDetailsEntity user = userDetailsService.showUserDetailsInformationByUserId(userId);
		return new ResponseEntity<UserDetailsEntity>(user, HttpStatus.OK);
	}

	@GetMapping("/userdetails")
	public ResponseEntity<List<UserDetailsEntity>> getAllUsers() throws RecordNotFoundException {
		List<UserDetailsEntity> users = userDetailsService.showAllUserDetails();
		return new ResponseEntity<List<UserDetailsEntity>>(users, HttpStatus.OK);
	}

}
