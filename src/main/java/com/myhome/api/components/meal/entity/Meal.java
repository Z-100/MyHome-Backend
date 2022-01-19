package com.myhome.api.components.meal.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.myhome.api.components.member.entity.Member;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "meal")
@Entity
@Data
public class Meal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "mealDate")
	private Date meal_date;

	@Column(name = "type")
	private String type;

	@ManyToOne
	@JoinColumn(name = "fkMemberId", nullable = false)
	@JsonManagedReference
	private Member fkMemberId;
}