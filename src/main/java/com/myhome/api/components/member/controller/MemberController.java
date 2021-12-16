package com.myhome.api.components.member.controller;

import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.member.dto.MemberDTO;
import com.myhome.api.components.member.services.mapper.AbstractMemberMapper;
import com.myhome.api.components.member.repository.IMemberRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

	private final IMemberRepository houseRepository;
	private final IAccountRepository accountRepository;

	private final AbstractMemberMapper houseMapper;

	public MemberController(
			IMemberRepository houseRepository, IAccountRepository accountRepository, AbstractMemberMapper houseMapper) {
		this.houseRepository = houseRepository;
		this.accountRepository = accountRepository;
		this.houseMapper = houseMapper;
	}

	@GetMapping("/getMember")
	public MemberDTO helloWorld(@RequestHeader("token") String token) {

//		House house = houseRepository.findByAccount(accountRepository.findByEmail("enim.sed.nulla@yahoo.ca"));
//
//		HouseDTO response = houseMapper.toDTO(house);
//
//		if (token.equals("s"))
//			return response;
		return null;
	}
}
