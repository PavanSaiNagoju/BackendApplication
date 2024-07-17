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

import com.usecase.entity.AdminEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.service.AdminServiceImpl;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/homeloan")
public class AdminController {
	@Autowired
	private AdminServiceImpl adminService;

	// Adding an Admin
	@PostMapping("/admin")
	public ResponseEntity<AdminEntity> adminRegister(@Valid @RequestBody AdminEntity admin)
			throws RecordNotFoundException {

		AdminEntity adminEntity = adminService.adminRegister(admin);
		return new ResponseEntity<AdminEntity>(adminEntity, HttpStatus.OK);

	}

	// Get Admin by EmailID
	@GetMapping("/admin/{adminEmailId}")
	public ResponseEntity<AdminEntity> showAdminDetailsByEmail(@PathVariable("adminEmailId") String mail)
			throws RecordNotFoundException {

		AdminEntity adminEntity = adminService.showAdminDetailsByEmail(mail);
		return new ResponseEntity<AdminEntity>(adminEntity, HttpStatus.OK);

	}

	// Edit Admin by EmailId
	@PutMapping("/admin/{adminEmailId}")
	public ResponseEntity<List<AdminEntity>> updateAdmin(@Valid @RequestBody AdminEntity admin)
			throws RecordNotFoundException {

		List<AdminEntity> adminEntity = adminService.updateAdmin(admin);
		return new ResponseEntity<List<AdminEntity>>(adminEntity, HttpStatus.OK);

	}

	// Get all Admins
	@GetMapping("/admin")
	public ResponseEntity<List<AdminEntity>> getAllAdmins() throws RecordNotFoundException {

		List<AdminEntity> adminEntity = adminService.getAllAdmins();
		return new ResponseEntity<List<AdminEntity>>(adminEntity, HttpStatus.OK);
	}

	// Admin Logout
	@PostMapping("/admin/logout")
	public ResponseEntity<String> logout(@RequestBody AdminEntity admin) throws RecordNotFoundException {

		return new ResponseEntity("Logout Successful", HttpStatus.OK);

	}
}