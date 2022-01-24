package com.myhome.api.components.account.services.mapper;

import com.myhome.api.components.account.dto.AccountDTO;
import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.house.entity.House;
import com.myhome.api.components.member.entity.Member;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AbstractAccountMapperTest {

	AccountMapper mapper = new AccountMapper();

	@Test
	void toDTO() {
		Account acc = new Account();
		acc.setEmail("sas");
		acc.setPassword("ses");
		acc.setToken("sus");
		acc.setId(5);
		acc.setHouses(List.of());
		acc.setMembers(Set.of());

		AccountDTO accDTO = mapper.toDTO(acc);

		assertAll(
				() -> assertEquals("sas", accDTO.getEmail()),
				() -> assertEquals("sus", accDTO.getToken()),
				() -> assertEquals(5, accDTO.getId())
		);
	}
}