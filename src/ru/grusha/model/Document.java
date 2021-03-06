package ru.grusha.model;

import java.util.Date;

import ru.grusha.interfaces.Storable;
import ru.grusha.utils.FormatUtil;

public abstract class Document implements Comparable<Document>, Storable{
	 
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
	    
		//сравнение по дате регистрации
		Date dateDoc = this.registrationDate;
		int result = dateDoc.compareTo(entry.registrationDate); 
		if(result != 0) return result; 

		//сравнение по регистрационному номеру
		return this.registrationNumber.compareTo(entry.getRegistrationNumber()); 
	} 
	
	/**
	 * @return возвращает строку, которая записывается в отчет
	 */
	public String print(){
		return "Документ"
				+" от "+FormatUtil.formatDate(getRegistrationDate()) 
				+ " №" + getRegistrationNumber();
	}
}
	    
