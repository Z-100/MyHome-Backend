package com.myhome.api.components.meal.controller;

import com.myhome.api.components.meal.dto.MealDTO;
import com.myhome.api.components.meal.services.mapper.AbstractMealMapper;
import com.myhome.api.components.meal.repository.IMealRepository;
import com.myhome.api.components.member.repository.IMemberRepository;
import com.myhome.service.validation.ITokenValidationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/meal")
@AllArgsConstructor
public class MealController {

	private final IMealRepository mealRepository;
	private final IMemberRepository memberRepository;
	private final AbstractMealMapper mealMapper;

	private final ITokenValidationService tokenValidation;

	/**
	 * Method used to get all meals from a specific member
	 *
	 * @param memberId The id of the member
	 * @param email The accounts email (validation and account)
	 * @param token The accounts specific token to validate the request
	 * @return Iterable of all meals belonging to said meal
	 */
	@GetMapping("/get-meal")
	public Iterable<MealDTO> helloWorld(
			@RequestHeader("memberid") String memberId,
			@RequestHeader("email") String email,
			@RequestHeader("token") String token) {

		if (tokenValidation.validate(email, token)) {
			List<MealDTO> mealDTOs = new ArrayList<>();

			Long memberIdL = Long.parseLong(memberId);

			mealRepository.findByFkMemberId(memberRepository.findById(memberIdL).get())
					.forEach(meal -> {
						mealDTOs.add(
								mealMapper.toDTO(meal));
					});

			return mealDTOs;
		}
		return null;
	}
}
