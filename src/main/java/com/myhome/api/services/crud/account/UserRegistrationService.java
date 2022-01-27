package com.myhome.api.services.crud.account;

import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.house.entity.House;
import com.myhome.api.components.member.entity.Member;
import com.myhome.api.components.shoppinglist.entity.ShoppingList;
import com.myhome.api.components.shoppinglist.repository.IShoppingListRepository;
import com.myhome.other.exception.SaveToDatabaseException;
import com.myhome.other.exception.TokenGenerationException;
import com.myhome.service.generate.impl.TokenGenerationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author z-100
 * Class used for the entire registration process
 */
@Component
@EnableTransactionManagement
@AllArgsConstructor
public class UserRegistrationService {

	private final IAccountRepository accountRepository;
	private final IShoppingListRepository shoppingRepository;

	private final TokenGenerationService tokenGenerator;

	/**
	 * Method used to create a new account
	 * and save it to the database, including checks
	 *
	 * @param email The given email the user has created
	 * @param password The given password the user has created
	 * @return On success: The token used by the account
	 */
	public String registerNewUser(String email, String password, String newHouseName, String defaultMemberName)
			throws SaveToDatabaseException {

		if (!emailAlreadyRegistered(email)) {
			String token = null;
			try {
				token = tokenGenerator.createNewToken();
			} catch (TokenGenerationException e) {
				e.printStackTrace();
			}

			Account newAccount = new Account();
			newAccount.setEmail(email);
			newAccount.setPassword(password);
			newAccount.setToken(token);

			if (createNewTransaction(newAccount, newHouseName, defaultMemberName))
				return token;
		} else {
			throw new SaveToDatabaseException("Email already taken!");
		}
		return "Something went wrong, please try again";
	}

	/**
	 * Method used to check if the entered email already
	 * is taken
	 *
	 * @param email the entered email
	 * @return false if email not taken yet
	 */
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
	public boolean createNewTransaction(Account newAccount, String newHouseName, String defaultMemberName) {
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
		House house = new House();

		ShoppingList shoppinglist = new ShoppingList();
		shoppinglist.setFkHouseId(house);
		shoppingRepository.save(shoppinglist);
		shoppinglist.setDate(new Date());

		house.setName(newHouseName);
		house.setShoppinglist(shoppinglist);
		house.setFkAccountId(newAccount);

		Member defaultMember = new Member();
		defaultMember.setName(defaultMemberName);
		defaultMember.setIcon(1);
		defaultMember.setFkAccountId(newAccount);

		newAccount.setHouses(List.of(house));
		newAccount.setMembers(Set.of(defaultMember));

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
