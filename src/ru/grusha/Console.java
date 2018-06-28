package ru.grusha;

import java.util.TreeSet;

import ru.grusha.exeption.DocumentExistsExeption;
import ru.grusha.factory.Generator;
import ru.grusha.model.Document;
import ru.grusha.storage.DocumentStorage;
import ru.grusha.utils.DocType;

/**
 * 
 * @author nesyedobnaya
 * класс для создания документов различных типов и вывода в консоль отчета о созданных документах
 */
public class Console {

	public static void main(String[] args) {

		Generator generator = new Generator();
		
		for (DocType type : DocType.values()) { 
			try {
				Document newDocument=generator.createDocument(type);
				//System.out.println(newDocument.toString());//вывод полей документа в консоль для проверки
			}catch(DocumentExistsExeption ex){
				System.out.println(ex.getMessage());	
			}
		}		
        
		//создание набора авторов
		TreeSet<String> setOfAuthors = new TreeSet<String>();                 
		for (Document document: DocumentStorage.data) {        	
			setOfAuthors.add(document.getAuthor());        	
		}
                
		//вывод отчета (перечень авторов и список созданных ими документов, отсортированных по дате регистрации и регистрационному номеру)
		for (String authorFromSet: setOfAuthors) {
			System.out.println(" - "+authorFromSet);        	        	
			for (Document documentFromStorage: DocumentStorage.data) {
				if (authorFromSet.equals(documentFromStorage.getAuthor())) {
					System.out.println("\t- "+documentFromStorage.print());
        			}        		
        		}
		}        
	}
}
	

