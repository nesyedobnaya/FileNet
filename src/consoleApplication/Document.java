package consoleApplication;

import java.util.Date;

public abstract class Document implements Comparable<Document>{
	 
	protected String ID;//идентификатор документа
	protected String name;//название документа	  
	protected String text;//текст документа	     
	protected int registrationNumber;//регистрационный номер	     
	protected Date registrationDate;//дата регистрации	    
	protected String author;//автор документа	  
	
	@Override 	    
	public int compareTo(Document entry){ 
	    
	//сортировка по дате регистрации
	Date dateDoc = this.registrationDate;
	int result = dateDoc.compareTo(entry.registrationDate); 
	if(result != 0) return result; 

	//сортировка по регистрационному номеру
	int regDoc=this.registrationNumber;
	result = regDoc - entry.registrationNumber; 
	if(result!=0) 
	return (int) result/Math.abs(result); 
	return 0;  	 
	} 
	    
	@Override 		
	public String toString() { 			
		return "Документ №"+registrationNumber
		    +", ID: " + ID 
		    + ", Название документа: " + name 
		    + ", Дата регистрации: " + registrationDate 
		    + ", Автор: " + author 
		    + ", Текст документа: "+text;
	}
}
	    
