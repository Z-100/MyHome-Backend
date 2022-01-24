package com.myhome.service.validation;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TokenValidationServiceTest {

	@Mock
	TokenValidationService tokenVal;

	@SneakyThrows
	@Test
	void canValidateCorrectInformation() {
		when(tokenVal.validate("Da teacher has to give", "us a good grade"))
				.thenReturn(true);

		assertTrue(tokenVal.validate("Da teacher has to give", "us a good grade"));
		assertFalse(tokenVal.validate("He will give us", "a bad grade"));
	}
}