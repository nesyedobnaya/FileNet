package ru.grusha.factory;

import ru.grusha.model.Document;
import ru.grusha.model.Incoming;

public class IncomingFactory extends Factory{
	
	//генерация входящего документа
	public static Document createIncoming() {
		Incoming incoming = new Incoming();		
		incoming.setOutgoingRegistrationDate(FactoryUtil.getRandomDate(10000));    	
		incoming.setOutgoingNumber(FactoryUtil.createRandomInteger(4));    	
		incoming.setSender(FactoryUtil.randomPerson());    	
		incoming.setAddressee(FactoryUtil.randomPerson());    	
		return incoming;    
	}    
}
