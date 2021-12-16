package com.myhome.api.components.room.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.myhome.api.components.cleaning.entity.Cleaning;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

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

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "rooms_to_be_cleaned",
			joinColumns = @JoinColumn(name = "fk_roomId"),
			inverseJoinColumns = @JoinColumn(name = "fk_cleaningId"))
	private Set<Cleaning> cleanings;
}