package ru.grusha.utils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JaxbParser {	
 	
 	public static Object unMarshal(File file, Class classOfObject) {
 		
 		try {
 			JAXBContext jaxbContext = JAXBContext.newInstance(classOfObject);		
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller(); 	     
			Object obj = (Object) jaxbUnmarshaller.unmarshal(file); 	    
			return obj; 
		} catch (JAXBException e) {			
			e.printStackTrace();
		}
		return null;
	} 
}