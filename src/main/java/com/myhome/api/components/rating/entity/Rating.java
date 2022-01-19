package com.myhome.api.components.rating.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.myhome.api.components.member.entity.Member;
import lombok.Data;

import javax.persistence.*;

@Table(name = "rating")
@Entity
@Data
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
	private Member fkRecipeId;
}