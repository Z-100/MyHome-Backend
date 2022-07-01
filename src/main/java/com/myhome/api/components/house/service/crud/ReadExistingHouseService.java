package com.myhome.api.components.house.service.crud;

import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.house.dto.HouseDTO;
import com.myhome.api.components.house.service.mapper.AbstractHouseMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author z-100
 * Class used to communicate between database and API
 */
@AllArgsConstructor
@Component
public class ReadExistingHouseService {

	private final IAccountRepository accountRepository;
	private final AbstractHouseMapper houseMapper;

	/**
	 * Method used to get house from database
	 *
	 * @param email The accounts email
	 * @return The Houses
	 */
	public List<HouseDTO> getHouses(String email) {
		List<HouseDTO> houseDTOs = new ArrayList<>();

		accountRepository.findByEmail(email).getHouses().forEach(house -> {
			houseDTOs.add(houseMapper.toDTO(house));
		});
		return houseDTOs;
	}
}
