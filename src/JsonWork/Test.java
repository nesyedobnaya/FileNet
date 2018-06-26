package JsonWork;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ru.grusha.exeption.DocumentExistsExeption;
import ru.grusha.factory.Factory;
import ru.grusha.factory.FactoryUtil;
import ru.grusha.model.Departments;
import ru.grusha.model.Document;
import ru.grusha.model.Organizations;
import ru.grusha.model.Document.DocType;
import ru.grusha.model.People;
import ru.grusha.model.Person;
import ru.grusha.storage.DocumentStorage;
import ru.grusha.storage.JaxbParser;
import ru.grusha.storage.NameStorage;

public class Test
{
public static void main(String[] args) throws DocumentExistsExeption {
		
		File filePeople = new File("D://XML/People.xml");
		File fileOrganizations = new File("D://XML/Organizations.xml");	 	    
		File fileDepartments = new File("D://XML/Departments.xml");
		
		//загрузка из файлов	    
		NameStorage.loadedPeople=(People)JaxbParser.unMarshaling(filePeople, People.class);		
		//System.out.println(loadedPeople.list.toString()); 			
		
		NameStorage.loadedDepartments=(Departments)JaxbParser.unMarshaling(fileDepartments, Departments.class);	        
		//System.out.println(loadedDepartments.list.toString()); 
		
		NameStorage.loadedOrganizations=(Organizations)JaxbParser.unMarshaling(fileOrganizations, Organizations.class);       
		//System.out.println(loadedOrganizations.list.toString());

		Factory doc = new Factory();
		FileWriter writer;
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
		
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
			try {						
				writer = new FileWriter("D://XML/"+a.getLastName()+".json");
				String json = gson.toJson(documentsOfAuthor);
				writer.write(json);
				//gson.toJson(documentsOfAuthor, writer);
				//System.out.println(json);
				writer.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}    
}