package com.myhome.api.components.account.services.mapper;

import com.myhome.api.components.account.dto.AccountDTO;
import com.myhome.api.components.account.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(implementationName = "AccountMapper")
public abstract class IAccountMapper {

	abstract public AccountDTO toDTO(Account entity);

	@Mapping(target = "password", ignore = true)
	abstract public Account toEntity(AccountDTO dto);
}
