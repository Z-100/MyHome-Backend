package com.myhome.api.services.crud.house;

import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.house.entity.House;
import com.myhome.api.components.house.repository.IHouseRepository;
import com.myhome.api.components.shoppinglist.entity.ShoppingList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Set;

/**
 * @author z-100
 * Class used to communicate between database and API
 */
@AllArgsConstructor
@Component
public class InsertNewHouseService {

	private final IAccountRepository accountRepository;
	private final IHouseRepository houseRepository;

	/**
	 * Method used to create nwe house
	 *
	 * @param email The accounts email
	 * @param name The houses name
	 * @return True on success
	 */
	public boolean insert(String email, String name) {

		House newHouse = new House();
		newHouse.setName(name);
		newHouse.setRooms(List.of());
		newHouse.setShoppinglist(new ShoppingList());
		newHouse.setRecipes(Set.of());
		newHouse.setFkAccountId(accountRepository.findByEmail(email));

		return createNewTransaction(newHouse);
	}

	/**
	 * Method used to open a transaction allowing for a possible
	 * rollback if something in the system fails
	 *
	 * @param newHouse The to be saved house
	 */
	@Transactional
	public boolean createNewTransaction(House newHouse) {
		if (saveHouseToDatabase(newHouse)) {
			return true;
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}

	/**
	 * Method used to actually save the house
	 *
	 * @param newHouse The to be saved icon
	 * @return true on success
	 */
	public boolean saveHouseToDatabase(House newHouse) {
		houseRepository.save(newHouse);

		return houseSavedCorrectly(newHouse);
	}

	/**
	 * Method used to check if house was saved correctly
	 *
	 * @param newHouse The saved member
	 * @return True on success
	 */
	public boolean houseSavedCorrectly(House newHouse) {
	 return houseRepository.findById(newHouse.getId()).get().getName()
			 .equals(newHouse.getName());
	}
}
