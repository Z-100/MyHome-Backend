package com.myhome.api.components.account.services.mapper;

import com.myhome.api.components.account.dto.AccountDTO;
import com.myhome.api.components.account.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" /*uses = { AThreadMapper.class, AQuestionMapper.class, ACommentMapper.class }*/)
public abstract class AAccountMapper {

	abstract public AccountDTO toDTO(Account entity);

	@Mapping(target = "password", ignore = true)
	abstract public Account toEntity(AccountDTO dto);
}
