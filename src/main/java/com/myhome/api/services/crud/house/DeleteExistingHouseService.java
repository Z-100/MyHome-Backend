package com.myhome.api.services.crud.house;

import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.house.entity.House;
import com.myhome.api.components.house.repository.IHouseRepository;
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
@Deprecated
public class DeleteExistingHouseService {

	private final IHouseRepository houseRepository;

	/**
	 * Method used to gather member and account information
	 *
	 * @param email The accounts emil
	 * @param memberId The members id
	 * @return True on success
	 */
	public boolean delete(Long houseId) {

//		House house = houseRepository.
//
//		if (account != null) {
//			account.setHouses(null);
//			account.setMembers(null);
//
//			return createNewTransaction(account);
//		}
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
	public boolean deleteAccount(Account account) {
//		houseRepository.delete(account);

		return accountDeletedCorrectly(account);
	}

	/**
	 * Method used to verify member deletion
	 *
	 * @param member The deleted member
	 * @return True on success
	 */
	public boolean accountDeletedCorrectly(Account account) {
//		return houseRepository.findByEmail(account.getEmail()) == null;
		return false;
	}
}
