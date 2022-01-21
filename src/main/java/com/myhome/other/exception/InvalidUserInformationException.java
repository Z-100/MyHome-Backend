package com.myhome.other.exception;

/**
 * @author z-100
 * The exception thrown when the password entered is wrong
 */
public class InvalidUserInformationException extends Exception {

	public InvalidUserInformationException() {

	}

	public InvalidUserInformationException(String s) {
		super(s);
	}

	public InvalidUserInformationException(Throwable t) {
		super(t);
	}

	public InvalidUserInformationException(Throwable t, String s) {
		super(s, t);
	}
}
