package com.myhome.api.components.account.repository;

import com.myhome.api.components.account.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

}