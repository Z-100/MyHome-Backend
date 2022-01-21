package com.myhome.api.components.house.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.member.entity.Member;
import com.myhome.api.components.recipe.entity.Recipe;
import com.myhome.api.components.room.entity.Room;
import com.myhome.api.components.shoppinglist.entity.ShoppingList;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Table(name = "house")
@Entity
@Setter
@Getter
public class House {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "fkAccountId")
	@JsonManagedReference
	private Account fkAccountId;

	@OneToOne(mappedBy = "fkHouseId")
	@JsonManagedReference
	private ShoppingList shoppinglist;

	@OneToMany(
			cascade = {CascadeType.ALL},
			orphanRemoval = true,
			mappedBy = "fkHouseId")
	@JsonBackReference
	private List<Room> rooms;

	@OneToMany(
			cascade = {CascadeType.ALL},
			orphanRemoval = true,
			mappedBy = "fkHouseId")
	@JsonBackReference
	private Set<Recipe> recipes;
}