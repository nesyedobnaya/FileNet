package ru.grusha.factory;

import java.util.Random;

import ru.grusha.model.Document;
import ru.grusha.model.Outgoing;
import ru.grusha.utils.FactoryUtil;

public class OutgoingFactory extends Factory{		

	//генерация исходящего документа
	public static Document createOutgoing() {
		Outgoing outgoing = new Outgoing();
		outgoing.setDelivery(FactoryUtil.delivery[new Random().nextInt(FactoryUtil.delivery.length)]);
		outgoing.setAddressee(FactoryUtil.randomPerson());     	
		return outgoing;   			
	}	   
}
