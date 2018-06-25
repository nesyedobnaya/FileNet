package ru.grusha.storage;

import ru.grusha.model.Departments;
import ru.grusha.model.Organizations;
import ru.grusha.model.People;

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
}
