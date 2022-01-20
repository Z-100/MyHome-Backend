package com.myhome.service.generate;

import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.house.entity.House;
import com.myhome.api.components.member.entity.Member;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Set;

/**
 * @author z-100
 * Class used for the entire registration process
 * (Might need changes in the future)
 */
@Component
@EnableTransactionManagement
public class UserRegistrationService {

	private final IAccountRepository repository;

	private final String token;

	public UserRegistrationService(IAccountRepository repository, TokenGenerationService tokenGenerator) {
		this.repository = repository;
		this.token = tokenGenerator.createNewToken();
	}

	/**
	 * Method used to create a new account
	 * and save it to the database, including checks
	 *
	 * @param email The given email the user has created
	 * @param password The given password the user has created
	 * @return On success: The token used by the account
	 */
	public String registerNewUser(String email, String password, String newHouseName, String defaultMemberName) {

		if (!emailAlreadyRegistered(email)) {
			Account newAccount = new Account();

			House newHouse = new House();

			Member newMember = new Member();

			newHouse.setName(newHouseName);

			newMember.setName(defaultMemberName);
			newMember.setIcon(0);

			newAccount.setEmail(email);
			newAccount.setPassword(password);
			newAccount.setToken(this.token);
			newAccount.setHouses(List.of(newHouse));
			newAccount.setMembers(Set.of(newMember));

			if (createNewTransaction(newAccount))
				return this.token;
		}
		return null;
	}

	private boolean emailAlreadyRegistered(String email) {
		return repository.findByEmail(email) != null;
	}

	/**
	 * Method used to open a transaction allowing for a possible
	 * rollback if something in the system fails
	 *
	 * @param newAccount The newly registered account
	 * @return True if successful, aka. no rollback was needed
	 */
	@Transactional
	boolean createNewTransaction(Account newAccount) {
		if (saveAccountToDatabase(newAccount)) {
			return true;
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}

	/**
	 * Method used to save the new user to the database
	 *
	 * @param newAccount The newly registered account
	 * @return True if successful
	 */
	private boolean saveAccountToDatabase(Account newAccount) {
		repository.save(newAccount);

		return accountSavedCorrectly(newAccount);
	}

	/**
	 * Method used to check if the data has been stored
	 * correctly after INSERTing it.
	 *
	 * @param newAccount The newly registered account
	 * @return True if data matches
	 */
	private boolean accountSavedCorrectly(Account newAccount) {
		Account savedInDatabase = repository.findByEmail(newAccount.getEmail());

		return newAccount.getEmail().equals(savedInDatabase.getEmail())
				&& newAccount.getPassword().equals(savedInDatabase.getPassword())
				&& newAccount.getToken().equals(savedInDatabase.getToken());
	}
}
