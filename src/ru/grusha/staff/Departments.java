package ru.grusha.staff;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "departments")
public class Departments{

	@XmlElement(name = "department")
	public List<Department> list = null;
}