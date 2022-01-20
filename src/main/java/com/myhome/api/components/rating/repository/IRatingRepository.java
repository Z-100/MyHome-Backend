package com.myhome.api.components.rating.repository;

import com.myhome.api.components.member.entity.Member;
import com.myhome.api.components.rating.entity.Rating;
import com.myhome.api.components.recipe.entity.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRatingRepository extends CrudRepository<Rating, Long> {

	Iterable<Rating> findRatingsByFkRecipeId(Recipe recipe);

	List<Rating> findByFkMemberId(Member member);
}