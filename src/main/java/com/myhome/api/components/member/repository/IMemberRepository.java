package com.myhome.api.components.member.repository;

import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.member.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMemberRepository extends CrudRepository<Member, Long> {

	Iterable<Member> findByFkAccountId(Account account);
}