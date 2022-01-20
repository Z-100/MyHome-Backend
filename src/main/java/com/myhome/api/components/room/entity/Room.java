package com.myhome.api.components.room.entity;

import com.myhome.api.components.cleaning.entity.Cleaning;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Table(name = "room")
@Entity
@Data
@EqualsAndHashCode(of = "id")
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
	@JoinTable(name = "rooms_to_be_cleaned",
			joinColumns = @JoinColumn(name = "fk_roomId"),
			inverseJoinColumns = @JoinColumn(name = "fk_cleaningId"))
	private Set<Cleaning> cleanings;
}