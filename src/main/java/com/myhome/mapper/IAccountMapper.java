package com.myhome.mapper;

import com.myhome.dto.AccountDTO;
import com.myhome.entities.Account;
import org.mapstruct.Mapper;

@Mapper
public interface IAccountMapper {

	AccountDTO toDTO(Account entity);

	Account toEntity(AccountDTO dto);
}
