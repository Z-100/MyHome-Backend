package com.myhome.api.components.item.repository;

import com.myhome.api.components.item.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoomRepository extends CrudRepository<Item, Long> {
//	House findByAccount(Account account);
}