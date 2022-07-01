package com.myhome.api.components.account.services.crud;

import org.springframework.http.ResponseEntity;

public interface ILoginService {

	ResponseEntity<?> login(String email, String password);
}
