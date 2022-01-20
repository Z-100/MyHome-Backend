package com.myhome.api.components.shoppinglist.entity;

import com.myhome.api.components.house.entity.House;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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

	@Column(name = "fkHouseId")
	private Integer house;
}