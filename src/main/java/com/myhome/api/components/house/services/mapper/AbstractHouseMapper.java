package com.myhome.api.components.house.services.mapper;

import com.myhome.api.components.house.dto.HouseDTO;
import com.myhome.api.components.house.entity.House;
import org.mapstruct.Mapper;

@Mapper(implementationName = "HouseMapper",
		componentModel = "spring")
public abstract class AbstractHouseMapper {

	abstract public HouseDTO toDTO(House entity);

	abstract public House toEntity(HouseDTO dto);
}
