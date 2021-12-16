package com.myhome.api.components.room.services.mapper;

import com.myhome.api.components.room.dto.RoomDTO;
import com.myhome.api.components.room.entity.Room;
import org.mapstruct.Mapper;

@Mapper(implementationName = "RoomMapper",
		componentModel = "spring")
public abstract class AbstractRoomMapper {

	abstract public RoomDTO toDTO(Room entity);

	abstract public Room toEntity(RoomDTO dto);
}
