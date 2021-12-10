package com.myhome.api.components.house.controller;

import com.myhome.api.components.house.dto.HouseDTO;
import com.myhome.api.components.house.entity.House;
import com.myhome.api.components.house.repository.IHouseRepository;
import com.myhome.api.components.house.services.mapper.AbstractHouseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HouseController {

	private final IHouseRepository accountRepository;

	private final AbstractHouseMapper houseMapper;

	public HouseController(IHouseRepository accountRepository, AbstractHouseMapper houseMapper) {
		this.accountRepository = accountRepository;
		this.houseMapper = houseMapper;
	}

	@GetMapping("/getAcc")
	public HouseDTO helloWorld(@RequestHeader("token") String token) {

		House house = accountRepository.findByName("enim.sed.nulla@yahoo.ca");

		HouseDTO response = houseMapper.toDTO(house);

		if (token.equals("s"))
			return response;
		return null;
	}

	@GetMapping("/students")
	public Iterable<House> getAllStudents() {
		return accountRepository.findAll();
	}
}
