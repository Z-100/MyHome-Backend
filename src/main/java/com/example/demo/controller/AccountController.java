package com.example.demo.controller;

import com.example.demo.Account;
import com.example.demo.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {


	final AccountRepository accountRepository;

	public AccountController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@GetMapping("/getAcc")
	public Account helloWorld(@RequestHeader("token") String token) {
		Account response = new Account(5L, "Hans", "Peter");
		if (token.equals("s"))
			return response; // ! Important note: Always return the dto / entity
		return null;
	}

	@GetMapping("/students")
	public Iterable<Account> getAllStudents() {
		return accountRepository.findAll();
	}
}
