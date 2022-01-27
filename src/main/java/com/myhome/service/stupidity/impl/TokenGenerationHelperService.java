package com.myhome.service.stupidity.impl;

/**
 * @author z-100
 * Class used to generate a safe "token-password"
 * Some may say this is very unnecessary. And indeed it is.
 * But I was bored, so I did this.
 */
public class TokenGenerationHelperService {

	/**
	 * Please ignore this nonsense
	 * @return Combine the letters of the methods to a word
	 */
	public static String generateSpecialSecretTokenIngredient() {

		byte[] specialSecretTokenIngredientArray = new byte[9];

		specialSecretTokenIngredientArray[0] = HYPHEN();
		specialSecretTokenIngredientArray[1] = B();
		specialSecretTokenIngredientArray[2] = O();
		specialSecretTokenIngredientArray[3] = O();
		specialSecretTokenIngredientArray[4] = B();
		specialSecretTokenIngredientArray[5] = I();
		specialSecretTokenIngredientArray[6] = E();
		specialSecretTokenIngredientArray[7] = S();
		specialSecretTokenIngredientArray[8] = HYPHEN();

		return new String(specialSecretTokenIngredientArray);
	}

	private static byte B() {
		return 0b01000010;
	}

	private static byte O() {
		return 0b01001111;
	}

	private static byte I() {
		return 0b01001001;
	}

	private static byte E() {
		return 0b01000101;
	}

	private static byte S() {
		return 0b01010011;
	}

	private static byte HYPHEN() {
		return 0b00101101;
	}
}
