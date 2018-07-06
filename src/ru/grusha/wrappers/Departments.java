package ru.grusha.wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.grusha.staff.Department;
import ru.grusha.staff.Person;

/**
 * 
 * @author nesyedobnaya
 * класс для чтения/записи в xml объектов класса Department
 */
@XmlRootElement(name = "departments")
public class Departments{

	@XmlElement(name = "department")
	private List<Department> listOfDepartments =  new ArrayList<Department>();;

	public List<Department> getListOfDepartments() {
		return listOfDepartments;
	}
}