package ru.grusha.factory;

import ru.grusha.model.Document;
import ru.grusha.model.Incoming;

public class IncomingFactory extends Factory{
	
	//генерация входящего документа
	public static Document createIncoming() {
		Incoming incoming = new Incoming();		
		FactoryUtil.makeOutgoingRegistrationDate(incoming);    	
		FactoryUtil.makeOutgoingNumber(incoming);    	
		FactoryUtil.makeSender(incoming);    	
		FactoryUtil.makeAddressee(incoming);    	
		return incoming;    
	}    
}
