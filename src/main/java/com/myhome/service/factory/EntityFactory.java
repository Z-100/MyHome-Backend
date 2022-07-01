package com.myhome.service.factory;

import org.hibernate.sql.ordering.antlr.Factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Z-100
 * A generic solution for a Factory. Can generate all kinds of classes with the parameters T & E
 *
 * @param <T> A reference to the to-be-instanced class
 * @param <E> Any parameters, which are needed by the classes constructor
 */
public class EntityFactory <T, E> extends Factory {

	/**
	 * Returns any type of Object
	 *
	 * @param <T> Type of Object
	 * @return Instance of type T
	 */
	public static <T> T getInstance(Class<T> obj) {
		try {
			return obj.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	/**
	 * Returns list instance of type T
	 *
	 * @param <T> Type of list
	 * @return List instance of type T
	 */
	public static <T> List<T> getListInstance(Class<T> t) {
		try {
			return new ArrayList<T>();
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	/**
	 * Returns any collection of type T
	 * @param t To be used type
	 * @param <T> To be instantiated Collection
	 * @param <E> Type of collection
	 * @return Instantiated Collection T of type E
	 */
	public static <T extends Collection<?>, E> T getInstance(Class<T> t, Class<E> args) {
		try {
			return t.getDeclaredConstructor(args).newInstance(args);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException();
		}
	}
}
