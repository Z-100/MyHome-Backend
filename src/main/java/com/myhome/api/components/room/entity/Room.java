package com.myhome.api.components.room.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "room")
@Entity
@Data
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "icon")
	private Integer icon;
}