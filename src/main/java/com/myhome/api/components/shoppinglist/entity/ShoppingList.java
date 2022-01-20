package com.myhome.api.components.shoppinglist.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.myhome.api.components.house.entity.House;
import com.myhome.api.components.item.entity.Item;
import com.myhome.api.components.meal.entity.Meal;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Table(name = "shoppinglist")
@Entity
@Setter
@Getter
public class ShoppingList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "date")
	private Date date;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fkHouseId")
	@JsonBackReference
	private House fkHouseId;

	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name = "shoppinglistHasItem",
			joinColumns = @JoinColumn(name = "fkShoppingListId"),
			inverseJoinColumns = @JoinColumn(name = "fkItemId"))
	private List<Item> items;
}