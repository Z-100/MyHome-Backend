package com.myhome.service.stupidity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenGenerationHelperServiceTest {

	@Test
	void generateSpecialSecretTokenIngredient() {
		assertTrue(TokenGenerationHelperService.generateSpecialSecretTokenIngredient().contains("BOOBIES"));
	}
}