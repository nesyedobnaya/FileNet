package ru.grusha.storage;

import java.util.TreeSet;

import ru.grusha.exeption.DocumentExistsExeption;
import ru.grusha.model.Document;

public class DocumentStorage {
 
	public static TreeSet<Document> data = new TreeSet<Document>();
		
	//проверка совпадения регистрационного номера с другими документами набора	 
	public static void check(TreeSet<Document> tree, int registrationNumber) throws DocumentExistsExeption{
		for (Document documentFromTree: tree) {        
			if (registrationNumber==documentFromTree.getRegistrationNumber())  {         	
				throw new DocumentExistsExeption("Документ с таким регистрационным номером уже существует");        
			}		
		}
	}
}
