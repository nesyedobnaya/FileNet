package fileWork;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbParser {
	
	public void saveObject(File file, Object object) {
		
		try {
			JAXBContext context = JAXBContext.newInstance(object.getClass());
			Marshaller m = context.createMarshaller();
			m.marshal(object, file);
		} catch (JAXBException ex) {
			Logger.getLogger(JaxbParser.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
    
	public Object loadObject(File file, Class c){
		
		try {
			JAXBContext context = JAXBContext.newInstance(c);
			Unmarshaller u = context.createUnmarshaller();
			return u.unmarshal(file);
		} catch (JAXBException ex) {
			Logger.getLogger(JaxbParser.class.getName()).log(Level.SEVERE, null, ex);
		}        
		return null;
	}
}
