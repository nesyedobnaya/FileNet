package ru.grusha;

import java.io.File;
import java.util.TreeSet;

import fileWork.Departments;
import fileWork.JaxbParser;
import fileWork.Organizations;
import fileWork.People;
import ru.grusha.exeption.DocumentExistsExeption;
import ru.grusha.factory.Factory;
import ru.grusha.factory.FactoryUtil;
import ru.grusha.model.Document.DocType;
import ru.grusha.model.Document;
import ru.grusha.storage.DocumentStorage;

public class Console {

	public static void main(String[] args) throws DocumentExistsExeption {
		
		File file1 = new File("D://XML/People.xml");
		File file2 = new File("D://XML/Organizations.xml");	 	    
		File file3 = new File("D://XML/Departments.xml");
		
		People loadedPeople=new People(); 	    
		loadedPeople=(People)JaxbParser.unMarshaling(file1, loadedPeople);	        
		System.out.println(loadedPeople.list.toString()); 			
		
		Departments loadedDepartments=new Departments(); 	    
		loadedDepartments=(Departments)JaxbParser.unMarshaling(file3, loadedDepartments);	        
		System.out.println(loadedDepartments.list.toString()); 
		
		Organizations loadedOrganizations=new Organizations(); 	    
		loadedOrganizations=(Organizations)JaxbParser.unMarshaling(file2, loadedOrganizations);	        
		System.out.println(loadedOrganizations.list.toString());

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
		TreeSet<String> setOfAuthors = new TreeSet<String>();                 
		for (Document e: DocumentStorage.data) {        	
			setOfAuthors.add(e.getAuthor());        	
		}
                
		//вывод отчета (перечень авторов и список созданных ими документов, отсортированных по дате регистрации и регистрационному номеру)
				for (String a: setOfAuthors) {
					System.out.println(" - "+a);        	        	
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
	

