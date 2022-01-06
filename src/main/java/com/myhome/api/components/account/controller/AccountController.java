package com.myhome.api.components.account.controller;

import com.myhome.api.components.account.dto.AccountDTO;
import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.account.services.mapper.AbstractAccountMapper;
import com.myhome.other.exception.InvalidUserInformationException;
import com.myhome.service.validation.AccountPasswordValidationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	private final IAccountRepository accountRepository;

	private final AbstractAccountMapper accountMapper;

	private final AccountPasswordValidationService validationService;

	public AccountController(IAccountRepository accountRepository, AbstractAccountMapper accountMapper,
			AccountPasswordValidationService validationService) {

		this.accountRepository = accountRepository;
		this.accountMapper = accountMapper;
		this.validationService = validationService;
	}

	@GetMapping("/getAcc")
	public AccountDTO helloWorld(@RequestHeader("account") String token) {

		Account account = accountRepository.findByEmail(token);

		return accountMapper.toDTO(account);
	}

	@GetMapping("/login")
	public AccountDTO testPw(
			@RequestHeader("email") String email,
			@RequestHeader("password") String password,
			@RequestHeader("token") String token) {

		try {
			if (token.equals("temp")) {
				validationService.setRepository(accountRepository);
				return validationService.validate(email, password);
			} else {
				throw new InvalidUserInformationException("Invalid token");
			}
		} catch (InvalidUserInformationException e) {
			e.printStackTrace();
			return null;
		}
	}
}
