package com.myhome.api.components.member.controller;

import com.myhome.api.components.member.dto.MemberDTO;
import com.myhome.other.replacement.JsonBoolean;
import com.myhome.api.services.crud.member.DeleteExistingMemberService;
import com.myhome.api.services.crud.member.InsertNewMemberService;
import com.myhome.api.services.crud.member.ReadExistingMemberService;
import com.myhome.api.services.crud.member.UpdateExistingMemberService;
import com.myhome.service.validation.impl.TokenValidationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author z-100
 * Class used to handle I/O communication of the API
 */
@RestController
@RequestMapping("/member")
@AllArgsConstructor
public class MemberController {

	private final TokenValidationService tokenValidation;

	private final ReadExistingMemberService readMember;
	private final InsertNewMemberService insertMember;
	private final DeleteExistingMemberService deleteMember;
	private final UpdateExistingMemberService updateMember;

	/**
	 * Method used to get all members from database (only members)
	 *
	 * @param email The accounts email (validation and account)
	 * @param token The accounts specific token to validate the request
	 * @return Iterable of all members belonging to said account
	 */
	@GetMapping("/get-member")
	public Iterable<MemberDTO> getSpecificMembersFromAccount(
			@RequestHeader("email") String email,
			@RequestHeader("token") String token) {

		return tokenValidation.validate(email, token) ?
				readMember.getAllMembers(email) : null;
	}


	/**
	 * Method used to insert a new member from the database
	 *
	 * @param email The accounts email
	 * @param token The accounts token
	 * @param icon The new icon of the member
	 * @param name The new name of the member
	 * @return True on successful insertion
	 */
	@GetMapping("/insert-member")
	public JsonBoolean insertNewMemberIntoAccount(
			@RequestHeader("email") String email,
			@RequestHeader("token") String token,
			@RequestHeader("icon") String icon,
			@RequestHeader("name") String name) {

		return tokenValidation.validate(email, token) && insertMember.insert(email,Integer.parseInt(icon), name) ?
				new JsonBoolean(true) : new JsonBoolean(false);
	}

	/**
	 * Method used to delete a specific member from the database
	 *
	 * @param email The accounts email
	 * @param token The accounts token
	 * @param memberId The to be deleted member
	 * @return True on successful removal
	 */
	@GetMapping("/delete-member")
	public JsonBoolean deleteSpecificMemberFromAccount(
			@RequestHeader("email") String email,
			@RequestHeader("token") String token,
			@RequestHeader("member-id") String memberId) {

		return tokenValidation.validate(email, token) && deleteMember.delete(Long.parseLong(memberId)) ?
				new JsonBoolean(true) : new JsonBoolean(false);
	}

	/**
	 * Method used to update a specific member
	 *
	 * @param email The accounts email
	 * @param token The accounts token
	 * @param memberId The member to be updated
	 * @param replacementIcon The to be replaced icon
	 * @param replacementName The to be replaced name
	 * @return True on successful update
	 */
	@GetMapping("/update-member")
	public JsonBoolean updateSpecificMemberInAccount(
			@RequestHeader("email") String email,
			@RequestHeader("token") String token,
			@RequestHeader("member-id") String memberId,
			@RequestHeader("replacement-icon") String replacementIcon,
			@RequestHeader("replacement-name") String replacementName) {

		return tokenValidation.validate(email, token) && updateMember.update(Long.parseLong(memberId), Integer.parseInt(replacementIcon), replacementName) ?
				new JsonBoolean(true) : new JsonBoolean(false);
	}
}
