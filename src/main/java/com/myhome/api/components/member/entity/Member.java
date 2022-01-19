package com.myhome.api.components.member.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.meal.entity.Meal;
import com.myhome.api.components.rating.entity.Rating;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Table(name = "member")
@Entity
@Data
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "icon")
	private Integer icon;

	@ManyToOne
	@JoinColumn(name = "fkAccountId", nullable = false)
	@JsonManagedReference // ? Work around for StackOverflow
	private Account fkAccountId;

	@OneToMany(
			cascade = {CascadeType.ALL},
			orphanRemoval = true,
			mappedBy = "fkMemberId")
	@JsonBackReference
	private Set<Meal> meals;

	@OneToMany(
			cascade = {CascadeType.ALL},
			orphanRemoval = true,
			mappedBy = "fkMemberId")
	@JsonBackReference
	private Set<Rating> ratings;
}