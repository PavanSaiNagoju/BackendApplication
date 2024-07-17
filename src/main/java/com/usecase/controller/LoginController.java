package com.usecase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.entity.AdminEntity;
import com.usecase.entity.ApprovedLoansEntity;
import com.usecase.entity.LoanApplicationEntity;
import com.usecase.entity.UserDetailsEntity;
import com.usecase.entity.UserRegistrationEntity;
import com.usecase.exception.RecordNotFoundException;
import com.usecase.service.LoginServiceImpl;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/homeloan")
public class LoginController {
	@Autowired
	LoginServiceImpl loginService;

	@GetMapping("/userlogin/{userEmail}/{password}")
	public ResponseEntity<Object> verifyUser(@PathVariable("userEmail") String userEmail,
			@PathVariable("password") String password) throws RecordNotFoundException {
		UserRegistrationEntity retUser = loginService.authenticateUser(userEmail, password);

		EntityModel<UserRegistrationEntity> resource = EntityModel.of(retUser);
		resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRegistrationController.class)
				.passwordReset(new UserRegistrationEntity())).withRel("change the password"));
		resource.add(WebMvcLinkBuilder.linkTo(
				WebMvcLinkBuilder.methodOn(UserRegistrationController.class).showUserRegistrationInformation(""))
				.withRel("view Registration details"));
		resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserDetailsController.class).findUser(0))
				.withRel("view user details"));
		resource.add(WebMvcLinkBuilder.linkTo(
				WebMvcLinkBuilder.methodOn(UserDetailsController.class).addUserDetails(" ", new UserDetailsEntity()))
				.withRel("insert the user details"));
		resource.add(WebMvcLinkBuilder.linkTo(
				WebMvcLinkBuilder.methodOn(LoanApplicationController.class).applyLoan(new LoanApplicationEntity(), 0))
				.withRel("apply for the loan"));
		return new ResponseEntity<Object>(resource, HttpStatus.OK);
	}

	@GetMapping("/adminlogin/{adminEmail}/{password}")
	public ResponseEntity<Object> adminVerfication(@PathVariable("adminEmail") String adminEmail,
			@PathVariable("password") String password) throws RecordNotFoundException {
		AdminEntity admin = loginService.authenticateAdmin(adminEmail, password);// Log.info("admin sign in");
		EntityModel<AdminEntity> resource = EntityModel.of(admin);
		resource.add(
				WebMvcLinkBuilder
						.linkTo(WebMvcLinkBuilder.methodOn(LoanApplicationController.class)
								.updateLoanApplication(new LoanApplicationEntity()))
						.withRel("update the loan application"));
		resource.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(LoanApplicationController.class).getAllPendingLoans(adminEmail))
				.withRel("view all pending loans"));
		resource.add(WebMvcLinkBuilder.linkTo(
				WebMvcLinkBuilder.methodOn(ApprovedLoanController.class).addApprovedLoan(new ApprovedLoansEntity()))
				.withRel("approve an account"));
		/*
		 * resource.add(WebMvcLinkBuilder
		 * .linkTo(WebMvcLinkBuilder.methodOn(LoanApplicationController.class).
		 * getAllApprovedLoans(email)) .withRel("view all accepted loans"));
		 */
		resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserDetailsController.class).findUser(0))
				.withRel("view user details by Id"));
		resource.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(ApprovedLoanController.class).showAllApprovedByEmail(""))
				.withRel("view all approved loans by email"));
		resource.add(
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRegistrationController.class).getAllUsers())
						.withRel("view all registerd users"));
		resource.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(ApprovedLoanController.class).showApprovedByLoanId(0))
				.withRel("view approved loan by id"));
		resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ApprovedLoanController.class).getAllProducts())
				.withRel("view all accounts"));
		resource.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(AdminController.class).updateAdmin(new AdminEntity()))
				.withRel("update the admin detailsgfhj"));
		return new ResponseEntity<Object>(resource, HttpStatus.OK);
	}

}
