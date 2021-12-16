package com.myhome.api.components.member.repository;

import com.myhome.api.components.member.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMemberRepository extends CrudRepository<Member, Long> {
//	House findByAccount(Account account);
}