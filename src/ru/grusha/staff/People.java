package ru.grusha.staff;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "people")
public class People{

	@XmlElement(name = "person")
	public List<Person> listOfPeople = null;
}