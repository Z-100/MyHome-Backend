package com.myhome.api.components.meal.services.mapper;

import com.myhome.api.components.meal.dto.MealDTO;
import com.myhome.api.components.meal.entity.Meal;
import org.mapstruct.Mapper;

@Mapper(implementationName = "MealMapper",
		componentModel = "spring")
public abstract class AbstractMealMapper {

	abstract public MealDTO toDTO(Meal entity);

	abstract public Meal toEntity(MealDTO dto);
}
