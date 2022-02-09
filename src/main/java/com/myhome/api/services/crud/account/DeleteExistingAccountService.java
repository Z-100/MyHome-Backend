package com.myhome.api.services.crud.account;

import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.account.repository.IAccountRepository;
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
public class DeleteExistingAccountService {
	//TODO May need rework. Constraints. Account should delete everything
	private final IAccountRepository accountRepository;

	/**
	 * Method used to gather member and account information
	 *
	 * @param email The accounts emil
	 * @param memberId The members id
	 * @return True on success
	 */
	public boolean delete(String email) {

		Account account = accountRepository.findByEmail(email);

		if (account != null) {
			account.setHouses(null);
			account.setMembers(null);

			return createNewTransaction(account);
		}
		return false;
	}

	/**
	 * Method used to open a transaction allowing for a possible
	 * rollback if something in the system fails
	 *
	 * @param account The members account
	 * @param member To be deleted member
	 */
	@Transactional
	boolean createNewTransaction(Account account) {
		if (deleteAccount(account)) {
			return true;
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}

	/**
	 * Method used to delete the member from the database
	 *
	 * @param account The to be deleted account
	 * @return True on success
	 */
	private boolean deleteAccount(Account account) {
		accountRepository.delete(account);

		return accountDeletedCorrectly(account);
	}

	/**
	 * Method used to verify member deletion
	 *
	 * @param member The deleted member
	 * @return True on success
	 */
	private boolean accountDeletedCorrectly(Account account) {
		return accountRepository.findByEmail(account.getEmail()) == null;
	}
}
