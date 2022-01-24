package com.myhome.api.components.shoppinglist.dto;

import com.myhome.api.components.item.entity.Item;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class ShoppingListDTO {

	private Long id;

	private Date date;

	private Set<Item> items;
}
