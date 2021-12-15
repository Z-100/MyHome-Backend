package com.myhome.api.components.account.dto;

import com.myhome.api.components.house.entity.House;
import lombok.Data;

import java.util.List;

@Data
public class AccountDTO {

	private Long id;

	private String email;

	private List<House> houseList;
}
