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
	public AccountDTO helloWorld(@RequestHeader("token") String token) {

		Account account = accountRepository.findByEmail("metus.in.lorem@icloud.couk");

		AccountDTO response = accountMapper.toDTO(account);

		if (token.equals("s"))
			return response;
		return null;
	}

	@GetMapping("/students")
	public Iterable<Account> getAllStudents() {
		return accountRepository.findAll();
	}
}
