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
		type(document);
		FactoryUtil.registrationDate(document);
		return document;	 
	}
	 
	public Document createDocument(DocType type) throws DocumentExistsExeption{ 
		int registrationNumber=FactoryUtil.createRegistrationNumber();
		DocumentStorage.check(DocumentStorage.data, registrationNumber);//проверка, существует ли уже документ с таким номером
		Document document = createDocumentOfCertainKind(type);
		document.setRegistrationNumber(registrationNumber);
		document.setDocType(type);
		makeCommonFields(document);
		DocumentStorage.data.add(document);
		return document;    	
	}
	    
	//определение типа документа    
	public static String type(Document document){
		String str = null;		
		if (document.getType()==DocType.TASK) str = "Поручение";
		if (document.getType()==DocType.INCOMING) str = "Входящий";
		if (document.getType()==DocType.OUTGOING) str = "Исходящий";
		return str;		
	}        
       
	//создание экземпляров документа заданного типа    
	public static Document createDocumentOfCertainKind(DocType type){            
		switch (type){                 
		case TASK: return TaskFactory.createTask();
		case INCOMING: return IncomingFactory.createIncoming();
		case OUTGOING: return OutgoingFactory.createOutgoing();                 
		default: return null;            
		}        
	}
}
