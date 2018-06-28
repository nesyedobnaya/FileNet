package ru.grusha.factory;

import java.util.Random;

import ru.grusha.model.Document;
import ru.grusha.model.Outgoing;
import ru.grusha.utils.FactoryUtil;

/**
 * 
 * @author nesyedobnaya
 * фабричный класс для создания исходящего документа
 */
public class OutgoingFactory extends Factory{		

	/**
	 * фабричный метод, возвращающий заполненный исходящий документ
	 */
	@Override
	public Document createDocument() {
		Outgoing outgoing = new Outgoing();
		outgoing.setID((FactoryUtil.createRandomInteger(4)));
		outgoing.setAuthor(FactoryUtil.randomPerson());
		outgoing.setName("Название документа");
		outgoing.setText((FactoryUtil.createRandomInteger(10))+"");
		outgoing.setRegistrationDate(FactoryUtil.getRandomDate(10000));
		outgoing.setDelivery(FactoryUtil.delivery[new Random().nextInt(FactoryUtil.delivery.length)]);
		outgoing.setAddressee(FactoryUtil.randomPerson());     	
		return outgoing; 
	}	   
}
