package com.myhome.api.components.account.controller;

import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.other.exception.InvalidUserInformationException;
import com.myhome.other.exception.SaveToDatabaseException;
import com.myhome.other.replacement.Token;
import com.myhome.api.services.crud.account.UserRegistrationService;
import com.myhome.service.validation.IPasswordValidationService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author z-100
 * Class used to communicate between API and backend
 */
@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

	private final IAccountRepository accountRepository;

	private final IPasswordValidationService passwordValidation;
	private final UserRegistrationService userRegistrationService;

	/**
	 * Method used to send login information to backend
	 *
	 * @param email The accounts email
	 * @param password The accounts password
	 * @param token The hardcoded token
	 * @return The generated token
	 */
	@GetMapping("/login")
	public Token login(
			@RequestHeader("email") String email,
			@RequestHeader("password") String password,
			@RequestHeader("token") String token) {

		try {
			if (token.equals("MAHANSH MUTEM blyat suk my dik")) {
				return new Token(passwordValidation.validate(email, password));
			} else {
				throw new InvalidUserInformationException("Invalid token");
			}
		} catch (InvalidUserInformationException e) {
			e.printStackTrace();
			return new Token(e.getMessage());
		}
	}

	/**
	 * Method used to send register information to the register service
	 *
	 * @param email The to be registered accounts email
	 * @param password The to be registered accounts password
	 * @param newHouseName The to be registered accounts house name
	 * @param defaultMemberName The to be registered accounts member name
	 * @param token The hardcoded token
	 * @return The generated token on success
	 */
	@GetMapping("/register")
	public Token register(
			@RequestHeader("email") String email,
			@RequestHeader("password") String password,
			@RequestHeader("newHouseName") String newHouseName,
			@RequestHeader("defaultMemberName") String defaultMemberName,
			@RequestHeader("token") String token) {

		if (token.equals("ma-ta este super dracu, blyat")) {
			try {
				return new Token(userRegistrationService.registerNewUser(email, password, newHouseName, defaultMemberName));
			} catch (SaveToDatabaseException e) {
				return new Token(e.getMessage());
			}
		}
		return null;
	}
}
