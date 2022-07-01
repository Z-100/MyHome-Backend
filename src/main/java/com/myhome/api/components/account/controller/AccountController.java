package com.myhome.api.components.account.controller;

import com.myhome.api.components.account.services.crud.impl.AccountService;
import com.myhome.other.Constants;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author z-100
 * Class used to communicate between API and backend
 */
@RestController
@AllArgsConstructor
@RequestMapping(Constants.API.URL_ACCOUNT)
public class AccountController {

	private final AccountService accountService;

	private ResponseEntity<?> response;

	@PostMapping(Constants.API.CRUD.URL_LOGIN)
	public ResponseEntity<?> login(
			@RequestHeader("email") String email,
			@RequestHeader("password") String password) {

		return accountService.login(email, password);
	}

/*	@PostMapping(value = Constants.API.CRUD.URL_REGISTER)
	public ResponseEntity<?> register(
			@RequestHeader("email") String email,
			@RequestHeader("password") String password,
			@RequestHeader("new-house-name") String newHouseName,
			@RequestHeader("default-member-name") String defaultMemberName,
			@RequestHeader("token") String token) {

		return null;
	}

	@GetMapping(Constants.API.CRUD.URL_GET)
	public ResponseEntity<?> getAccount(
			@RequestHeader("email") String email,
			@RequestHeader("token") String token) {

		return null;
	}

	@GetMapping(Constants.API.CRUD.URL_UPDATE)
	public ResponseEntity<?> updateAccount(
			@RequestHeader("email") String email,
			@RequestHeader("token") String token,
			@RequestHeader("new-email") String newEmail,
			@RequestHeader("new-password") String newPassword) {

		return null;
	}

	@GetMapping(Constants.API.CRUD.URL_DELETE)
	public ResponseEntity<?> deleteAccount(
			@RequestHeader("email") String email,
			@RequestHeader("token") String token) {

		return null;
	}*/
}

