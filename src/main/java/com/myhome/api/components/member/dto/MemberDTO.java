package com.myhome.api.components.member.dto;

import com.myhome.api.components.meal.entity.Meal;
import lombok.Data;

import java.util.Set;

@Data
public class MemberDTO {

	private Long id;

	private String name;

	private Integer icon;

	private Set<Meal> meals;
}
