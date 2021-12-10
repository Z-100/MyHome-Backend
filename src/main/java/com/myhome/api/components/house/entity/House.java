package com.myhome.api.components.house.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "account")
@Entity
@Data
public class House {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "fk_accountId")
	private Long fk_accountId;

	public House(String name, Long fk_accountId) {
		this.name = name;
		this.fk_accountId = fk_accountId;
	}

	public House() {
	}
}