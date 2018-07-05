package ru.grusha.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import ru.grusha.staff.Department;
import ru.grusha.staff.Organization;
import ru.grusha.staff.Person;
import ru.grusha.wrappers.Departments;
import ru.grusha.wrappers.Organizations;
import ru.grusha.wrappers.People;

public class DbService {

	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:appDB;create=true";

	/**
	 * Метод, создающий БД и таблицы
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void createDB() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection connection = getConnection();
		
		// удаление таблиц
		deleteTableIfExists(connection, "PERSON");
		deleteTableIfExists(connection, "DEPARTMENT");
		deleteTableIfExists(connection, "Organization");
		
		// создание таблиц
		try {
			connection.createStatement().execute(
					"Create TABLE Person (id INT primary key, last_name varchar(20), first_name varchar(20), patronymic varchar(20), position varchar(30))");
			connection.createStatement().execute(
					"Create TABLE Department (id INT primary key, full_name varchar(50), short_name varchar(20), chief varchar(50), telephone varchar(20))");
			connection.createStatement().execute(
					"Create TABLE ORGANIZATION (id INT primary key, full_name long varchar, short_name varchar(20), chief varchar(50), telephone varchar(20))");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Таблицы не созданы" + e);
		}
	}

	/**
	 * Метод, записывающий набор объектов класса Персона в БД
	 * @param organizations класс, содержащий набор объектов класса Персона
	 * @param connection соединение с БД
	 * @throws SQLException
	 */
	public void insertPeople(People people, Connection connection) throws SQLException {
		ListIterator<Person> listIter = people.getEmployees().listIterator();
		while (listIter.hasNext()) {
			Person nextPerson = listIter.next();
			if (!idExists(nextPerson.getID(), "PERSON", connection)) {
				insertPerson(nextPerson, connection);
			}
		}
	}
	
	/**
	 * Метод, записывающий набор объектов класса Отдел в БД
	 * @param organizations класс, содержащий набор объектов класса Отдел
	 * @param connection соединение с БД
	 * @throws SQLException
	 */
	public void insertDepartments(Departments departments, Connection connection) throws SQLException {
		ListIterator<Department> listIter = departments.getListOfDepartments().listIterator();
		while (listIter.hasNext()) {
			Department nextDep = listIter.next();
			if (!idExists(nextDep.getID(), "DEPARTMENT", connection)) {
				insertDepartment(nextDep, connection);
			}
		}
	}
	
	/**
	 * Метод, записывающий набор объектов класса Организация в БД
	 * @param organizations класс, содержащий набор объектов класса Организация
	 * @param connection соединение с БД
	 * @throws SQLException
	 */
	public void insertOrganizations(Organizations organizations, Connection connection) throws SQLException {
		ListIterator<Organization> listIter = organizations.getListOfOrganizations().listIterator();
		while (listIter.hasNext()) {
			Organization nextOrg = listIter.next();
			if (!idExists(nextOrg.getID(), "ORGANIZATION", connection)) {
				insertOrganization(nextOrg, connection);
			}
		}
	}
	
	/**
	 * Метод, записывающий в БД объект класса персона
	 * @param organization объект класса персона
	 * @param connection соединение с БД
	 * @throws SQLException 
	 */
	private void insertPerson(Person person, Connection connection) throws SQLException {
		PreparedStatement insertPersonQuery = connection.prepareStatement("insert into Person values (?,?,?,?,?)");
		insertPersonQuery.setInt(1, person.getID());
		insertPersonQuery.setString(2,person.getLastName());
		insertPersonQuery.setString(3, person.getFirstName());
		insertPersonQuery.setString(4, person.getPatronymic());
		insertPersonQuery.setString(5, person.getPosition());
		insertPersonQuery.execute();
		insertPersonQuery.close();
	}
	
	/**
	 * Метод, записывающий в БД объект класса отдел
	 * @param organization объект класса отдел
	 * @param connection соединение с БД
	 * @throws SQLException 
	 */
	public void insertDepartment(Department department, Connection connection) throws SQLException {
		PreparedStatement insertDepartmentQuery = connection.prepareStatement("insert into Department values (?,?,?,?,?)");
		insertDepartmentQuery.setInt(1, department.getID());
		insertDepartmentQuery.setString(2, department.getFullName());
		insertDepartmentQuery.setString(3, department.getShortName());
		insertDepartmentQuery.setString(4, department.getChief());
		insertDepartmentQuery.setString(5, department.getTelephone());
		insertDepartmentQuery.execute();
		insertDepartmentQuery.close();
	}
	
	/**
	 * Метод, записывающий в БД объект класса организация
	 * @param organization объект класса организация
	 * @param connection соединение с БД
	 * @throws SQLException 
	 */
	public void insertOrganization(Organization organization, Connection connection) throws SQLException {
		PreparedStatement insertOrganizationQuery = connection
				.prepareStatement("insert into Organization values (?,?,?,?,?)");
		insertOrganizationQuery.setInt(1, organization.getID());
		insertOrganizationQuery.setString(2, organization.getFullName());
		insertOrganizationQuery.setString(3, organization.getShortName());
		insertOrganizationQuery.setString(4, organization.getChief());
		insertOrganizationQuery.setString(5, organization.getTelephone());
		insertOrganizationQuery.execute();
		insertOrganizationQuery.close();
	}

	/**
	 * Метод, осуществляющий подключение к БД
	 * @return соединение с БД
	 */
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(JDBC_URL);
		} catch (SQLException e) {
			System.out.println("Не удалось установить связь с базой данных");
		}
		return null;
	}

	/**
	 * Метод, проверяющий, есть ли в таблице оргштатная единица с таким же ID
	 * @param Id идентификационный номер оргштатной единицы
	 * @param tableName название таблицы, в которой хранятся оргштатные единицы
	 * @param connection
	 * @return истина, если элемент с таким ID уже имеется в таблице
	 * @throws SQLException
	 */
	private boolean idExists(int Id, String tableName, Connection connection) throws SQLException {
		List<Integer> listId = new ArrayList<>();
		try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + tableName);
			ResultSet result = preparedStatement.executeQuery()) {
			while (result.next()) {
				listId.add(result.getInt("id"));
			}
		}
		for (int id : listId) {
			if (id == Id) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Метод, удаляющий таблицу, если она существует
	 * @param connection 
	 * @param tableName название таблицы, которую требуется удалить
	 */
	private void deleteTableIfExists(Connection connection, String tableName) {		
		try {
			connection.createStatement().executeUpdate("DROP TABLE " + tableName);
		} catch (SQLException e) {
			if (!e.getSQLState().equals("42Y55"))// таблицы не существует
				e.printStackTrace();
		}

	}

}
