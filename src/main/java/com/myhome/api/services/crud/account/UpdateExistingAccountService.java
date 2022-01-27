package com.myhome.api.services.crud.account;

import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.member.entity.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @author z-100
 * Class used to communicate between database and API
 */
@AllArgsConstructor
@Component
public class UpdateExistingAccountService {

	private final IAccountRepository accountRepository;

	/**
	 * Method used to edit member
	 *
	 * @param email The accounts (old) email
	 * @param newEmail The to be updated email
	 * @param newPassword The to be updated password
	 * @return True on success
	 */
	public boolean update(String email, String newEmail, String newPassword) {

		Account account = accountRepository.findByEmail(email);
		account.setEmail(newEmail);
		account.setPassword(newPassword);

		return createNewTransaction(account, email);
	}

	/**
	 * Method used to open a transaction allowing for a possible
	 * rollback if something in the system fails
	 *
	 * @param member The to be updated member
	 */
	@Transactional
	public boolean createNewTransaction(Account account, String email) {
		if (saveAccountToDatabase(account, email)) {
			return true;
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}

	/**
	 * Method used to actually update the account
	 *
	 * @param account The to be updated account
	 * @return true on success
	 */
	public boolean saveAccountToDatabase(Account account, String email) {
		accountRepository.save(account);

		return accountUpdatedCorrectly(account, email);
	}

	/**
	 * Method used to check if account was updated correctly
	 *
	 * @param account The updated account
	 * @return True on success
	 */
	public boolean accountUpdatedCorrectly(Account account, String email) {
		return !accountRepository.findByEmail(email).getEmail().equals(email);
	}
}
