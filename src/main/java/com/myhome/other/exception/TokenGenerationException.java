package com.myhome.other.exception;

/**
 * @author z-100
 *
 * Exception thrown on wrong generation
 */
public class TokenGenerationException extends Exception {

	public TokenGenerationException() {

	}

	public TokenGenerationException(String s) {
		super(s);
	}

	public TokenGenerationException(Throwable t) {
		super(t);
	}

	public TokenGenerationException(Throwable t, String s) {
		super(s, t);
	}
}
