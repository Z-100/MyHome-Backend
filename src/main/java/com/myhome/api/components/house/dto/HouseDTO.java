package com.myhome.api.components.house.dto;

import lombok.Data;

@Data
public class HouseDTO {

	private Long id;

	private String name;

	private Long fk_accountId;
}
