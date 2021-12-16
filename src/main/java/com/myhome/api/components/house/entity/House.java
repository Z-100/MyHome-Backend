package com.myhome.api.components.house.entity;

import com.myhome.api.components.room.entity.Room;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

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

	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "fk_houseId")
	private List<Room> rooms;

	public House(String name) {
		this.name = name;
	}

	public House() {
	}
}