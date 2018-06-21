package fileWork;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbParser {	
	
	public void saveInXml(File file, Object object) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	     
	    //Marshal the list in console
	    jaxbMarshaller.marshal(object, System.out);
	     
	    //Marshal the list in file
	    jaxbMarshaller.marshal(object, file);
	}
	
	public Object getFromXml(File file, Class c){
		JAXBContext jaxbContext = JAXBContext.newInstance(People.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	     
	    //We had written this file in marshalling example
	    People emps = (People) jaxbUnmarshaller.unmarshal( new File("D://XML/People.xml") );
	     
	    for(Person emp : emps.getPeople())
	    {
	        System.out.println(emp.getFirstName());
	        System.out.println(emp.getLastName());
	    }
		return emps;
	}
    
	public Object loadObject(File file, Class c){
		
		try {
			
            JAXBContext jaxbContext = JAXBContext.newInstance(c);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            System.out.println(jaxbUnmarshaller.unmarshal(file));
            return jaxbUnmarshaller.unmarshal(file);            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
		return null;
	}
}
