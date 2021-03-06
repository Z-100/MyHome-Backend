package com.myhome.api.components.recipe.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.house.entity.House;
import com.myhome.api.components.item.entity.Item;
import com.myhome.api.components.member.entity.Member;
import com.myhome.api.components.rating.entity.Rating;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Table(name = "recipe")
@Entity
@Data
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "forAmountOfPeople")
	private String forAmountOfPeople;

	@ManyToOne
	@JoinColumn(name = "fkHouseId", nullable = false)
	@JsonManagedReference
	private Account fkHouseId;

	@OneToMany(
			cascade = {CascadeType.ALL},
			orphanRemoval = true,
			mappedBy = "fkRecipeId")
	@JsonBackReference
	private Set<Rating> ratings;

	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name = "recipehasitem",
			joinColumns = @JoinColumn(name = "fkRecipeId"),
			inverseJoinColumns = @JoinColumn(name = "fkItemId"))
	private List<Item> items;
}