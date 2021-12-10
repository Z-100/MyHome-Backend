package com.myhome.api.components.account.repository;

import com.myhome.api.components.account.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends CrudRepository<Account, Long> {
	Account findByEmail(String email);
}