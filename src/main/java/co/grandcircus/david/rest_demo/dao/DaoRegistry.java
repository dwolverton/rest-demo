package co.grandcircus.david.rest_demo.dao;

public class DaoRegistry {

	private static PersonDao personDaoSingleton;
	
	public static PersonDao getPersonDao() {
		if (personDaoSingleton == null) {
			personDaoSingleton = new PersonDaoGsonImpl();
		}
		return personDaoSingleton;
	}
}
