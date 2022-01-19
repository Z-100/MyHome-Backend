package com.myhome.api.components.recipe.repository;

import com.myhome.api.components.recipe.entity.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecipeRepository extends CrudRepository<Recipe, Long> {

}