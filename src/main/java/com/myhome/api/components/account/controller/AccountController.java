package com.myhome.api.components.account.controller;

import com.myhome.api.components.account.dto.AccountDTO;
import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.account.services.mapper.AbstractAccountMapper;
import com.myhome.other.exception.InvalidUserInformationException;
import com.myhome.service.generate.UserRegistrationService;
import com.myhome.service.validation.PasswordValidationService;
import com.myhome.service.validation.TokenValidationService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	private final IAccountRepository accountRepository;

	private final AbstractAccountMapper accountMapper;

	private final PasswordValidationService passwordValidation;

	private final TokenValidationService tokenValidation;

	private final UserRegistrationService userRegistrationService;

	public AccountController(IAccountRepository accountRepository, AbstractAccountMapper accountMapper,
			PasswordValidationService passwordValidation, TokenValidationService tokenValidation,
			UserRegistrationService userRegistrationService) {

		this.accountRepository = accountRepository;
		this.accountMapper = accountMapper;
		this.passwordValidation = passwordValidation;
		this.tokenValidation = tokenValidation;
		this.userRegistrationService = userRegistrationService;
	}

	@GetMapping("/getAcc")
	public AccountDTO helloWorld(@RequestHeader("account") String token) {

		Account account = accountRepository.findByEmail(token);

		return accountMapper.toDTO(account);
	}

	@GetMapping("/login")
	public AccountDTO login(
			@RequestHeader("email") String email,
			@RequestHeader("password") String password,
			@RequestHeader("token") String token) {

		try {
			if (tokenValidation.validate(email, token)) {
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
			@RequestHeader("token") String token) {

		if (token.equals("69"))
			return userRegistrationService.registerNewUser(email, password, newHouseName);
		else
			return null;
	}
}
