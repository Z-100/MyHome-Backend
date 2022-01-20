package com.myhome.service.validation;

import com.myhome.api.components.account.dto.AccountDTO;
import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.account.services.mapper.AbstractAccountMapper;
import com.myhome.api.components.account.services.mapper.AccountMapper;
import com.myhome.other.exception.InvalidUserInformationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author z-100
 * Class used to validate a password
 */
@Data
@Component
public class PasswordValidationService {

	private IAccountRepository repository;

	private AbstractAccountMapper mapper;

	public PasswordValidationService(IAccountRepository repository) {
		this.repository = repository;
		this.mapper = new AccountMapper();
	}

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
