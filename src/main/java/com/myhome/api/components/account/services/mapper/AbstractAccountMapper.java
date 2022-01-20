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

	@Mapping(target = "members", ignore = true)
	abstract public AccountDTO toDTO(Account entity);

	@Mapping(target = "password", ignore = true)
	@Mapping(target = "members", ignore = true)
	abstract public Account toEntity(AccountDTO dto);

	@AfterMapping
	void setMemberToDto(@MappingTarget AccountDTO dto, Account entity) {
		dto.setMembers(entity.getMembers());
	}

	@AfterMapping
	void setMemberToEntity(@MappingTarget Account entity, AccountDTO dto) {
		entity.setMembers(dto.getMembers());
	}
}
