package com.myhome.api.components.account.repository;

import com.myhome.api.components.account.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface IAccountRepository extends CrudRepository<Account, Long> {

	Account findByEmail(String email);

	List<Account> findAll();

	Optional<Account> findByEmailAndPassword(String email, String password);

	Optional<Account> findByEmailAndToken(String email, String token);
}