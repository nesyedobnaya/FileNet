package ru.grusha.utils;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * @author nesyedobnaya
 * класс, содержащий утилиты для заполнения полей документов
 */
public class FactoryUtil {
	
	/**
	 * список имен для заполнения полей документов
	 */
	public static String[] people = {"Иванов И.И.", "Петров Г.О.", "Новикова Е.А.", 
			"Афанасьева И.Б.", "Шляпкин В.И."};
	
	/**
	 * список возможных типов доставки для заполнения поля "Способ доставки"
	 */
	public static String[] delivery = {"Курьер", "Факс", "Электронная почта"};

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
	public static String randomPerson(){
		return (people[new Random().nextInt(people.length)]);
	}
		
	/**
	 * 
	 * @param daysBack число дней назад
	 * @return генерация случайной даты
	 */
	public static Date getRandomDate(int daysBack) {
		return new Date(System.currentTimeMillis() - ThreadLocalRandom.current().nextLong(1000*60*60*24*daysBack));
	}
}
