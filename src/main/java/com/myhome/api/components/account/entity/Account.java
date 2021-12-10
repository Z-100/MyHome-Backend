package com.myhome.api.components.account.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Table(name = "account")
@Entity
@Data
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	public Account(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public Account() {
	}
}