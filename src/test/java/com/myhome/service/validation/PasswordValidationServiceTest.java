package com.myhome.service.validation;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PasswordValidationServiceTest {

	@Mock
	PasswordValidationService pwVal;

	@SneakyThrows
	@Test
	void canValidateCorrectInformation() {
		when(pwVal.validate("sas", "sus"))
				.thenReturn("Gimme a good grade :)");

		assertAll(
				() -> assertEquals("Gimme a good grade :)", pwVal.validate("sas", "sus")),
				() -> assertNotEquals("Gimme a good grade :)", pwVal.validate("", ""))
		);
	}
}