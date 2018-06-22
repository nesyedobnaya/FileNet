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
 	    Person person1 = new Person();
 	    person1.setFirstName("Александр");
 	    person1.setLastName("Пушкин");
 	    person1.setPatronymic("Сегреевич");
		person1.setPosition("Бухгалтер");
 	    
 	    Person person2 = new Person();
 	    person2.setFirstName("Виталий");
 	    person2.setLastName("Канашин");
 	    person2.setPatronymic("Андреевич");
		person2.setPosition("Оператор");
 	    
 	    Person person3 = new Person();
		person3.setLastName("Никифоров");
		person3.setFirstName("Виктор");
		person3.setPatronymic("Николаевич");
		person3.setPosition("Главный бухгалтер");
 	    	     	    	     
 	    //Add the employees in list
 	    employees.getPeople().add(person1);
 	    employees.getPeople().add(person2);
 	    employees.getPeople().add(person3);
 	    
 	    File file1 = new File("D://XML/People.xml");
 	    
 	    marshaling(file1,employees);
 	    People loadedPeople=new People();
 	    
 	   loadedPeople=(People)unMarshaling(file1, employees);
 	    
 	   for(Person prsn : loadedPeople.getPeople())
	    {
	        System.out.println(prsn.getFirstName());
	        System.out.println(prsn.getLastName());
	    }
 	    	    
 	    
 	}
 	private static void marshaling(File file, Object object) throws JAXBException
 	{
 	    JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
 	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 	 
 	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 	     
 	    //Marshal the employees list in console
 	    jaxbMarshaller.marshal(object, System.out);
 	     
 	    //Marshal the employees list in file
 	    jaxbMarshaller.marshal(object, file);
 	}
 	
 	private static Object unMarshaling(File file, Object object) throws JAXBException
 	{
 	    JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
 	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
 	     
 	    //We had written this file in marshalling example
 	    Object obj = (Object) jaxbUnmarshaller.unmarshal(file);
 	    return obj; 	     
 	    } 
 }