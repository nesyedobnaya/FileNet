package fileWork;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "departments")
public class Departments{

	@XmlElement(name = "department")
	public List<Department> list = null;
	
	public void setDepartments(List<Department> listD) {
		this.list = listD;       
	}
    
	public String toString() {
		String str= "";
		for(Department prsn : list)
		{			
			str = str +prsn.toString();	        
	    }		
		return str;		  	
	}
}
