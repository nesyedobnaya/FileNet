package ru.grusha.factory;

import java.util.Random;

import ru.grusha.model.Document;
import ru.grusha.model.Outgoing;

public class OutgoingFactory extends Factory{	
	
	public static String[] delivery = {"Курьер", "Факс", "Электронная почта"};

	//генерация исходящего документа
	public static Document createOutgoing() {
		Outgoing outgoing = new Outgoing();
		outgoing.setDelivery(delivery[new Random().nextInt(3)]);
		outgoing.setAddressee(FactoryUtil.randomPerson());     	
		return outgoing;   			
	}	   
}
