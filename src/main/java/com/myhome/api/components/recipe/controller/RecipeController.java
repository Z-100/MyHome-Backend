package com.myhome.api.components.recipe.controller;

import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.house.repository.IHouseRepository;
import com.myhome.api.components.member.repository.IMemberRepository;
import com.myhome.api.components.rating.repository.IRatingRepository;
import com.myhome.api.components.recipe.dto.RecipeDTO;
import com.myhome.api.components.recipe.services.mapper.AbstractRecipeMapper;
import com.myhome.api.components.recipe.repository.IRecipeRepository;
import com.myhome.service.validation.impl.TokenValidationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author z-100
 * Class used to controll the datahandling of the recipe
 */
@RestController
@RequestMapping("/recipe")
@AllArgsConstructor
public class RecipeController {

	private final IRecipeRepository recipeRepository;
	private final IHouseRepository houseRepository;
	private final IAccountRepository accountRepository;
	private final IRatingRepository ratingRepository;
	private final IMemberRepository memberRepository;
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
	public List<RecipeDTO> getAllRecipes(
			@RequestHeader("email") String email,
			@RequestHeader("token") String token) {

			if (tokenValidation.validate(email, token)) {
				List<RecipeDTO> recipeDTOs = new ArrayList<>();

				houseRepository.findHouseByFkAccountId(
						accountRepository.findByEmail(email)).getRecipes().forEach(recipe ->
						recipeDTOs.add(recipeMapper.toDTO(recipe)));

				return recipeDTOs;
			}
			return null;
	}

	/**
	 * Filter for recipes with a rating above <i>getRating<i/>
	 *
	 * @param getRating The rating (1-5)
	 * @param email The email belonging to an account
	 * @param token The token used for validation
	 * @return A List with all recipes fulfilling the rating-filter
	 */
	@GetMapping("/get-recipe")
	public List<RecipeDTO> getRecipeWithRating(
			@RequestHeader("get-rating") String getRating,
			@RequestHeader("email") String email,
			@RequestHeader("token") String token) {

		if (tokenValidation.validate(email, token)) {
			AtomicInteger atomicRating = new AtomicInteger();
			atomicRating.set(Integer.parseInt(getRating));

			List<RecipeDTO> recipeDTOs = new ArrayList<>();

			memberRepository.findByFkAccountId(accountRepository.findByEmail(email)).forEach(member -> {
				ratingRepository.findByFkMemberId(member).forEach(rating -> {
					if (rating.getRating() >= atomicRating.get()) {
						recipeDTOs.add(recipeMapper.toDTO(
								recipeRepository.findRecipeById(
										rating.getFkRecipeId().getId())));
					}
				});
			});
			return recipeDTOs;
		}
		return null;
	}
}
