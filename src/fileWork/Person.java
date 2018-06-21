package fileWork;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person")
public class Person extends Staff{
	
	protected String lastName;//фамилия
	protected String firstName;//имя
	protected String patronymic;//отчество
	protected String position;//должность
	
	@XmlElement
	public void setLastName(String name) {
		this.lastName = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	@XmlElement
	public void setFirstName(String name) {
		this.firstName = name;
    }
	
	public String getFirstName() {
		return firstName;
	}

	@XmlElement
	public void setPatronymic(String name) {
		this.patronymic = name;
    }
	
	public String getPatronymic() {
		return patronymic;
	}
	
	@XmlElement
	public void setPosition(String name) {
		this.position = name;
    }
	
	public String getPosition() {
		return position;
	}
}
