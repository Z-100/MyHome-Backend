package com.myhome.api.components.meal.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MealDTO {

	private Long id;

	private Date meal_date;

	private String type;
}
