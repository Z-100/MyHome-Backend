package com.myhome.api.components.member.services.mapper;

import com.myhome.api.components.house.dto.HouseDTO;
import com.myhome.api.components.house.entity.House;
import com.myhome.api.components.member.dto.MemberDTO;
import com.myhome.api.components.member.entity.Member;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(implementationName = "MemberMapper",
		componentModel = "spring")
public abstract class AbstractMemberMapper {

	abstract public MemberDTO toDTO(Member entity);

	abstract public Member toEntity(MemberDTO dto);

	@AfterMapping
	void setMealsToDto(@MappingTarget MemberDTO dto, Member entity) {
		dto.setMeals(entity.getMeals());
	}

	@AfterMapping
	void setRoomsToEntity(@MappingTarget Member entity, MemberDTO dto) {
		entity.setMeals(dto.getMeals());
	}
}
