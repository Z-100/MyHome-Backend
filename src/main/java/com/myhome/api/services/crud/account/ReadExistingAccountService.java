package com.myhome.api.services.crud.account;

import com.myhome.api.components.account.dto.AccountDTO;
import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.account.services.mapper.AbstractAccountMapper;
import com.myhome.api.components.member.dto.MemberDTO;
import com.myhome.api.components.member.repository.IMemberRepository;
import com.myhome.api.components.member.services.mapper.AbstractMemberMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author z-100
 * Class used to communicate between database and API
 */
@AllArgsConstructor
@Component
public class ReadExistingAccountService {

	private final IAccountRepository accountRepository;
	private final AbstractAccountMapper accountMapper;

	/**
	 * Method used to get account from database
	 *
	 * @param email The accounts email
	 * @return The account
	 */
	public AccountDTO getAccount(String email) {

		return accountMapper.toDTO(accountRepository.findByEmail(email));
	}
}
