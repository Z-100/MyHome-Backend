package com.myhome.api.components.room.dto;

import com.myhome.api.components.cleaning.entity.Cleaning;
import com.myhome.api.components.item.entity.Item;
import lombok.Data;

import java.util.Set;

@Data
public class RoomDTO {

	private Long id;

	private String name;

	private Integer icon;

	private Set<Cleaning> cleanings;

	private Set<Item> items;
}
