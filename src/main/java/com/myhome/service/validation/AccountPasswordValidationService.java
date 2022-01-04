package com.myhome.service.validation;

import com.myhome.api.components.account.dto.AccountDTO;
import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.account.services.mapper.AbstractAccountMapper;
import com.myhome.api.components.account.services.mapper.AccountMapper;
import com.myhome.other.exception.InvalidUserInformationException;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author z-100
 * Class used to validate a password
 */
public class AccountPasswordValidationService {

	private final IAccountRepository repository;

	private final AbstractAccountMapper mapper;

	public AccountPasswordValidationService(IAccountRepository repository) {
		this.repository = repository;
		this.mapper = new AccountMapper();
	}

	/**
	 * Method used to check if entered data matches an Account from the repository
	 *
	 * @param email input of the users email
	 * @param password input of the users password
	 *
	 * @return the matched account as a DTO
	 */
	public AccountDTO validate(String email, String password) throws InvalidUserInformationException {

		List<Account> collect = repository.stream()
				.filter(acc -> email.equals(acc.getEmail()))
				.filter(acc -> password.equals(acc.getPassword()))
				.collect(Collectors.toList());

		return collect.size() > 0 ?
				mapper.toDTO(collect.get(0)) : null;
	}
}
