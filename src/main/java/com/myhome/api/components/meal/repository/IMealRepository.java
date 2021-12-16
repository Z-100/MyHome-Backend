package com.myhome.api.components.meal.repository;

import com.myhome.api.components.meal.entity.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMealRepository extends CrudRepository<Meal, Long> {
//	House findByAccount(Account account);
}