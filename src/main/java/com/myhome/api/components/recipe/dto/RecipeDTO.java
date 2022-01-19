package com.myhome.api.components.recipe.dto;

import com.myhome.api.components.house.entity.House;
import com.myhome.api.components.member.entity.Member;
import lombok.Data;

import java.util.Set;

@Data
public class RecipeDTO {

	private Long id;

	private String name;

	private Integer forAmountOfPeople;

}
