package com.myhome.util.impl;

import com.myhome.util.ITokenGenerator;
import com.myhome.util.TokenSaltGenerator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TokenGenerator implements ITokenGenerator {

	public String createNewToken() {
		String uuid = UUID.randomUUID().toString();

		String[] parts = uuid.split("-", 3);

		String specialSecretTokenIngredient =
				TokenSaltGenerator.generateSpecialSecretTokenIngredient();

		String token = String.format("%s%s%s", parts[0], specialSecretTokenIngredient, parts[2]);

		return token.length() == 39 ? token : null;
	}
}
