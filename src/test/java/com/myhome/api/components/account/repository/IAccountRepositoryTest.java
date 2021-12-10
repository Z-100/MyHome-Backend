package com.myhome.api.components.account.repository;

import com.myhome.api.components.account.entity.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class IAccountRepositoryTest {

	@Autowired
	private IAccountRepository accountRepository;

	private int countBefore = 0;

	@BeforeEach
	void setUp() {

		Iterable<Account> accounts = accountRepository.findAll();
		for (Account acc : accounts)
			countBefore++;

		Account acc1 = new Account("hans", "peter");
		Account acc2 = new Account("ueli", "berset");
		assertNull(acc1.getId());
		assertNull(acc2.getId());//null before save
		this.accountRepository.save(acc1);
		this.accountRepository.save(acc2);
		assertNotNull(acc1.getId());
		assertNotNull(acc2.getId());
	}
	@Test
	public void testFetchData(){

		Account accA = accountRepository.findByEmail("hans");
		assertNotNull(accA);
		assertEquals("peter", accA.getPassword());

		int count = 0;

		Iterable<Account> accounts = accountRepository.findAll();
		for (Account acc : accounts)
			count++;

		assertEquals(2, count - countBefore);
	}
}