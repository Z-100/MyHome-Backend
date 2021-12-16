package com.myhome.api.components.house.controller;

import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.house.dto.HouseDTO;
import com.myhome.api.components.house.entity.House;
import com.myhome.api.components.house.repository.IHouseRepository;
import com.myhome.api.components.house.services.mapper.AbstractHouseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HouseController {

	private final IHouseRepository houseRepository;
	private final IAccountRepository accountRepository;

	private final AbstractHouseMapper houseMapper;

	public HouseController(IHouseRepository houseRepository, IAccountRepository accountRepository, AbstractHouseMapper houseMapper) {
		this.houseRepository = houseRepository;
		this.accountRepository = accountRepository;
		this.houseMapper = houseMapper;
	}

	@GetMapping("/getHouse")
	public HouseDTO helloWorld(@RequestHeader("token") String token) {

//		House house = houseRepository.findByAccount(accountRepository.findByEmail("enim.sed.nulla@yahoo.ca"));
//
//		HouseDTO response = houseMapper.toDTO(house);
//
//		if (token.equals("s"))
//			return response;
		return null;
	}
}
