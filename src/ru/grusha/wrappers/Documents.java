package ru.grusha.wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.grusha.model.Document;

/**
 * 
 * @author nesyedobnaya
 * класс для чтения/записи в xml объектов класса Person
 */
@XmlRootElement(name = "documents")
public class Documents{

	@XmlElement(name = "document")
	public List<Document> listOfDocuments = null;

	public void setDocuments(ArrayList<Document> arrayList) {
	
		this.listOfDocuments = arrayList; 	
	}
}