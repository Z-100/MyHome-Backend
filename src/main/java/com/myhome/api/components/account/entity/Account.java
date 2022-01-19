package com.myhome.api.components.account.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.myhome.api.components.house.entity.House;
import com.myhome.api.components.member.entity.Member;
import com.myhome.api.components.recipe.entity.Recipe;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Table(name = "account")
@Entity
@Data
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "token")
	private String token;

	@OneToMany(
			cascade = {CascadeType.ALL},
			orphanRemoval = true,
			mappedBy = "fkAccountId")
	@JsonBackReference
	private Set<Member> members;
}