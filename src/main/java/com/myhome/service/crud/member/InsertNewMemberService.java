package com.myhome.service.crud.member;

import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.member.entity.Member;
import com.myhome.api.components.member.repository.IMemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Set;

/**
 * @author z-100
 * Class used to communicate between database and API
 */
@AllArgsConstructor
@Component
public class InsertNewMemberService {

	private final IMemberRepository memberRepository;
	private final IAccountRepository accountRepository;

	/**
	 * Method used to create nwe member
	 *
	 * @param email The accounts email
	 * @param icon The members icon
	 * @param name The members name
	 * @return True on success
	 */
	public boolean insert(String email, Integer icon, String name) {

		Member newMember = new Member();
		newMember.setName(name);
		newMember.setIcon(icon);
		newMember.setFkAccountId(accountRepository.findByEmail(email));
		newMember.setMeals(Set.of());
		newMember.setRatings(Set.of());

		return createNewTransaction(newMember);
	}

	/**
	 * Method used to open a transaction allowing for a possible
	 * rollback if something in the system fails
	 *
	 * @param newMember The to be saved member
	 */
	@Transactional
	public boolean createNewTransaction(Member newMember) {
		if (saveMemberToDatabase(newMember)) {
			return true;
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}

	/**
	 * Method used to actually save the member
	 *
	 * @param newMember The to be saved icon
	 * @return true on success
	 */
	public boolean saveMemberToDatabase(Member newMember) {
		memberRepository.save(newMember);

		return memberSavedCorrectly(newMember);
	}

	/**
	 * Method used to check if member was saved correctly
	 *
	 * @param newMember The saved member
	 * @return True on success
	 */
	public boolean memberSavedCorrectly(Member newMember) {
	 return memberRepository.findById(newMember.getId()).get().getName()
			 .equals(newMember.getName());
	}
}
