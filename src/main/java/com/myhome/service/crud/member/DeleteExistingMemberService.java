package com.myhome.service.crud.member;

import com.myhome.api.components.account.entity.Account;
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
	public boolean delete(String email, Long memberId) {

		Member member = memberRepository.findMemberById(memberId);
		member.setFkAccountId(null);
		member.setMeals(null);
		member.setRatings(null);

		Account account = accountRepository.findByEmail(email);
		account.getMembers().remove(member);

		return createNewTransaction(account, member);
	}

	/**
	 * Method used to open a transaction allowing for a possible
	 * rollback if something in the system fails
	 *
	 * @param account The members account
	 * @param member To be deleted member
	 */
	@Transactional
	boolean createNewTransaction(Account account, Member member) {
		if (deleteMember(account, member)) {
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
	public boolean deleteMember(Account account, Member member) {
		accountRepository.save(account);

		memberRepository.save(member);
		memberRepository.delete(member);

		return memberDeletedCorrectly(member);
	}

	/**
	 * Method used to verify member deletion
	 *
	 * @param member The deleted member
	 * @return True on success
	 */
	public boolean memberDeletedCorrectly(Member member) {
		return memberRepository.findMemberById(member.getId()) == null;
	}
}
