package com.myhome.other.exception;

/**
 * @author z-100
 * The exception thrown when something went wrong during the saving process
 */
public class SaveToDatabaseException extends Exception {

	public SaveToDatabaseException() {

	}

	public SaveToDatabaseException(String s) {
		super(s);
	}

	public SaveToDatabaseException(Throwable t) {
		super(t);
	}

	public SaveToDatabaseException(Throwable t, String s) {
		super(s, t);
	}
}
