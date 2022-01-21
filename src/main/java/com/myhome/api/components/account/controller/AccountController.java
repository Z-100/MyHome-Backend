package com.myhome.api.components.account.controller;

import com.myhome.api.components.account.dto.AccountDTO;
import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.account.services.mapper.AbstractAccountMapper;
import com.myhome.other.exception.InvalidUserInformationException;
import com.myhome.other.exception.SaveToDatabaseException;
import com.myhome.service.generate.UserRegistrationService;
import com.myhome.service.validation.PasswordValidationService;
import com.myhome.service.validation.TokenValidationService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

	private final IAccountRepository accountRepository;
	private final AbstractAccountMapper accountMapper;

	private final PasswordValidationService passwordValidation;
	private final TokenValidationService tokenValidation;
	private final UserRegistrationService userRegistrationService;

	@GetMapping("/getAcc")
	public Account helloWorld(@RequestHeader("account") String token) {

		Account account = accountRepository.findByEmail(token);

		return (account);
	}

	@GetMapping("/login")
	public String login(
			@RequestHeader("email") String email,
			@RequestHeader("password") String password,
			@RequestHeader("token") String token) {

		try {
			if (token.equals("MAHANSH MUTEM blyat suk my dik")) {
				passwordValidation.setRepository(accountRepository);

				return passwordValidation.validate(email, password);
			} else {
				throw new InvalidUserInformationException("Invalid token");
			}
		} catch (InvalidUserInformationException e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/register")
	public String register(
			@RequestHeader("email") String email,
			@RequestHeader("password") String password,
			@RequestHeader("newHouseName") String newHouseName,
			@RequestHeader("defaultMemberName") String defaultMemberName,
			@RequestHeader("token") String token) {

		if (token.equals("ma-ta este super dracu, blyat")) {
			try {
				return userRegistrationService.registerNewUser(email, password, newHouseName, defaultMemberName);
			} catch (SaveToDatabaseException e) {
				return e.getMessage();
			}
		}
		return null;
	}
}
