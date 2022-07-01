//package com.myhome.api.components.house.controller;
//
//import com.myhome.api.components.house.dto.HouseDTO;
//import com.myhome.api.components.house.service.crud.DeleteExistingHouseService;
//import com.myhome.api.components.house.service.crud.InsertNewHouseService;
//import com.myhome.api.components.house.service.crud.ReadExistingHouseService;
//import com.myhome.api.components.house.service.crud.UpdateExistingHouseService;
//import lombok.AllArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/house")
//@AllArgsConstructor
//public class HouseController {
//
//	private final ReadExistingHouseService readHouse;
//	private final InsertNewHouseService insertHouse;
//	private final DeleteExistingHouseService deleteHouse;
//	private final UpdateExistingHouseService updateHouse;
//
//	@GetMapping("/get-house")
//	public List<HouseDTO> getSpecificMembersFromAccount(
//			@RequestHeader("email") String email,
//			@RequestHeader("token") String token) {
//
//		return tokenValidation.validate(email, token) ?
//				readHouse.getHouses(email) : null;
//	}
//
//	/**
//	 * Method used to insert a new house into the database
//	 *
//	 * @param email The accounts email
//	 * @param token The accounts token
//	 * @param name The new name of the house
//	 * @return True on successful insertion
//	 */
//	@GetMapping("/insert-member")
//	public JsonBoolean insertNewHouseIntoAccount(
//			@RequestHeader("email") String email,
//			@RequestHeader("token") String token,
//			@RequestHeader("name") String name) {
//
//		return tokenValidation.validate(email, token) && insertHouse.insert(email, name) ?
//				new JsonBoolean(true) : new JsonBoolean(false);
//	}
//
//	/**
//	 * Method used to delete a specific house from the database
//	 *
//	 * @param email The accounts email
//	 * @param token The accounts token
//	 * @param houseId The to be deleted house
//	 * @return True on successful removal
//	 */
////	@GetMapping("")
//	@Deprecated
//	public JsonBoolean deleteSpecificHouseFromAccount(
//			@RequestHeader("email") String email,
//			@RequestHeader("token") String token,
//			@RequestHeader("house-id") String houseId) {
//
//		return tokenValidation.validate(email, token) && deleteHouse.delete(Long.parseLong(houseId)) ?
//				new JsonBoolean(true) : new JsonBoolean(false);
//	}
//
//	/**
//	 * Method used to update a specific member
//	 *
//	 * @param email The accounts email
//	 * @param token The accounts token
//	 * @param newName The houses new name
//	 * @return True on successful update
//	 */
//	@GetMapping("/update-member")
//	public JsonBoolean updateSpecificMemberInAccount(
//			@RequestHeader("email") String email,
//			@RequestHeader("token") String token,
//			@RequestHeader("new-name") String newName) {
//
//		return tokenValidation.validate(email, token) && updateHouse.update(email, newName) ?
//				new JsonBoolean(true) : new JsonBoolean(false);
//	}
//}
