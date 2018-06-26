package ru.grusha.staff;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "people")
public class People{

	@XmlElement(name = "person")
	public List<Person> list = null;
 
	public void setPeople(List<Person> listPeople) {
		this.list = listPeople;       
	}
    
	public String toString() {
		String str= "";
		for(Person prsn : list)
		{			
			str = str +prsn.toString();	        
	    }		
		return str;		  	
	}
}
