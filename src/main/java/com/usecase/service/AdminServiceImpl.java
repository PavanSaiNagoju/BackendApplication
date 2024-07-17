package com.usecase.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.usecase.entity.AdminEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.repo.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {

	static Logger log = Logger.getLogger(AdminServiceImpl.class.getClass());

	@Autowired
	private AdminRepo adminRepo;

	@Override
	public List<AdminEntity> updateAdmin(AdminEntity admin) throws RecordNotFoundException {
		log.info("Service Layer - Entry - updateAdminByEmail");
		try {
			if (admin.getEmail().isEmpty()) {
				log.warn("WARN: Email Should not be empty");
				throw new RecordNotFoundException("Admin Email not found");
			}
			adminRepo.save(admin);
			return adminRepo.findAll();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
		}

	}

	@Override
	public AdminEntity logout(AdminEntity admin) throws RecordNotFoundException {
		log.info("Service Layer - Entry - logout");
		Optional<AdminEntity> ad = adminRepo.findById(admin.getEmail());
		try {
			if (admin.getEmail().equals(ad.get().getEmail())) {
				return ad.get();
			} else
				return null;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
		}

	}

	@Override
	public List<AdminEntity> getAllAdmins() throws RecordNotFoundException {
		log.info("Service Layer - Entry - getAllAdmins");
		try {
			return adminRepo.findAll();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
		}

	}

	@Override
	public AdminEntity adminRegister(AdminEntity admin) throws RecordNotFoundException {
		log.info("Service Layer - Entry - adminRegister");
		AdminEntity adminEntity = new AdminEntity();

		if (admin.getEmail().isEmpty() || admin.getName().isEmpty() || admin.getPassword().isEmpty()) {
			log.warn("WARN: Admin details Should not be empty");
			throw new RecordNotFoundException("Admin details should not be null");

		}
		adminEntity = adminRepo.saveAndFlush(admin);
		log.info("Service Layer - Exit - adminRegister");
		return adminEntity;

	}

	@Override
	public AdminEntity showAdminDetailsByEmail(String email) throws RecordNotFoundException {
		log.info("Service Layer - Entry - showAdminDetailsByEmail");
		if (email.equals(null)) {
			log.warn("WARN: Email Should not be empty");
			throw new RecordNotFoundException("Please Enter email");
		}
		Optional<AdminEntity> admin = adminRepo.findById(email);
		if (admin == null) {
			log.warn("WARN: Admin Should not be empty");
			throw new RecordNotFoundException("Admin Email not found");
		}
		return admin.get();

	}

}
