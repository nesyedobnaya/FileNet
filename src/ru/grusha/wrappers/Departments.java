package ru.grusha.wrappers;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.grusha.staff.Department;

/**
 * 
 * @author nesyedobnaya
 * класс для чтения/записи в xml объектов класса Department
 */
@XmlRootElement(name = "departments")
public class Departments{

	@XmlElement(name = "department")
	private List<Department> listOfDepartments = null;

	public List<Department> getListOfDepartments() {
		return listOfDepartments;
	}

	public void setListOfDepartments(List<Department> listOfDepartments) {
		this.listOfDepartments = listOfDepartments;
	}
}