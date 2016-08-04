package co.grandcircus.david.rest_demo;

import org.junit.Test;

import co.grandcircus.david.rest_demo.dao.DaoRegistry;
import co.grandcircus.david.rest_demo.dao.PersonDao;
import co.grandcircus.david.rest_demo.model.Course;
import co.grandcircus.david.rest_demo.model.Person;

public class RestOperationsTest {
	
	private PersonDao personDao = DaoRegistry.getPersonDao();
	
	@Test
	public void testAllTheOperations() {
		Course javaCourse = new Course();
		javaCourse.setId(1);
		
		Person student = new Person();
		student.setName("Micky Mouse");
		student.setInstructor(false);
		student.setCourseId(javaCourse.getId());
		
		personDao.create(student);
		System.out.println("Added: " + student);
		
		student.setName("Micky Mouse (TM)");
		personDao.update(student);
		System.out.println("Updated: " + student);
		
		student = personDao.get(student.getId());
		System.out.println("Fetched: " + student);
		
		System.out.println("All people...");
		for (Person person : personDao.getAll()) {
			System.out.println(person);
		}
		
		personDao.remove(student.getId());
		System.out.println("Deleted: " + student);
		
	}

}
