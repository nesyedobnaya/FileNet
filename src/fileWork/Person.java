package fileWork;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person")
public class Person extends Staff{
	
	protected String lastName;//фамилия
	protected String firstName;//имя
	protected String patronymic;//отчество
	protected String position;//должность
	
	//@XmlElementWrapper(name = "person")
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
}
