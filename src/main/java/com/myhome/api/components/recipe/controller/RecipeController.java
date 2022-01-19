package com.myhome.api.components.recipe.controller;

import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.house.repository.IHouseRepository;
import com.myhome.api.components.member.dto.MemberDTO;
import com.myhome.api.components.member.repository.IMemberRepository;
import com.myhome.api.components.member.services.mapper.AbstractMemberMapper;
import com.myhome.api.components.rating.repository.IRatingRepository;
import com.myhome.api.components.recipe.dto.RecipeDTO;
import com.myhome.api.components.recipe.mapper.AbstractRecipeMapper;
import com.myhome.api.components.recipe.repository.IRecipeRepository;
import com.myhome.service.validation.TokenValidationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recipe")
@AllArgsConstructor
public class RecipeController {

	private final IRecipeRepository recipeRepository;
	private final IHouseRepository houseRepository;
	private final IAccountRepository accountRepository;
	private final IRatingRepository ratingRepository;
	private final AbstractRecipeMapper recipeMapper;

	private final TokenValidationService tokenValidation;

	/**
	 * Method used to get all members from database (only members)
	 *
	 * @param email The accounts email (validation and account)
	 * @param token The accounts specific token to validate the request
	 * @return Iterable of all members belonging to said account
	 */
	@GetMapping("/get-recipes")
	public List<RecipeDTO> getSpecificRecipes(
			@RequestHeader("email") String email,
			@RequestHeader("token") String token) {

			if (tokenValidation.validate(email, token)) {
				List<RecipeDTO> recipeDTOs = new ArrayList<>();

				recipeRepository.findRecipesByFkHouseId(
						houseRepository.findHouseByFkAccountId(
								accountRepository.findByEmail(email).getId()))
						.forEach(recipe -> recipeDTOs
								.add(recipeMapper.toDTO(recipe)));

				return recipeDTOs;
			}
			return null;
	}

	@GetMapping("/get-recipe{rating}")
	public List<RecipeDTO> getRecipeWithRating(@PathVariable String rating) {
		return null;
	}
}
