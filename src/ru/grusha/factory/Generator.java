package ru.grusha.factory;

import ru.grusha.exeption.DocumentExistsExeption;
import ru.grusha.model.Document;
import ru.grusha.utils.FactoryUtil;
import ru.grusha.utils.DocType;
import ru.grusha.storage.DocumentStorage;

/**
 * генератор проверяет, существует ли уже документ с таким номером
 */
public class Generator {
	
	/**
	 * 
	 * @param type - тип требующегося документа
	 * @return - созданный документ
	 * @throws DocumentExistsExeption - документ с таким номером уже существует
	 */
	public Document createDocument(DocType type) throws DocumentExistsExeption{ 
		String registrationNumber=(FactoryUtil.createRandomInteger(6))+"";
		DocumentStorage.check(DocumentStorage.data, registrationNumber);//проверка, существует ли уже документ с таким номером
		Document document = newFactoryForType(type).createDocument();
		document.setRegistrationNumber(registrationNumber);
		DocumentStorage.data.add(document);
		return document;    	
	}	      
       
	/**
	 * создание фабрики документов заданного типа    
	 * @param type - тип требующегося документа
	 * @return - фабрика для требующегося документа
	 */
	private Factory newFactoryForType(DocType type){            
		switch (type){                 
			case TASK: return new TaskFactory();
			case INCOMING: return new IncomingFactory();
			case OUTGOING: return new OutgoingFactory();           
		}
		return null;        
	}
}
