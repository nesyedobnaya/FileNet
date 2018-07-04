package ru.grusha.dbservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ListIterator;

import ru.grusha.staff.Department;
import ru.grusha.staff.Organization;
import ru.grusha.staff.Person;
import ru.grusha.wrappers.Departments;
import ru.grusha.wrappers.Organizations;
import ru.grusha.wrappers.People;

public class DbCreator {

	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:appDB;create=true";

	public void createDB() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection connection = getConnection(JDBC_URL);
		
		//удаление таблиц
		try {
			connection.createStatement().executeUpdate("DROP TABLE PERSON");
			//connection.createStatement().executeUpdate("DROP TABLE DEPARTMENT");
			//connection.createStatement().executeUpdate("DROP TABLE ORGANIZATION");
		} catch (SQLException e) {
			if (!e.getSQLState().equals("42Y55"))//таблицы не существует
				e.printStackTrace();
		}
		
		//создание таблиц 
		try {
			connection.createStatement().execute(
					"Create TABLE Person (id INT primary key, last_name varchar(20), first_name varchar(20), patronymic varchar(20), position varchar(30))");
			connection.createStatement().execute(
					"Create TABLE Department (id INT primary key, full_name varchar(50), short_name varchar(20), chief varchar(50), telephone varchar(20))");
			connection.createStatement().execute(
					"Create TABLE Organization (id INT primary key, full_name varchar(50), short_name varchar(20), chief varchar(50), telephone varchar(20))");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Создаваемая таблица уже существует"+e);
		}
	}

	public void insertPeople(People people) throws SQLException {
		Connection connection = getConnection(JDBC_URL);
		ListIterator<Person> listIter = people.getEmployees().listIterator();
		while (listIter.hasNext()) {
			Person nextPerson = listIter.next();
			PreparedStatement insertPerson = connection.prepareStatement("insert into Person values (?,?,?,?,?)");
			insertPerson.setInt(1, nextPerson.getID());
			insertPerson.setString(2, nextPerson.getLastName());
			insertPerson.setString(3, nextPerson.getFirstName());
			insertPerson.setString(4, nextPerson.getPatronymic());
			insertPerson.setString(5, nextPerson.getPosition());
			insertPerson.execute();
		}
	}
	
	public void insertDepartments(Departments departments) throws SQLException {
		Connection connection = getConnection(JDBC_URL);
		ListIterator<Department> listIter = departments.getListOfDepartments().listIterator();
		while (listIter.hasNext()) {
			Department nextDep = listIter.next();
			PreparedStatement insertDepartment = connection.prepareStatement("insert into Department values (?,?,?,?,?)");
			insertDepartment.setInt(1, nextDep.getID());
			insertDepartment.setString(2, nextDep.getFullName());
			insertDepartment.setString(3, nextDep.getShortName());
			insertDepartment.setString(4, nextDep.getChief());
			insertDepartment.setString(5, nextDep.getTelephone());
			insertDepartment.execute();
		}
	}
	
	public void insertOrganizations(Organizations organizations) throws SQLException {
		Connection connection = getConnection(JDBC_URL);
		ListIterator<Organization> listIter = organizations.getListOfOrganizations().listIterator();
		while (listIter.hasNext()) {
			Organization nextOrg = listIter.next();
			PreparedStatement insertOrganization = connection.prepareStatement("insert into Organization values (?,?,?,?,?)");
			insertOrganization.setInt(1, nextOrg.getID());
			insertOrganization.setString(2, nextOrg.getFullName());
			insertOrganization.setString(3, nextOrg.getShortName());
			insertOrganization.setString(4, nextOrg.getChief());
			insertOrganization.setString(5,nextOrg.getTelephone());
			insertOrganization.execute();
		}
	}
	
	public Connection getConnection(String JdbcURL) {
		try {
			return DriverManager.getConnection(JdbcURL);
		} catch (SQLException e) {
			System.out.println("Не удалось установить связь с базой данных");
		}
		return null;
	}
}
