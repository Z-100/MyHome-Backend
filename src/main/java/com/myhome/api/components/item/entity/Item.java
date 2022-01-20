package com.myhome.api.components.item.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.shoppinglist.entity.ShoppingList;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Table(name = "item")
@Entity
@Setter
@Getter
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name")
	private String name;
}