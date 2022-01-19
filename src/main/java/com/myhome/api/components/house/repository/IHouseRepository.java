package com.myhome.api.components.house.repository;

import com.myhome.api.components.house.entity.House;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHouseRepository extends CrudRepository<House, Long> {

	House findHouseByFkAccountId(Integer fkAccountId);
}