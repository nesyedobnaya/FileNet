package ru.grusha.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtil {
	
	public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");//формат вывода даты
	
	public static String formatDate(Date dateToFormat){
		return dateFormat.format(dateToFormat);
	}

}
