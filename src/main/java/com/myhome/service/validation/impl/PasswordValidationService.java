package com.myhome.service.validation.impl;

import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.account.services.mapper.AbstractAccountMapper;
import com.myhome.other.exception.InvalidUserInformationException;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author z-100
 * Class used to validate a password
 */
@Getter
@Setter
@Component
@AllArgsConstructor
public class PasswordValidationService {

	private IAccountRepository repository;

	private AbstractAccountMapper mapper;

	/**
	 * Method used to check if entered data matches an Account from the repository
	 *
	 * @param email input of the users email
	 * @param password input of the users password
	 * @return the matched account as a DTO
	 */
	public String validate(String email, String password) throws InvalidUserInformationException {

		List<Account> collect;

		try (Stream<Account> result = StreamSupport
				.stream(repository.findAll().spliterator(), false)) {

			collect = result
				.filter(acc -> email.equals(acc.getEmail()))
				.filter(acc -> password.equals(acc.getPassword()))
				.collect(Collectors.toList());
		}

		return collect.size() > 0 ? repository.findByEmail(email).getToken() : null;
	}
}
