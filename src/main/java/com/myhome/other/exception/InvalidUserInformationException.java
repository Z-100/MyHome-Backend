package com.myhome.other.exception;

public class InvalidUserInformationException extends Exception {

	/**
	 * The exception thrown when the password entered is wrong
	 *
	 * @param s The information for debugging and the user
	 */
	public InvalidUserInformationException(String s) {
		super(s);
	}
}
