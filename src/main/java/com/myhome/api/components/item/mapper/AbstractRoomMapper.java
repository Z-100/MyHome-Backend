package com.myhome.api.components.item.mapper;

import com.myhome.api.components.item.dto.ItemDTO;
import com.myhome.api.components.item.entity.Item;
import org.mapstruct.Mapper;

@Mapper(implementationName = "RoomMapper",
		componentModel = "spring")
public abstract class AbstractRoomMapper {

	abstract public ItemDTO toDTO(Item entity);

	abstract public Item toEntity(ItemDTO dto);
}
