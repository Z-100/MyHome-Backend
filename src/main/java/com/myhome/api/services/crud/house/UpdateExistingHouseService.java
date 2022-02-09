package com.myhome.api.services.crud.house;

import com.myhome.api.components.account.repository.IAccountRepository;
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
public class UpdateExistingHouseService {

	private final IAccountRepository accountRepository;
	private final IHouseRepository houseRepository;

	/**
	 * Method used to edit house
	 *
	 * @param email The accounts (old) email
	 * @param newName The houses new name
	 * @return True on success
	 */
	public boolean update(String email, String newName) {

		House house = accountRepository.findByEmail(email).getHouses().get(0);

		String oldName = house.getName();

		house.setName(newName);

		return createNewTransaction(house, oldName);
	}

	/**
	 * Method used to open a transaction allowing for a possible
	 * rollback if something in the system fails
	 *
	 * @param house The to be updated house
	 * @param oldName The houses old name
	 */
	@Transactional
	boolean createNewTransaction(House house, String oldName) {
		if (saveHouseToDatabase(house, oldName)) {
			return true;
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}

	/**
	 * Method used to actually update the account
	 *
	 * @param house The to be updated house
	 * @param oldName The houses old name
	 * @return true on success
	 */
	private boolean saveHouseToDatabase(House house, String oldName) {
		houseRepository.save(house);

		return houseUpdatedCorrectly(house, oldName);
	}

	/**
	 * Method used to check if house was updated correctly
	 *
	 * @param house The updated house
	 * @return True on success
	 */
	private boolean houseUpdatedCorrectly(House house, String oldName) {
		return !houseRepository.findHouseByFkAccountId(
				house.getFkAccountId()).getName().equals(oldName);
	}
}
