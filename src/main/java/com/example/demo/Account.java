package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id = 0;
	private String name = "Hans";
	private String pw = "Peter";

	@Override
	public String toString() {
		return "Account{" + "id=" + id + ", name='" + name + '\'' + ", pw='" + pw + '\'' + '}';
	}
}