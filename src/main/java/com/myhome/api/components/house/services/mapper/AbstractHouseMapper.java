package com.myhome.api.components.house.services.mapper;

import com.myhome.api.components.house.dto.HouseDTO;
import com.myhome.api.components.house.entity.House;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(implementationName = "HouseMapper",
		componentModel = "spring")
public abstract class AbstractHouseMapper {

	@Mapping(target = "rooms", ignore = true)
	abstract public HouseDTO toDTO(House entity);

	@Mapping(target = "rooms", ignore = true)
	abstract public House toEntity(HouseDTO dto);

	@AfterMapping
	void setRoomsToDto(@MappingTarget HouseDTO dto, House entity) {
		dto.setRooms(entity.getRooms());
	}

	@AfterMapping
	void setRoomsToEntity(@MappingTarget House entity, HouseDTO dto) {
		entity.setRooms(dto.getRooms());
	}
}
