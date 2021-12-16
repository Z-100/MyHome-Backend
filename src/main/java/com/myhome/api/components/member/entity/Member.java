package com.myhome.api.components.member.entity;

import lombok.Data;

import javax.persistence.*;

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
}