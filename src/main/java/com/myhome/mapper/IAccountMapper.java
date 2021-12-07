package com.myhome.mapper;

import com.myhome.dto.AccountDTO;
import com.myhome.entity.Account;
import org.mapstruct.Mapper;

@Mapper(implementationName = "AccountMapper")
public interface IAccountMapper {

	AccountDTO toDTO(Account entity);

	Account toEntity(AccountDTO dto);
}
