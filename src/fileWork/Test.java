package fileWork;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Test {
	//Initialize the employees list
	static People employees = new People();
	public static void main(String[] args) throws JAXBException
	{
	    employees.setPeople(new ArrayList<Person>());
	    //Create two employees
	    Person emp1 = new Person();
	    emp1.setFirstName("Александр");
	    emp1.setLastName("Пушкин");
	    
	    Person emp2 = new Person();
	    emp2.setFirstName("Виталий");
	    emp2.setLastName("Канашин");
	    	     	    	     
	    //Add the employees in list
	    employees.getPeople().add(emp1);
	    employees.getPeople().add(emp2);
	    
	    marshalingExample();
	    unMarshalingExample();
	}
	private static void marshalingExample() throws JAXBException
	{
	    JAXBContext jaxbContext = JAXBContext.newInstance(People.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	     
	    //Marshal the employees list in console
	    jaxbMarshaller.marshal(employees, System.out);
	     
	    //Marshal the employees list in file
	    jaxbMarshaller.marshal(employees, new File("D://XML/People.xml"));
	}
	
	private static void unMarshalingExample() throws JAXBException
	{
	    JAXBContext jaxbContext = JAXBContext.newInstance(People.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	     
	    //We had written this file in marshalling example
	    People emps = (People) jaxbUnmarshaller.unmarshal( new File("D://XML/People.xml") );
	     
	    for(Person emp : emps.getPeople())
	    {
	        System.out.println(emp.getFirstName());
	        System.out.println(emp.getLastName());
	    }
	}

}
