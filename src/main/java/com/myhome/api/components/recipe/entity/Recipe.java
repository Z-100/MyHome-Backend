package com.myhome.api.components.recipe.entity;

import com.myhome.api.components.house.entity.House;
import com.myhome.api.components.member.entity.Member;
import lombok.Data;

import javax.persistence.*;
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
}