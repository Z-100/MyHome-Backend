package com.myhome.api.components.account.services.crud.impl;

import com.myhome.api.components.account.dto.AccountDTO;
import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.account.services.crud.IAccountService;
import com.myhome.api.components.account.services.crud.ILoginService;
import com.myhome.api.components.account.services.crud.IRegisterService;
import com.myhome.api.components.account.services.mapper.AAccountMapper;
import com.myhome.service.validation.IValidationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AccountService implements IAccountService, IRegisterService, ILoginService {

	private final IAccountRepository accountRepository;

	private final IValidationService passwordValidation;
	private final AAccountMapper accountMapper;

	@Override
	public ResponseEntity<?> login(String email, String password) {

		passwordValidation.validateLogin(email, password);
		//TODO Change to interceptor. Return true
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@Override
	public Boolean register(String email, String password, String validationSentence) {
		return null;
	}

	@Override
	public Account getAccount(String email) {
		return null;
	}

	@Override
	public List<AccountDTO> getAllAccounts() {
		return null;
	}

	@Override
	public Boolean update(String email, String password, String newEmail, String newPassword) {
		return null;
	}

	@Override
	public Boolean delete(String email, String password) {
		return null;
	}

	@Override
	public Boolean forgottenPassword(String email, String newPassword, String validationSentence) {
		return null;
	}
}
