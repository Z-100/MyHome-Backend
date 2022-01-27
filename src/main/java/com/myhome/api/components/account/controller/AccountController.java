package com.myhome.api.components.account.controller;

import com.myhome.api.components.account.dto.AccountDTO;
import com.myhome.api.services.crud.account.DeleteExistingAccountService;
import com.myhome.api.services.crud.account.ReadExistingAccountService;
import com.myhome.api.services.crud.account.UpdateExistingAccountService;
import com.myhome.other.Strings;
import com.myhome.other.exception.InvalidUserInformationException;
import com.myhome.other.exception.SaveToDatabaseException;
import com.myhome.other.replacement.JsonBoolean;
import com.myhome.other.replacement.Token;
import com.myhome.api.services.crud.account.UserRegistrationService;
import com.myhome.service.validation.IPasswordValidationService;

import com.myhome.service.validation.ITokenValidationService;
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

	private final IPasswordValidationService passwordValidation;
	private final ITokenValidationService tokenValidation;

	private final UserRegistrationService userRegistrationService;
	private final ReadExistingAccountService readAccount;
	private final UpdateExistingAccountService updateAccount;
	private final DeleteExistingAccountService deleteAccount;

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
				throw new InvalidUserInformationException(Strings.INVALID_TOKEN);
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
			@RequestHeader("new-house-name") String newHouseName,
			@RequestHeader("default-member-name") String defaultMemberName,
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

	/**
	 * Method used to gather information of an account
	 *
	 * @param email The accounts email
	 * @param token The accounts token
	 * @return The accounts information
	 */
	@GetMapping("/get-account")
	public AccountDTO getAccount(
			@RequestHeader("email") String email,
			@RequestHeader("token") String token) {

		return tokenValidation.validate(email, token) ? readAccount.getAccount(email) : null;
	}

	/**
	 * Method used to update existing account
	 *
	 * @param email The accounts (old) email
	 * @param token The accounts token
	 * @param newEmail The accounts new email
	 * @param newPassword The accounts new password
	 * @return true on success
	 */
	@GetMapping("update-account")
	public JsonBoolean updateAccount(
			@RequestHeader("email") String email,
			@RequestHeader("token") String token,
			@RequestHeader("new-email") String newEmail,
			@RequestHeader("new-password") String newPassword) {

		return tokenValidation.validate(email, token) ? new JsonBoolean(updateAccount.update(email, newEmail, newPassword)) : new JsonBoolean(false);
	}

	/**
	 * Method used to delete existing account
	 *
	 * @param email The accounts email
	 * @param token The accounts token
	 * @return True on success
	 */
	@GetMapping("delete-account")
	public JsonBoolean deleteAccount(
			@RequestHeader("email") String email,
			@RequestHeader("token") String token) {

		return tokenValidation.validate(email, token) ? new JsonBoolean(deleteAccount.delete(email)) : new JsonBoolean(false);
	}
}
