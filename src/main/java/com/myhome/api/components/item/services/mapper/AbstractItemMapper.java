package com.myhome.api.components.item.services.mapper;

import com.myhome.api.components.item.dto.ItemDTO;
import com.myhome.api.components.item.entity.Item;
import org.mapstruct.Mapper;

@Mapper(implementationName = "ItemMapper",
		componentModel = "spring")
public abstract class AbstractItemMapper {

	abstract public ItemDTO toDTO(Item entity);

	abstract public Item toEntity(ItemDTO dto);
}
