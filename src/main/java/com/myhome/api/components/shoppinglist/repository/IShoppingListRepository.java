package com.myhome.api.components.shoppinglist.repository;

import com.myhome.api.components.shoppinglist.entity.ShoppingList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShoppingListRepository extends CrudRepository<ShoppingList, Long> {
//	House findByAccount(Account account);
}