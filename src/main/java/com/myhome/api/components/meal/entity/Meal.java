package com.myhome.api.components.meal.entity;

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

	@Column(name = "meal_date")
	private Date meal_date;

	@Column(name = "type")
	private String type;
}