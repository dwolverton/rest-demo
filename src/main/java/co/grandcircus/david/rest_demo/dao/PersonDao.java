package co.grandcircus.david.rest_demo.dao;

import java.util.List;

import co.grandcircus.david.rest_demo.model.Person;

public interface PersonDao {
	
	/**
	 * Get the person with the given ID.
	 * 
	 * @param id
	 * @return a Person or null if not found
	 */
	Person get(Integer id);
	
	/**
	 * Create a person. ID will be auto generated and filled in.
	 * 
	 * @param person
	 */
	void create(Person person);
	
	/**
	 * Update a person. ID must be specified. The ID determines which person will be updated
	 * 
	 * @param person
	 */
	void update(Person person);
	
	/**
	 * Delete a person
	 * 
	 * @param id
	 */
	void remove(Integer id);
	
	/**
	 * Get the list of all people.
	 * 
	 * @return a list, may be empty but never null.
	 */
	List<Person> getAll();

}
