package ru.grusha.factory;

import ru.grusha.exeption.DocumentExistsExeption;
import ru.grusha.model.Document;
import ru.grusha.storage.DocumentStorage;
import ru.grusha.utils.DocumentType;
import ru.grusha.utils.FactoryUtil;

/**
 * генератор проверяет, существует ли уже документ с таким номером
 */
public class Generator {
	
	/**
	 * @param type - тип требующегося документа
	 * @return - созданный документ
	 * @throws DocumentExistsExeption - документ с таким номером уже существует
	 */
	public Document createDocument(DocumentType type) throws DocumentExistsExeption{ 
		String registrationNumber=(FactoryUtil.createRandomInteger(6))+"";
		DocumentStorage.check(DocumentStorage.data, registrationNumber);//проверка, существует ли уже документ с таким номером
		Document document = type.getFactory().getDocument();
		document.setRegistrationNumber(registrationNumber);
		DocumentStorage.data.add(document);
		return document;    	
	}
}
