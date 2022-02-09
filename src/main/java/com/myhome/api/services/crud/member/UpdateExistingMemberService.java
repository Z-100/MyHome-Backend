package com.myhome.api.services.crud.member;

import com.myhome.api.components.member.entity.Member;
import com.myhome.api.components.member.repository.IMemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @author z-100
 * Class used to communicate between database and API
 */
@AllArgsConstructor
@Component
public class UpdateExistingMemberService {

	private final IMemberRepository memberRepository;

	/**
	 * Method used to edit member
	 *
	 * @param memberId The to be updated members id
	 * @param replacementIcon The to be updated icon
	 * @param replacementName The to be updated name
	 * @return True on success
	 */
	public boolean update(Long memberId, Integer replacementIcon, String replacementName) {

		Member member = memberRepository.findMemberById(memberId);

		member.setIcon(replacementIcon);
		member.setName(replacementName);

		return createNewTransaction(member);
	}

	/**
	 * Method used to open a transaction allowing for a possible
	 * rollback if something in the system fails
	 *
	 * @param member The to be updated member
	 */
	@Transactional
	boolean createNewTransaction(Member member) {
		if (saveMemberToDatabase(member)) {
			return true;
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}

	/**
	 * Method used to actually update the member
	 *
	 * @param member The to be updated member
	 * @return true on success
	 */
	private boolean saveMemberToDatabase(Member member) {
		memberRepository.save(member);

		return memberUpdatedCorrectly(member);
	}

	/**
	 * Method used to check if member was updated correctly
	 *
	 * @param member The updated member
	 * @return True on success
	 */
	private boolean memberUpdatedCorrectly(Member member) {
		return memberRepository.findById(member.getId()).get().getName()
				.equals(member.getName());
	}
}
