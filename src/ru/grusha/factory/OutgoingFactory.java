package ru.grusha.factory;

import ru.grusha.model.Document;
import ru.grusha.model.Outgoing;

public class OutgoingFactory extends Factory{	

	//генерация исходящего документа
	public static Document createOutgoing() {
		Outgoing outgoing = new Outgoing();
		FactoryUtil.makeDelivery(outgoing);
		outgoing.setAddressee(FactoryUtil.randomPerson());    	
		return outgoing;   			
	}	   
}
