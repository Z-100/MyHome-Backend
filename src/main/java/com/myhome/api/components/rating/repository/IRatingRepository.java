package com.myhome.api.components.rating.repository;

import com.myhome.api.components.rating.entity.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRatingRepository extends CrudRepository<Rating, Long> {

}