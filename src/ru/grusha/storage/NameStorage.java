package ru.grusha.storage;

import java.io.File;

import ru.grusha.staff.Departments;
import ru.grusha.staff.Organizations;
import ru.grusha.staff.People;

public class NameStorage {
	
	public static String[] author = {"Иванов И.И.", "Петров Г.О.", "Новикова Е.А.", 
			"Афанасьева И.Б.", "Шляпкин В.И."};
	
	public static String[] sender = {"Некрасов В.Г.", "Сидоров А.А.", "Кондратьев Е.Н.", 
			"Коршунов И.Б.", "Львов В.И."};
	
	public static String[] addressee = {"Калинин В.Г.", "Вагапов А.А.", "Федорова Е.Н.", 
			"Соловьева И.Б.", "Смит Дж.И."};
	
	public static String[] executor = {"Павлов Н.В.", "Степанова А.Р.", "Елисеев Е.А.", 
			"Григорьев А.Р.", "Елисеева Н.Л."};
	
	public static String[] controller = {"Антонов Н.В.", "Пелевин А.Р.", "Зощенко Е.А.", 
			"Керн А.Р.", "Шевчук Н.Л."};
	
	public static People loadedPeople=new People(); 
	public static Departments loadedDepartments=new Departments();
	public static Organizations loadedOrganizations=new Organizations();	
	
	public static String[] delivery = {"Курьер", "Факс", "Электронная почта"};
	
	public static String[] controleAttribute = {"Выдано", "В процессе", "Исполнено"};
	
	public static void loadStaff() {
		
		File filePeople = new File("D://XML/People.xml");
		File fileOrganizations = new File("D://XML/Organizations.xml");	 	    
		File fileDepartments = new File("D://XML/Departments.xml");
		
		//загрузка из файлов	    
		loadedPeople=(People)JaxbParser.unMarshaling(filePeople, People.class);		
		//System.out.println(loadedPeople.list.toString()); 			
			
		loadedDepartments=(Departments)JaxbParser.unMarshaling(fileDepartments, Departments.class);	        
		//System.out.println(loadedDepartments.list.toString()); 
			
		loadedOrganizations=(Organizations)JaxbParser.unMarshaling(fileOrganizations, Organizations.class);       
		//System.out.println(loadedOrganizations.list.toString());
	}
}
