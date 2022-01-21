package com.myhome.other.exception;

public class SaveToDatabaseException extends Exception {

	/**
	 * The exception thrown when the password entered is wrong
	 *
	 * @param s The information for debugging and the user
	 */
	public SaveToDatabaseException(String s) {
		super(s);
	}
}
