package com.myhome.api.components.cleaning.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.myhome.api.components.room.entity.Room;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Table(name = "cleaning")
@Entity
@Data
public class Cleaning {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "cleaning_time")
	private Date cleaning_time;

//	@ManyToMany(mappedBy = "cleanings")
//	private Set<Room> rooms;
}