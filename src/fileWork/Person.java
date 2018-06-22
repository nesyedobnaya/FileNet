package fileWork;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

public class Person extends Staff{
	
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
}
