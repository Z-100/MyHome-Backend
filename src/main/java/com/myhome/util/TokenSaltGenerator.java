package com.myhome.util;

public class TokenSaltGenerator {

	/**
	 * Please ignore this nonsense
	 * @return Combine the letters of the methods to a word
	 */
	public static String generateSpecialSecretTokenIngredient() {

		return new String( new byte[] {
				CHAR_6(), CHAR_1(), CHAR_2(), CHAR_2(), CHAR_1(),
				CHAR_3(), CHAR_4(), CHAR_5(), CHAR_6(),
		});
	}

	private static byte CHAR_1() {
		return 0b01000010;
	}

	private static byte CHAR_2() {
		return 0b01001111;
	}

	private static byte CHAR_3() {
		return 0b01001001;
	}

	private static byte CHAR_4() {
		return 0b01000101;
	}

	private static byte CHAR_5() {
		return 0b01010011;
	}

	private static byte CHAR_6() {
		return 0b00101101;
	}
}
