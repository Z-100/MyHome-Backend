package com.myhome.api.components.member.entity;

import com.myhome.api.components.meal.entity.Meal;
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

	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "fk_memberId")
	private Set<Meal> meals;
}