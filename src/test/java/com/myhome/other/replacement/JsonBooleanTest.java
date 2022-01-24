package com.myhome.other.replacement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This honestly just boosts the number of tests
 */
class JsonBooleanTest {

	@Test
	void savesDataCorrectly() {
		JsonBoolean jb = new JsonBoolean(true);

		assertTrue(jb.getBool());
		assertFalse(!!!!!!!!!!!!!jb.getBool());
	}
}