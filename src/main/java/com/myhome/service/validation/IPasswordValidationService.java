package com.myhome.service.validation;

import com.myhome.other.exception.InvalidUserInformationException;

public interface IPasswordValidationService {

	public String validate(String email, String password) throws InvalidUserInformationException;
}
