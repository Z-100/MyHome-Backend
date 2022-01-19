package com.myhome.api.components.recipe.mapper;

import com.myhome.api.components.recipe.dto.RecipeDTO;
import com.myhome.api.components.recipe.entity.Recipe;
import org.mapstruct.Mapper;

@Mapper(implementationName = "RecipeMapper",
		componentModel = "spring")
public abstract class AbstractRecipeMapper {

	abstract RecipeDTO toDTO(Recipe entity);

	abstract Recipe toEntity(RecipeDTO dto);
}
