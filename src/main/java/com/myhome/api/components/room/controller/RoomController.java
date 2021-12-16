package com.myhome.api.components.room.controller;

import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.house.dto.HouseDTO;
import com.myhome.api.components.house.repository.IHouseRepository;
import com.myhome.api.components.house.services.mapper.AbstractHouseMapper;
import com.myhome.api.components.room.repository.IRoomRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

	private final IHouseRepository houseRepository;
	private final IAccountRepository accountRepository;
	private final IRoomRepository roomRepository;

	private final AbstractHouseMapper houseMapper;

	public RoomController(IHouseRepository houseRepository, IAccountRepository accountRepository,
			IRoomRepository roomRepository, AbstractHouseMapper houseMapper) {
		this.houseRepository = houseRepository;
		this.accountRepository = accountRepository;
		this.roomRepository = roomRepository;
		this.houseMapper = houseMapper;
	}

	@GetMapping("/getRoom")
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
