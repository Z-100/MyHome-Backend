package com.myhome.api.components.room.services.mapper;

import com.myhome.api.components.room.dto.RoomDTO;
import com.myhome.api.components.room.entity.Room;
import org.mapstruct.Mapper;

@Mapper(implementationName = "ItemMapper",
		componentModel = "spring")
public abstract class AbstractItemMapper {

	abstract public RoomDTO toDTO(Room entity);

	abstract public Room toEntity(RoomDTO dto);
}
