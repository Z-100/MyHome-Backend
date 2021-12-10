package com.myhome.api.components.cleaning.repository;

import com.myhome.api.components.cleaning.entity.Cleaning;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICleaningRepository extends CrudRepository<Cleaning, Long> {
	Cleaning findByCleaningTime(String date);
}