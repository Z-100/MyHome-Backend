package com.myhome.api.components.account.repository;

import com.myhome.api.components.account.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.stream.Stream;

@Repository
public interface IAccountRepository extends CrudRepository<Account, Long> {

	/**
	 * Find specific account
	 *
	 * @param email used to search for specific account
	 * @return specific account
	 */
	Account findByEmail(String email);

	/**
	 * List all accounts as Iterable
	 *
	 * @return all accounts in Iterable
	 */
	Iterable<Account> findAll();
}