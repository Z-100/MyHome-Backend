package com.myhome.api.components.member.controller;

import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.member.dto.MemberDTO;
import com.myhome.api.components.member.entity.Member;
import com.myhome.api.components.member.services.mapper.AbstractMemberMapper;
import com.myhome.api.components.member.repository.IMemberRepository;
import com.myhome.service.validation.TokenValidationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author z-100
 * Class used to handle database communication with table "member"
 */
@RestController
@RequestMapping("/member")
@AllArgsConstructor
public class MemberController {

	private final IMemberRepository memberRepository;
	private final IAccountRepository accountRepository;
	private final AbstractMemberMapper memberMapper;

	private final TokenValidationService tokenValidation;

	/**
	 * Method used to get all members from database (only members)
	 *
	 * @param email The accounts email (validation and account)
	 * @param token The accounts specific token to validate the request
	 * @return Iterable of all members belonging to said account
	 */
	@GetMapping("/get-member")
	public Iterable<MemberDTO> helloWorld(
			@RequestHeader("email") String email,
			@RequestHeader("token") String token) {

		if (tokenValidation.validate(email, token)) {
			List<MemberDTO> memberDTOs = new ArrayList<>();

			memberRepository.findByFkAccountId(accountRepository.findByEmail(email))
					.forEach(member -> {
						memberDTOs.add(
								memberMapper.toDTO(member));
					});

			return memberDTOs;
		}
		return null;
	}
}
