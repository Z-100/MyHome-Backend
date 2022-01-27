package com.myhome.service.validation.impl;

import com.myhome.api.components.account.repository.IAccountRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author z-100
 * Class used to validate a given token
 */
@Component
public class TokenValidationService {

	private final IAccountRepository repository;

	public TokenValidationService(IAccountRepository repository) {
		this.repository = repository;
	}

	/**
	 * Method used to check if the given token is the same
	 * as the token from the database, used by the user
	 *
	 * @param email The users email address
	 * @param token The token given with the request
	 * @return True if valid
	 */
	public boolean validate(String email, String token) {
		String tokenFromDB = repository.findByEmail(email).getToken();

		return Objects.equals(tokenFromDB, token);
	}
}
