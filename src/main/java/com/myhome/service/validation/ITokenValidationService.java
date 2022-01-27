package com.myhome.service.validation;

public interface ITokenValidationService {

	public boolean validate(String email, String token);
}
