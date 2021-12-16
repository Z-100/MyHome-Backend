package com.myhome.api.components.account.services.mapper;

import com.myhome.api.components.account.dto.AccountDTO;
import com.myhome.api.components.account.entity.Account;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(implementationName = "AccountMapper",
		componentModel = "spring")
public abstract class AbstractAccountMapper {

	@Mapping(target = "houses", ignore = true)
	abstract public AccountDTO toDTO(Account entity);

	@Mapping(target = "password", ignore = true)
	@Mapping(target = "houses", ignore = true)
	abstract public Account toEntity(AccountDTO dto);

	@AfterMapping
	void setHousetoDto(@MappingTarget AccountDTO dto, Account entity) {
		dto.setHouses(entity.getHouses());
	}

	@AfterMapping
	void setHouseToEntity(@MappingTarget Account entity, AccountDTO dto) {
		entity.setHouses(dto.getHouses());
	}
}
