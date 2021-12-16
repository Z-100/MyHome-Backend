package com.myhome.api.components.cleaning.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "cleaning")
@Entity
@Data
public class Cleaning {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "cleaning_time")
	private Date cleaning_time;
}