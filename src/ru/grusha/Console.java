package ru.grusha;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import ru.grusha.exeption.DocumentExistsExeption;
import ru.grusha.factory.Factory;
import ru.grusha.factory.FactoryUtil;
import ru.grusha.model.Document;
import ru.grusha.model.Document.DocType;
import ru.grusha.staff.Person;
import ru.grusha.storage.DocumentStorage;
import ru.grusha.storage.JsonFileWriter;
import ru.grusha.storage.NameStorage;

public class Console{
	
	public static void main(String[] args) throws DocumentExistsExeption {
		
		NameStorage.loadStaff();

		Factory doc = new Factory();
		JsonFileWriter jsonWriter = new JsonFileWriter();
		
		//список типов создаваемых документов 
		DocType[] setOfDocumentTypes = new DocType[]{DocType.INCOMING, DocType.TASK, DocType.OUTGOING,DocType.INCOMING,DocType.TASK,DocType.OUTGOING};		        
		for (int i=0;i<setOfDocumentTypes.length;i++) {        	       	
        	try{
        		Document o=doc.createDocument(setOfDocumentTypes[i]);
        		//System.out.println(o.toString());//вывод полей документа в консоль для проверки
        	}catch(DocumentExistsExeption ex){
        		System.out.println(ex.getMessage());	
        	}        	      	    	
		}
        
		//создание набора авторов
		TreeSet<Person> setOfAuthors = new TreeSet<Person>();                 
		for (Document e: DocumentStorage.data) {        	
			setOfAuthors.add(e.getAuthor());        	
		}
                
		//вывод отчета (перечень авторов и список созданных ими документов, отсортированных по дате регистрации и регистрационному номеру)
		for (Person a: setOfAuthors) {
		List<Document> documentsOfAuthor = new ArrayList<Document>();
		System.out.println(" - "+a.getFullName()); //вывод полного имени автора документа    	        	
		for (Document e: DocumentStorage.data) {
				if (a.equals(e.getAuthor())) {
					documentsOfAuthor.add(e);
					System.out.println("\t- "+FactoryUtil.typeToString(e) //вывод типа документа
						+" от "+Factory.dateFormat.format(e.getRegistrationDate()) //вывод даты регистрации
						+ " №" + e.getRegistrationNumber()); //вывод регистрационного номера
		        	}        		
		       }
		jsonWriter.reportToAFile(a, documentsOfAuthor);
		}		
	}
}