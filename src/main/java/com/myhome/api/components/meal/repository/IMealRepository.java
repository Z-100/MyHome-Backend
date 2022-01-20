package com.myhome.api.components.meal.repository;

import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.meal.entity.Meal;
import com.myhome.api.components.member.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMealRepository extends CrudRepository<Meal, Long> {

	Iterable<Meal> findByFkMemberId(Member member);
}