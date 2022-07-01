package com.myhome.api.components.member.service.crud;

import com.myhome.api.components.account.repository.IAccountRepository;
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
public class DeleteExistingMemberService {

	private final IMemberRepository memberRepository;
	private final IAccountRepository accountRepository;

	/**
	 * Method used to gather member and account information
	 *
	 * @param email The accounts emil
	 * @param memberId The members id
	 * @return True on success
	 */
	public boolean delete(Long memberId) {

		Member member = memberRepository.findMemberById(memberId);

		if (member != null) {
			member.setFkAccountId(null);
			member.setMeals(null);
			member.setRatings(null);

			return createNewTransaction(member);
		}
		return false;
	}

	/**
	 * Method used to open a transaction allowing for a possible
	 * rollback if something in the system fails
	 *
	 * @param account The members account
	 * @param member To be deleted member
	 */
	@Transactional
	boolean createNewTransaction(Member member) {
		if (deleteMember(member)) {
			return true;
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}

	/**
	 * Method used to delete the member from the database
	 *
	 * @param account The members account
	 * @param member The to be deleted member
	 * @return True on success
	 */
	private boolean deleteMember(Member member) {
		memberRepository.delete(member);

		return memberDeletedCorrectly(member);
	}

	/**
	 * Method used to verify member deletion
	 *
	 * @param member The deleted member
	 * @return True on success
	 */
	private boolean memberDeletedCorrectly(Member member) {
		return memberRepository.findMemberById(member.getId()) == null;
	}
}
