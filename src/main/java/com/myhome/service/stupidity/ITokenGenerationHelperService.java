package com.myhome.service.stupidity;

public interface ITokenGenerationHelperService {

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
