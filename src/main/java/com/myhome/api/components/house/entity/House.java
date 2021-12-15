package com.myhome.api.components.house.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "house")
@Entity
@Data
public class House {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	public House(String name) {
		this.name = name;
	}

	public House() {
	}
}