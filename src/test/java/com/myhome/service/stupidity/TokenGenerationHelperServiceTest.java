package com.myhome.service.stupidity;

import com.myhome.service.stupidity.impl.TokenGenerationHelperService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenGenerationHelperServiceTest {

	@Test
	void generateSpecialSecretTokenIngredient() {
		assertTrue(TokenGenerationHelperService.generateSpecialSecretTokenIngredient().contains("BOOBIES"));
	}
}