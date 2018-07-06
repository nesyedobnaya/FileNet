package ru.grusha.wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.grusha.staff.Organization;
import ru.grusha.staff.Person;

/**
 * 
 * @author nesyedobnaya
 * класс для чтения/записи в xml объектов класса Organization
 */
@XmlRootElement(name = "organizations")
public class Organizations{

	@XmlElement(name = "organization")
	private List<Organization> listOfOrganizations =  new ArrayList<Organization>();;

	public List<Organization> getListOfOrganizations() {
		return listOfOrganizations;
	}
}