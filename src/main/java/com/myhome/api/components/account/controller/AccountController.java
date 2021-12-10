package com.myhome.api.components.account.controller;

import com.myhome.api.components.account.dto.AccountDTO;
import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.account.repository.AccountRepository;
import com.myhome.api.components.account.services.mapper.AccountMapper;
import com.myhome.api.components.account.services.mapper.IAccountMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	private final AccountRepository accountRepository;

	private final IAccountMapper accountMapper = new AccountMapper();

	public AccountController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@GetMapping("/getAcc")
	public AccountDTO helloWorld(@RequestHeader("token") String token) {

		Account account = new Account();
		account.setId(5L);
		account.setEmail("hans@gmail.com");
		account.setPassword("sananas");

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
