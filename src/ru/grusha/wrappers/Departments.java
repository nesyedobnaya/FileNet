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
	public List<Department> list = null;
}