package com.myhome.api.components.rating.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.myhome.api.components.member.entity.Member;
import com.myhome.api.components.recipe.entity.Recipe;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "rating")
@Entity
@Getter
@Setter
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "rating")
	private Integer rating;

	@ManyToOne
	@JoinColumn(name = "fkMemberId", nullable = false)
	@JsonManagedReference
	private Member fkMemberId;

	@ManyToOne
	@JoinColumn(name = "fkRecipeId", nullable = false)
	@JsonManagedReference
	private Recipe fkRecipeId;
}