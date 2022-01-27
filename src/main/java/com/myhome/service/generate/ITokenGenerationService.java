package com.myhome.service.generate;

import com.myhome.other.exception.TokenGenerationException;

public interface ITokenGenerationService {

	public String createNewToken() throws TokenGenerationException;
}
