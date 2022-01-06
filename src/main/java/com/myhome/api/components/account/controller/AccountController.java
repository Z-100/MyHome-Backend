package com.myhome.api.components.account.controller;

import com.myhome.api.components.account.dto.AccountDTO;
import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.account.services.mapper.AbstractAccountMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	private final IAccountRepository accountRepository;

	private final AbstractAccountMapper accountMapper;

	public AccountController(IAccountRepository accountRepository, AbstractAccountMapper accountMapper) {
		this.accountRepository = accountRepository;
		this.accountMapper = accountMapper;
	}

	@GetMapping("/getAcc")
	public Account helloWorld(@RequestHeader("account") String token) {

		Account account = accountRepository.findByEmail(token);

		return (account);
	}

	@GetMapping("/students")
	public Iterable<Account> getAllStudents() {
		return accountRepository.findAll();
	}
}
