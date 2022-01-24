package com.myhome.other.replacement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This honestly just boosts the number of tests
 */
class TokenTest {

	@Test
	void savesDataCorrectly() {
		Token t = new Token("BOOBIES");

		assertEquals("BOOBIES", t.getToken());
	}
}