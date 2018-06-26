package ru.grusha.staff;

import javax.xml.bind.annotation.XmlAttribute;

public class Person extends Staff implements Comparable<Person>{
	
	private String lastName;//фамилия
	private String firstName;//имя
	private String patronymic;//отчество
	private String position;//должность
		
	@XmlAttribute
	public void setLastName(String name) {
		this.lastName = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	@XmlAttribute
	public void setFirstName(String name) {
		this.firstName = name;
	}
	
	public String getFirstName() {
		return firstName;
	}

	@XmlAttribute
	public void setPatronymic(String name) {
		this.patronymic = name;
	}
	
	public String getPatronymic() {
		return patronymic;
	}
	
	@XmlAttribute
	public void setPosition(String name) {
		this.position = name;
	}
	
	public String getPosition() {
		return position;
	}
	
	public String toString() {
		String str = getLastName()+" "
				+getFirstName()+" "
				+getPatronymic()
				+" Должность: "+getPosition();	        
		return str;		  	
	}
	
	public String getFullName() {
		String str = getLastName()+" "+getFirstName()+" "+getPatronymic();				        
		return str;		  	
	}

	@Override
	public int compareTo(Person entry) {
		//сортировка по автору
		String author=this.getFullName();		
		int result = author.compareTo(entry.getFullName());
		if(result != 0)
		return result;
		return 0;
	}
}
