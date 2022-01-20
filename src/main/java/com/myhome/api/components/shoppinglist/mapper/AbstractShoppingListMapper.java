package com.myhome.api.components.shoppinglist.mapper;

import com.myhome.api.components.shoppinglist.dto.ItemDTO;
import com.myhome.api.components.shoppinglist.entity.ShoppingList;
import org.mapstruct.Mapper;

@Mapper(implementationName = "ShoppingListMapper",
		componentModel = "spring")
public abstract class AbstractShoppingListMapper {

	abstract public ItemDTO toDTO(ShoppingList entity);

	abstract public ShoppingList toEntity(ItemDTO dto);
}
