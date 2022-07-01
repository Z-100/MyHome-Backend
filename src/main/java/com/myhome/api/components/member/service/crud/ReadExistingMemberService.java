package com.myhome.api.components.member.service.crud;

import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.member.dto.MemberDTO;
import com.myhome.api.components.member.repository.IMemberRepository;
import com.myhome.api.components.member.service.mapper.AbstractMemberMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author z-100
 * Class used to communicate between database and API
 */
@AllArgsConstructor
@Component
public class ReadExistingMemberService {

	private final IMemberRepository memberRepository;
	private final IAccountRepository accountRepository;
	private final AbstractMemberMapper memberMapper;

	/**
	 * Method used to get all members from database
	 *
	 * @param email The accounts email
	 * @return All members (nullable)
	 */
	public Iterable<MemberDTO> getAllMembers(String email) {

		List<MemberDTO> memberDTOs = new ArrayList<>();

		memberRepository.findByFkAccountId(accountRepository.findByEmail(email))
				.forEach(member -> {
					memberDTOs.add(
							memberMapper.toDTO(member));
				});
		return memberDTOs;
	}
}
