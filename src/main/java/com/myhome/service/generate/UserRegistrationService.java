package com.myhome.service.generate;

import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.house.entity.House;
import com.myhome.api.components.house.repository.IHouseRepository;
import com.myhome.api.components.member.entity.Member;
import com.myhome.api.components.member.repository.IMemberRepository;
import com.myhome.api.components.shoppinglist.entity.ShoppingList;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class UserRegistrationService {

	private final IAccountRepository accountRepository;
	private final IHouseRepository houseRepository;
	private final IMemberRepository memberRepository;

	private final TokenGenerationService tokenGenerator;

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
			String token = tokenGenerator.createNewToken();

			Account newAccount = new Account();
			newAccount.setEmail(email);
			newAccount.setPassword(password);
			newAccount.setToken(token);

			if (createNewTransaction(newAccount, newHouseName, defaultMemberName))
				return token;
		}
		return null;
	}

	private boolean emailAlreadyRegistered(String email) {
		return accountRepository.findByEmail(email) != null;
	}

	/**
	 * Method used to open a transaction allowing for a possible
	 * rollback if something in the system fails
	 *
	 * @param newAccount The newly registered account
	 * @return True if successful, aka. no rollback was needed
	 */
	@Transactional
	boolean createNewTransaction(Account newAccount, String newHouseName, String defaultMemberName) {
		if (saveAccountToDatabase(newAccount, newHouseName, defaultMemberName)) {
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
	private boolean saveAccountToDatabase(Account newAccount, String newHouseName, String defaultMemberName) {

		House newHouse = new House();
		Member newMember = new Member();
		ShoppingList shoppinglist = new ShoppingList();

		newHouse.setName(newHouseName);
		newHouse.setShoppinglist(shoppinglist);

		newMember.setName(defaultMemberName);
		newMember.setIcon(0);

		newAccount.setHouses(List.of(newHouse));
		newAccount.setMembers(Set.of(newMember));

		accountRepository.save(newAccount);

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
		Account savedInDatabase = accountRepository.findByEmail(newAccount.getEmail());

		return newAccount.getEmail().equals(savedInDatabase.getEmail())
				&& newAccount.getPassword().equals(savedInDatabase.getPassword())
				&& newAccount.getToken().equals(savedInDatabase.getToken());
	}
}
