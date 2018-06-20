package consoleApplication;

import java.util.TreeSet;

public class Console {

	public static void main(String[] args) throws DocumentExistsExeption {

		Generator doc = new Generator();	
		String setOfDocuments[] = {"Incoming", "Task", "Outgoing", "Incoming", "Task", "Outgoing"}; //список создаваемых документов          
		for (int i=0;i<setOfDocuments.length;i++) {        	       	
        	try{
        		Document o=doc.MakeDocument(setOfDocuments[i]);
        		//System.out.println(o.toString());//вывод полей документа в консоль для проверки
        	}catch(DocumentExistsExeption ex){
        		System.out.println(ex.getMessage());	
        	}        	      	    	
		}
        
		//создание набора авторов
		TreeSet<String> setOfAuthors = new TreeSet<String>();                 
		for (Document e: DocumentStorage.data) {        	
			setOfAuthors.add(e.author);        	
		}
                
		//вывод отчета (перечень авторов и список созданных ими документов, отсортированных по дате регистрации и регистрационному номеру)
		for (String a: setOfAuthors) {
			System.out.println(" - "+a);        	        	
			for (Document e: DocumentStorage.data) {
				if (a==e.author) {
					System.out.println("\t- "+Generator.type(e)
						+" от "+Generator.dateFormat.format(e.registrationDate) 
						+ " №" + e.registrationNumber);
        			}        		
        		}
		}        
	}
}
	

