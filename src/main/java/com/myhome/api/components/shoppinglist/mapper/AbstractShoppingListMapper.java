package com.myhome.api.components.shoppinglist.mapper;

import com.myhome.api.components.shoppinglist.dto.ShoppingListDTO;
import com.myhome.api.components.shoppinglist.entity.ShoppingList;
import org.mapstruct.Mapper;

@Mapper(implementationName = "ShoppingListMapper",
		componentModel = "spring")
public abstract class AbstractShoppingListMapper {

	abstract public ShoppingListDTO toDTO(ShoppingList entity);

	abstract public ShoppingList toEntity(ShoppingListDTO dto);
}
