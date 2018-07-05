package ru.grusha.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import ru.grusha.dbservice.DbCreator;
import ru.grusha.staff.Person;
import ru.grusha.wrappers.Departments;
import ru.grusha.wrappers.Organizations;
import ru.grusha.wrappers.People;

/**
 * 
 * @author nesyedobnaya
 * класс, содержащий утилиты для заполнения полей документов
 */
public class FactoryUtil {
	
	/**
	 * классы, содержащие наборы оргштатных единиц
	 */

	public static People loadedPeople=new People(); 
	public static Departments loadedDepartments=new Departments();
	public static Organizations loadedOrganizations=new Organizations();
	
	/**
	 * список возможных типов доставки для заполнения поля "Способ доставки"
	 */
	public static final String[] DELIVERY = {"Курьер", "Факс", "Электронная почта"};

	/**
	 * генерация n-значного числа
	 * @param digits - число знаков
	 * @return число с заданным кол-вом знаков
	 */
	public static int createRandomInteger(int digits){
		return (int)(Math.random()*Math.pow(10,digits));			
	}
     
	/**
	 * @return случайная персона из списка
	 */

	public static Person randomPerson(){
		return loadedPeople.getEmployees().get(new Random().nextInt(loadedPeople.getEmployees().size()));
	}
		
	/**
	 * 
	 * @param daysBack число дней назад
	 * @return генерация случайной даты
	 */
	public static Date getRandomDate(int daysBack) {
		return new Date(System.currentTimeMillis() - ThreadLocalRandom.current().nextLong(1000*60*60*24*daysBack));
	}
	
	/**
	 * Метод, осуществляющий загрузку оргштатных единиц из xml файлов 
	 */
	public static void loadStaff() {
		
		File filePeople = new File("D://XML/People2.xml");
		File fileOrganizations = new File("D://XML/Organizations2.xml");	 	    
		File fileDepartments = new File("D://XML/Departments2.xml");
		
		//загрузка из файлов	    
		loadedPeople=(People)JaxbParser.unMarshal(filePeople, People.class);				
			
		loadedDepartments=(Departments)JaxbParser.unMarshal(fileDepartments, Departments.class);	        
			
		loadedOrganizations=(Organizations)JaxbParser.unMarshal(fileOrganizations, Organizations.class); 
		
		DbCreator dbCreator = new DbCreator();
		try {
			dbCreator.createDB();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dbCreator.insertPeople(FactoryUtil.loadedPeople);
			dbCreator.insertDepartments(FactoryUtil.loadedDepartments);
			dbCreator.insertOrganizations(FactoryUtil.loadedOrganizations);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection connection = dbCreator.getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet =statement.executeQuery("select * from Person");;
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			for (int x=1; x<=resultSetMetaData.getColumnCount();x++) System.out.format("%30s", resultSetMetaData.getColumnName(x)+ " | ");
			while (resultSet.next()){
				System.out.println();
				for (int x=1;x<=resultSetMetaData.getColumnCount();x++) System.out.format("%30s", resultSet.getString(x) + " | ");
			}
				
			ResultSet resultSet2 = statement.executeQuery("select * from Department");;
			ResultSetMetaData resultSetMetaData2 = resultSet2.getMetaData();
			for (int x=1; x<=resultSetMetaData2.getColumnCount();x++) System.out.format("%30s", resultSetMetaData2.getColumnName(x)+ " | ");
			while (resultSet2.next()){
				System.out.println();
				for (int x=1;x<=resultSetMetaData2.getColumnCount();x++) System.out.format("%30s", resultSet2.getString(x) + " | ");
			}
			
			ResultSet resultSet3 = statement.executeQuery("select * from Organization");;
			ResultSetMetaData resultSetMetaData3 = resultSet3.getMetaData();
			for (int x=1; x<=resultSetMetaData3.getColumnCount();x++) System.out.format("%30s", resultSetMetaData3.getColumnName(x)+ " | ");
			while (resultSet3.next()){
				System.out.println();
				for (int x=1;x<=resultSetMetaData3.getColumnCount();x++) System.out.format("%30s", resultSet3.getString(x) + " | ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
