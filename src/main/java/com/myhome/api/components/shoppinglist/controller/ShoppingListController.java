package com.myhome.api.components.shoppinglist.controller;

import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.house.repository.IHouseRepository;
import com.myhome.api.components.shoppinglist.entity.ShoppingList;
import com.myhome.api.components.shoppinglist.services.mapper.AbstractShoppingListMapper;
import com.myhome.api.components.shoppinglist.repository.IShoppingListRepository;
import com.myhome.service.validation.ITokenValidationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-list")
@AllArgsConstructor
public class ShoppingListController {

	private final IHouseRepository houseRepository;
	private final IAccountRepository accountRepository;
	private final IShoppingListRepository roomRepository;
	private final AbstractShoppingListMapper shoppinglistMapper;

	private final ITokenValidationService tokenValidation;

	@GetMapping("get-shopping-list")
	public ShoppingList showShoppingList(
			@RequestHeader("email") String email,
			@RequestHeader("token") String token) {

		if (tokenValidation.validate(email, token)) {
			return houseRepository.findHouseByFkAccountId(
					accountRepository.findByEmail(email)).getShoppinglist();
		}
		return null;
	}
}
