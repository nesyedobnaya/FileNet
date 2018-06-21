package fileWork;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "people")
public class People {
	@XmlElement(name = "person")
    private List<Person> people = null;
 
    public List<Person> getPeople() {
       return people;
    }
 
    public void setPeople(List<Person> people) {
        this.people = people;
    }

}
