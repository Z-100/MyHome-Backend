package com.myhome.api.components.item.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "recipeHasItem")
@Entity
@Setter
@Getter
public class RecipeHasItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "amount")
	private Integer amount;

	@Column(name = "fkRecipeId")
	private Integer fkRecipeId;

	@Column(name = "fkItemId")
	private Integer fkItemId;

}
