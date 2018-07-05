package ru.grusha.utils;

import java.io.File;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import ru.grusha.service.DbService;
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
	}
	
	/**
	 * Метод, осуществляющий сохранение оргштатных единиц в базе данных
	 */
	public static void saveStaffInDB() {
		DbService dbService = new DbService();
		try {
			dbService.createDB();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dbService.insertPeople(FactoryUtil.loadedPeople);
			dbService.insertDepartments(FactoryUtil.loadedDepartments);
			dbService.insertOrganizations(FactoryUtil.loadedOrganizations);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
