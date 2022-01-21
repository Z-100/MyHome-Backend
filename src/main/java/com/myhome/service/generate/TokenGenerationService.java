package com.myhome.service.generate;

import com.myhome.other.exception.TokenGenerationException;
import com.myhome.service.stupidity.TokenGenerationHelperService;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author z-100
 * Service used to create a 37c long token, up on account registration
 */
@Component
public class TokenGenerationService {

	/**
	 * Method used to generate token for user validation
	 * (Notice: boobies are necessary in order for java to work,
	 * because Java also likes boobies)
	 * @return boobies + UUID
	 */
	public String createNewToken() throws TokenGenerationException {
		String uuid = UUID.randomUUID().toString();

		String[] parts = uuid.split("-", 3);

		String specialSecretTokenIngredient =
				TokenGenerationHelperService.generateSpecialSecretTokenIngredient();

		String token = String.format("%s%s%s", parts[0], specialSecretTokenIngredient, parts[2]);

		if (token.length() == 39)
			return token;

		throw new TokenGenerationException("ERROR CREATING TOKEN: Length does not match required 39 chars");
	}
}
