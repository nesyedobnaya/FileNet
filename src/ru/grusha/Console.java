package ru.grusha;

import java.io.File;
import java.util.TreeSet;

import ru.grusha.exeption.DocumentExistsExeption;
import ru.grusha.factory.Factory;
import ru.grusha.factory.FactoryUtil;
import ru.grusha.model.Document.DocType;
import ru.grusha.model.Departments;
import ru.grusha.model.Document;
import ru.grusha.model.Organizations;
import ru.grusha.model.People;
import ru.grusha.model.Person;
import ru.grusha.storage.DocumentStorage;
import ru.grusha.storage.JaxbParser;
import ru.grusha.storage.NameStorage;

public class Console {

	public static void main(String[] args) throws DocumentExistsExeption {
		
		File file1 = new File("D://XML/People.xml");
		File file2 = new File("D://XML/Organizations.xml");	 	    
		File file3 = new File("D://XML/Departments.xml");
		
		//загрузка из файлов	    
		NameStorage.loadedPeople=(People)JaxbParser.unMarshaling(file1, People.class);		
		//System.out.println(loadedPeople.list.toString()); 			
		
		NameStorage.loadedDepartments=(Departments)JaxbParser.unMarshaling(file3, Departments.class);	        
		//System.out.println(loadedDepartments.list.toString()); 
		
		NameStorage.loadedOrganizations=(Organizations)JaxbParser.unMarshaling(file2, Organizations.class);       
		//System.out.println(loadedOrganizations.list.toString());

		Factory doc = new Factory();
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
					System.out.println(" - "+a.getFullName());        	        	
					for (Document e: DocumentStorage.data) {
						if (a.equals(e.getAuthor())) {
							System.out.println("\t- "+FactoryUtil.typeToString(e)
								+" от "+Factory.dateFormat.format(e.getRegistrationDate()) 
								+ " №" + e.getRegistrationNumber());
		        			}        		
		        		}
				}        
	}
}
	

