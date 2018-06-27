package ru.grusha.model;

import java.util.Date;

import ru.grusha.factory.Factory;

public abstract class Document implements Comparable<Document>{
	 
	private int ID;//идентификатор документа
	private String name;//название документа	  
	private String text;//текст документа	     
	private String registrationNumber;//регистрационный номер	     
	private Date registrationDate;//дата регистрации	    
	private String author;//автор документа	
	
				
	public int getID() {
		return ID;
	}

	public void setID(int ID) { 
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override 	    
	public int compareTo(Document entry){ 
	    
		//сортировка по дате регистрации
		Date dateDoc = this.registrationDate;
		int result = dateDoc.compareTo(entry.registrationDate); 
		if(result != 0) return result; 

		//сортировка по регистрационному номеру
		String regDoc=this.registrationNumber;
		result = regDoc.compareTo(entry.getRegistrationNumber()); 
		if(result!=0) 
		return result; 
		return 0;	 
	} 
	
	public String print(){
		return "Документ"
				+" от "+Factory.dateFormat.format(this.getRegistrationDate()) 
				+ " №" + this.getRegistrationNumber();
	}
}
	    
