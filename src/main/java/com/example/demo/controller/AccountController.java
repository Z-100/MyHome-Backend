package com.example.demo.controller;

import com.example.demo.Account;
import com.example.demo.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {


	final StudentRepository sr;

	public AccountController(StudentRepository sr) {
		this.sr = sr;
	}

	@GetMapping("/getAcc")
	public String helloWorld(@RequestHeader("token") String token) {
		return token.equals("s") ? new Account().toString() : "No";
	}

	@GetMapping("/students")
	public Iterable<Account> getAllStudents() {
		return sr.findAll();
	}

	@GetMapping("/students/{id}")
	public Account getAllStudents(@RequestParam("id") Long id) {
		return sr.findById(id).orElseThrow();
	}
}
