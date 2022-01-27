package com.myhome.api.components.recipe.services.mapper;

import com.myhome.api.components.recipe.dto.RecipeDTO;
import com.myhome.api.components.recipe.entity.Recipe;
import org.mapstruct.Mapper;

@Mapper(implementationName = "RecipeMapper",
		componentModel = "spring")
public abstract class AbstractRecipeMapper {

	public abstract RecipeDTO toDTO(Recipe entity);

	public abstract Recipe toEntity(RecipeDTO dto);
}
