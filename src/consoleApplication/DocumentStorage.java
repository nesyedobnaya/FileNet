package consoleApplication;

import java.util.TreeSet;

public class DocumentStorage {
 
	public static TreeSet<Document> data = new TreeSet<Document>();
		
	//проверка совпадения регистрационного номера с другими документами набора	 
	public static void check(TreeSet<Document> tree, int registrationNumber) throws DocumentExistsExeption{
		for (Document e: tree) {        
			if (registrationNumber==e.registrationNumber)  {         	
				throw new DocumentExistsExeption("Документ с таким регистрационным номером уже существует");        
			}		
		}
	}
}
