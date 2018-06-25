package ru.grusha.factory;

import java.text.SimpleDateFormat;
import ru.grusha.exeption.DocumentExistsExeption;
import ru.grusha.model.Document;
import ru.grusha.model.Document.DocType;
import ru.grusha.storage.DocumentStorage;

public class Factory {
	
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.mm.dd");//формат вывода даты	
		
	//генерация общих полей документа
	public Document makeCommonFields(Document document) {		       
		FactoryUtil.generateID(document);
		FactoryUtil.author(document);
		FactoryUtil.name(document);
		FactoryUtil.text(document);
		FactoryUtil.typeToString(document);
		FactoryUtil.registrationDate(document);
		return document;	 
	}	 

	public Document createDocument(DocType type) throws DocumentExistsExeption{ 
		int registrationNumber=FactoryUtil.createRegistrationNumber();
		DocumentStorage.check(DocumentStorage.data, registrationNumber);//проверка, существует ли уже документ с таким номером
		Document document = createDocumentOfCertainType(type);
		document.setRegistrationNumber(registrationNumber);
		document.setDocType(type);
		makeCommonFields(document);
		DocumentStorage.data.add(document);
		return document;   
	}
       
	//создание экземпляров документа заданного типа    
	public static Document createDocumentOfCertainType(DocType type){            
		switch (type){                 
		case TASK: return TaskFactory.createTask();
		case INCOMING: return IncomingFactory.createIncoming();
		case OUTGOING: return OutgoingFactory.createOutgoing();
		default: return null;            
		}        
	}
}
