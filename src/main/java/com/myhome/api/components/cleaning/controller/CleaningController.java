package com.myhome.api.components.cleaning.controller;

import com.myhome.api.components.cleaning.dto.CleaningDTO;
import com.myhome.api.components.cleaning.entity.Cleaning;
import com.myhome.api.components.cleaning.repository.ICleaningRepository;
import com.myhome.api.components.cleaning.services.mapper.AbstractCleaningMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CleaningController {

	private final ICleaningRepository accountRepository;

	private final AbstractCleaningMapper accountMapper;

	public CleaningController(ICleaningRepository accountRepository, AbstractCleaningMapper accountMapper) {
		this.accountRepository = accountRepository;
		this.accountMapper = accountMapper;
	}

	@GetMapping("/getCleaning")
	public CleaningDTO helloWorld(@RequestHeader("token") String token) {

		Cleaning cleaning = accountRepository.findByCleaningTime("2021-02-02");

		CleaningDTO response = accountMapper.toDTO(cleaning);

		if (token.equals("s"))
			return response;
		return null;
	}

	@GetMapping("/students")
	public Iterable<Cleaning> getAllStudents() {
		return accountRepository.findAll();
	}
}
