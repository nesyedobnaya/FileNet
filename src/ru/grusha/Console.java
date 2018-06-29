package ru.grusha;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import ru.grusha.exeption.DocumentExistsExeption;
import ru.grusha.factory.Generator;
import ru.grusha.model.Document;
import ru.grusha.staff.Person;
import ru.grusha.storage.DocumentStorage;
import ru.grusha.utils.DocumentType;
import ru.grusha.utils.FactoryUtil;
import ru.grusha.utils.JsonFileWriter;
/**
 * 
 * @author nesyedobnaya
 * класс для создания документов различных типов и вывода в консоль и в JSON файл отчета о созданных документах
 */
public class Console {

	public static void main(String[] args) {

		Generator generator = new Generator();
		JsonFileWriter jsonWriter = new JsonFileWriter();
		FactoryUtil.loadStaff();
		
		for (DocumentType type : DocumentType.values()) { 
			try {
				Document newDocument=generator.createDocument(type);
				//System.out.println(newDocument.toString());//вывод полей документа в консоль для проверки
			}catch(DocumentExistsExeption ex){
				System.out.println(ex.getMessage());	
			}
		}		
        
		//создание набора авторов
		TreeSet<Person> setOfAuthors = new TreeSet<Person>();                 
		for (Document document: DocumentStorage.data) {        	
			setOfAuthors.add(document.getAuthor());        	
		}
                
		//вывод отчета (перечень авторов и список созданных ими документов, отсортированных по дате регистрации и регистрационному номеру)
		for (Person authorFromSet: setOfAuthors) {
			List<Document> documentsOfAuthor = new ArrayList<Document>();
			System.out.println(" - "+authorFromSet.getFullName()); //вывод полного имени автора документа         	        	
			for (Document documentFromStorage: DocumentStorage.data) {
				if (authorFromSet.equals(documentFromStorage.getAuthor())) {
					System.out.println("\t- "+documentFromStorage.print());
					documentsOfAuthor.add(documentFromStorage);
		        }        		
			}
		jsonWriter.reportToAFile(authorFromSet, documentsOfAuthor);
		}         
	}
}
	

