package ru.grusha.storage;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbParser {	
	public static void marshaling(File file, Object object)  {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(object.getClass());		
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller(); 	 
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 	     
			//jaxbMarshaller.marshal(object, System.out); 			
			jaxbMarshaller.marshal(object, file);  	
			} catch (JAXBException e) {
			e.printStackTrace();
		}
 	}
 	
 	public static Object unMarshaling(File file, Class classOfObject) {
 		JAXBContext jaxbContext;
 		try {
			jaxbContext = JAXBContext.newInstance(classOfObject);		
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller(); 	     
			Object obj = (Object) jaxbUnmarshaller.unmarshal(file); 	    
			return obj; 
		} catch (JAXBException e) {			
			e.printStackTrace();
			}
			return null;
	} 
}
