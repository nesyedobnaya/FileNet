package fileWork;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "people")

public class People
{
    @XmlElement(name = "person")
    private List<Person> employees = null;
 
    public List<Person> getPeople() {
        return employees;
    }
 
    public void setPeople(List<Person> employees) {
        this.employees = employees;
    }
}
