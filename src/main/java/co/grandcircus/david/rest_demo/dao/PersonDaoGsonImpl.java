package co.grandcircus.david.rest_demo.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import co.grandcircus.david.rest_demo.model.Person;

public class PersonDaoGsonImpl implements PersonDao {
	
	private String serverUrl = "http://localhost:3000";

	public Person get(Integer id) {
		String url = serverUrl + "/people/" + id;
		try (BufferedReader reader = HttpHelper.doGet(url)) {
			if (reader == null) {
				return null;
			}
			JsonElement root = new JsonParser().parse(reader);
			JsonObject personJson = root.getAsJsonObject();
			return toPerson(personJson);
		} catch (IOException ex) {
			throw new RuntimeException("Error reading from URL: " + url, ex);
		}
	}

	public void create(Person person) {
		String url = serverUrl + "/people";
		JsonObject personJson = toJson(person);
		
		try (BufferedReader reader = HttpHelper.doPost(url, personJson.toString())) {
			JsonElement root = new JsonParser().parse(reader);
			JsonObject responsePersonJson = root.getAsJsonObject();
			Integer id = responsePersonJson.get("id").getAsInt();
			person.setId(id);
		} catch (IOException ex) {
			throw new RuntimeException("Error reading from URL: " + url, ex);
		}
	}

	public void update(Person person) {
		String url = serverUrl + "/people/" + person.getId();
		JsonObject personJson = toJson(person);
	
		HttpHelper.doPut(url, personJson.toString());
	}
	
	@Override
	public List<Person> getAll() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	public void remove(Integer id) {
		String url = serverUrl + "/people/" + id;
		HttpHelper.doDelete(url);
	}
	
	private Person toPerson(JsonObject personJson) {
		Person person = new Person();
		person.setId(personJson.get("id").getAsInt());
		person.setName(personJson.get("name").getAsString());
		person.setInstructor(personJson.get("instructor").getAsBoolean());
		person.setCourseId(personJson.get("courseId").getAsInt());
		return person;
	}
	
	private JsonObject toJson(Person person) {
		JsonObject personJson = new JsonObject();
		personJson.addProperty("id", person.getId());
		personJson.addProperty("name", person.getName());
		personJson.addProperty("instructor", person.isInstructor());
		personJson.addProperty("courseId", person.getCourseId());
		return personJson;
	}

}
