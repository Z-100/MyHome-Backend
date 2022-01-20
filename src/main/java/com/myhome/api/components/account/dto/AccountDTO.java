package com.myhome.api.components.account.dto;

import com.myhome.api.components.house.entity.House;
import com.myhome.api.components.member.entity.Member;
import lombok.Data;

import java.util.Set;

@Data
public class AccountDTO {

	private Integer id;

	private String email;

	private String token;

	private Set<House> houses;

	private Set<Member> members;
}
