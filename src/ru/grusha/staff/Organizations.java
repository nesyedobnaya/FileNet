package ru.grusha.staff;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "organizations")
public class Organizations{

	@XmlElement(name = "organization")
	public List<Organization> listOfOrganizations = null;
}