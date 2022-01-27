package com.myhome.service.generate;

import com.myhome.other.exception.TokenGenerationException;
import com.myhome.service.generate.impl.TokenGenerationService;
import com.myhome.service.stupidity.impl.TokenGenerationHelperService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenGenerationServiceTest {

	TokenGenerationService tgs = new TokenGenerationService();
	String newToken = tgs.createNewToken();

	TokenGenerationServiceTest() throws TokenGenerationException {
	}

	@Test
	void tokenHasTheCorrectLength() {
		assertEquals(newToken.length(), 39);
	}

	@Test
	void tokenHasTheCorrectSpecialTokenIngredient() {
		assertTrue(newToken.contains(TokenGenerationHelperService
				.generateSpecialSecretTokenIngredient()));
	}
}