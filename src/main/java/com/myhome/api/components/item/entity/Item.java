package com.myhome.api.components.item.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Table(name = "item")
@Entity
@Data
@EqualsAndHashCode(of = "id")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "item", cascade = {CascadeType.ALL})
//	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<ItemsInRoom> itemsInRoom;
}