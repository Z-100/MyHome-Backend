package com.myhome.service.validation.impl;

import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.other.Constants;
import com.myhome.service.Validator;
import com.myhome.service.validation.IValidationService;
import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @author z-100
 * Class used to validate a password
 */
@Getter
@Setter
@Component
@AllArgsConstructor
public class ValidationService implements IValidationService {

	private IAccountRepository accountRepository;

	@Override
	public Boolean validateLogin(String email, String password) {

		return accountRepository.findByEmailAndPassword(email, password).isPresent();
	}

	public Boolean validateToken(String email, String token) {

		return accountRepository.findByEmailAndToken(email, token).isPresent();
	}
}
