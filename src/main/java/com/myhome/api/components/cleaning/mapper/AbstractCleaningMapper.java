package com.myhome.api.components.cleaning.mapper;

import com.myhome.api.components.cleaning.dto.CleaningDTO;
import com.myhome.api.components.cleaning.entity.Cleaning;
import org.mapstruct.Mapper;

@Mapper(implementationName = "CleaningMapper",
		componentModel = "spring")
public abstract class AbstractCleaningMapper {

	abstract public CleaningDTO toDTO(Cleaning entity);

	abstract public Cleaning toEntity(CleaningDTO dto);
}
