package ru.grusha.factory;

import java.text.SimpleDateFormat;
import ru.grusha.exeption.DocumentExistsExeption;
import ru.grusha.model.Document;
import ru.grusha.model.Incoming;
import ru.grusha.model.Outgoing;
import ru.grusha.model.Task;
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
	 
	public Document createDocument(String kind) throws DocumentExistsExeption{ 
		int registrationNumber=FactoryUtil.createRegistrationNumber();
		DocumentStorage.check(DocumentStorage.data, registrationNumber);//проверка, существует ли уже документ с таким номером
		Document document = createDocumentOfCertainKind(kind);
		document.setRegistrationNumber(registrationNumber);
		makeCommonFields(document);
		DocumentStorage.data.add(document);
		return document;    	
	}
	    
	//определение типа документа    
	public static String type(Document document){
		String str = null;
		Task t = new Task();
		Incoming i = new Incoming();
		Outgoing o = new Outgoing();
		if ((document.getClass())==t.getClass()) str = "Поручение";
		if ((document.getClass())==i.getClass()) str = "Входящий";
		if ((document.getClass())==o.getClass()) str = "Исходящий";
		return str;		
	}        
       
	//создание экземпляров документа заданного типа    
	public static Document createDocumentOfCertainKind(String kind){            
		switch (kind){                 
		case "Task": return TaskFactory.createTask();
		case "Incoming": return IncomingFactory.createIncoming();
		case "Outgoing": return OutgoingFactory.createOutgoing();                 
		default: return null;            
		}        
	}
}
