package com.myhome.api.components.member.services.mapper;

import com.myhome.api.components.member.dto.MemberDTO;
import com.myhome.api.components.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(implementationName = "MemberMapper",
		componentModel = "spring")
public abstract class AbstractMemberMapper {

	abstract public MemberDTO toDTO(Member entity);

	abstract public Member toEntity(MemberDTO dto);
}
