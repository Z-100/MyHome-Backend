package com.myhome.api.components.account.entity;

import com.myhome.api.components.house.entity.House;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

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

	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "fk_accountId")
	private List<House> houses;

	public Account(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public Account() {
	}
}