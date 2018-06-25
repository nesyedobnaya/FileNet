package ru.grusha.factory;

import ru.grusha.model.Document;
import ru.grusha.model.Incoming;

public class IncomingFactory extends Factory{
	
	//генерация входящего документа
	public static Document createIncoming() {
		Incoming incoming = new Incoming();		
		FactoryUtil.makeOutgoingRegistrationDate(incoming);    	
		FactoryUtil.makeOutgoingNumber(incoming);    	
		incoming.setSender(FactoryUtil.randomPerson());    	
		incoming.setAddressee(FactoryUtil.randomPerson());  	
		return incoming;    
	}    
}
