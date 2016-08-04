package co.grandcircus.david.rest_demo;

import org.junit.Test;

import co.grandcircus.david.rest_demo.dao.DaoRegistry;
import co.grandcircus.david.rest_demo.dao.PersonDao;
import co.grandcircus.david.rest_demo.model.Person;

import static org.junit.Assert.*;

import java.util.List;

public class RestOperationsTest {
	
	private PersonDao personDao = DaoRegistry.getPersonDao();
	
	private static final Integer JAVA_COURSE_ID = 1;
	private static final Integer JAVASCRIPT_COURSE_ID = 2;
	
	@Test
	public void testCreateAndRead() {
		Person student = new Person();
		student.setName("Micky Mouse");
		student.setInstructor(false);
		student.setCourseId(JAVA_COURSE_ID);
		
		personDao.create(student);
		Integer id = student.getId();
		assertNotNull(id);
		
		student = personDao.get(id);
		assertEquals(id, student.getId());
		assertEquals("Micky Mouse", student.getName());
		assertEquals(false, student.isInstructor());
		assertEquals(JAVA_COURSE_ID, student.getCourseId());
	}
	
	@Test
	public void testUpdate() {
		Person student = new Person();
		student.setName("Grand Circus");
		student.setInstructor(false);
		student.setCourseId(JAVA_COURSE_ID);
		
		personDao.create(student);
		Integer id = student.getId();
		
		student.setName("Grant Chirpus");
		student.setCourseId(JAVASCRIPT_COURSE_ID);
		personDao.update(student);
		
		student = personDao.get(id);
		assertEquals(id, student.getId());
		assertEquals("Grant Chirpus", student.getName());
		assertEquals(false, student.isInstructor());
		assertEquals(JAVASCRIPT_COURSE_ID, student.getCourseId());
	}
	
	@Test
	public void testDelete() {
		Person student = new Person();
		student.setName("Mr. Short");
		student.setInstructor(false);
		student.setCourseId(JAVA_COURSE_ID);
		
		personDao.create(student);
		Integer id = student.getId();
	
		personDao.remove(id);
		
		student = personDao.get(id);
		assertNull(student);
	}
	
	@Test
	public void testList() {
		Person student = new Person();
		student.setName("Class Clown");
		student.setInstructor(true);
		student.setCourseId(JAVASCRIPT_COURSE_ID);
		personDao.create(student);
		Integer id = student.getId();
		
		List<Person> people = personDao.getAll();
		assertFalse(people.isEmpty());
		// find the student we created above
		student = people.stream().filter(person -> id.equals(person.getId())).findAny().get();
		assertEquals(id, student.getId());
		assertEquals("Class Clown", student.getName());
		assertEquals(true, student.isInstructor());
		assertEquals(JAVASCRIPT_COURSE_ID, student.getCourseId());
	}

}
