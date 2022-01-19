package com.myhome.api.components.rating.mapper;

import com.myhome.api.components.rating.dto.RatingDTO;
import com.myhome.api.components.rating.entity.Rating;
import org.mapstruct.Mapper;

@Mapper(implementationName = "RatingMapper",
		componentModel = "spring")
public abstract class AbstractRatingMapper {

	abstract RatingDTO toDTO(Rating entity);

	abstract Rating toEntity(RatingDTO dto);
}
