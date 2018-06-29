package ru.grusha.factory;

import ru.grusha.model.Document;
import ru.grusha.model.Incoming;
import ru.grusha.utils.FactoryUtil;

/**
 * 
 * @author nesyedobnaya
 * фабричный класс для создания входящего документа
 */
public class IncomingFactory extends Factory{	
	
	/**
	 * фабричный метод, возвращающий заполненный входящий документ
	 */
	@Override
	public Document getDocument() {
		Incoming incoming = new Incoming();		
		incoming.setID((FactoryUtil.createRandomInteger(4)));
		incoming.setAuthor(FactoryUtil.randomPerson());
		incoming.setName("Название документа");
		incoming.setText((FactoryUtil.createRandomInteger(10))+"");
		incoming.setRegistrationDate(FactoryUtil.getRandomDate(10000));
		incoming.setOutgoingRegistrationDate(FactoryUtil.getRandomDate(10000));    	
		incoming.setOutgoingNumber(FactoryUtil.createRandomInteger(4));    	
		incoming.setSender(FactoryUtil.randomPerson());    	
		incoming.setAddressee(FactoryUtil.randomPerson());    	
		return incoming;
	}    
}
