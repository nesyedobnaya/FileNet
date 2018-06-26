package ru.grusha.staff;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "organizations")
public class Organizations{

	@XmlElement(name = "organization")
	public List<Organization> list = null;
	
	public void setOrganizations(List<Organization> listO) {
		this.list = listO;       
	}
    
	public String toString() {
		String str= "";
		for(Organization prsn : list)
		{			
			str = str +prsn.toString();	        
		}		
		return str;		  	
	}
}
