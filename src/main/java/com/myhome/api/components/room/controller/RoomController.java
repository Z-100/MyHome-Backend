package com.myhome.api.components.room.controller;

import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.house.repository.IHouseRepository;
import com.myhome.api.components.item.mapper.AbstractItemMapper;
import com.myhome.api.components.room.dto.RoomDTO;
import com.myhome.api.components.room.repository.IItemRepository;
import com.myhome.api.components.room.services.mapper.AbstractRoomMapper;
import com.myhome.service.validation.TokenValidationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author z-100
 */
@RestController
@RequestMapping("/room")
@AllArgsConstructor
public class RoomController {

	private final IHouseRepository houseRepository;
	private final IAccountRepository accountRepository;
	private final IItemRepository roomRepository;

	private final AbstractRoomMapper roomMapper;


	private final TokenValidationService tokenValidation;

	/**
	 * Method used to gather all rooms belonging to an account
	 *
	 * @param email The accounts email
	 * @param token The accounts validator token
	 * @return All rooms belonging to an account
	 */
	@GetMapping("/get-all-rooms")
	public List<RoomDTO> getAllRooms(
			@RequestHeader("email") String email,
			@RequestHeader("token") String token) {

		if (tokenValidation.validate(email, token)) {
			List<RoomDTO> rooms = new ArrayList<>();

			houseRepository.findHouseByFkAccountId(
					accountRepository.findByEmail(email)).getRooms()
					.forEach(room -> rooms.add(roomMapper.toDTO(room)));

			return rooms;
		}
		return null;
	}
}
