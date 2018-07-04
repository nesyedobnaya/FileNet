package ru.grusha.wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import ru.grusha.model.Document;
import ru.grusha.model.Incoming;
import ru.grusha.model.Outgoing;
import ru.grusha.model.Task;

/**
 * 
 * @author nesyedobnaya
 * класс для чтения/записи в xml объектов класса Person
 */
@XmlRootElement(name = "documents")
public class Documents{

	@XmlElementWrapper(name = "documents_of_author")
    @XmlElements({
            @XmlElement(name = "task", type = Task.class),
            @XmlElement(name = "incoming", type = Incoming.class),
            @XmlElement(name = "outgoing", type = Outgoing.class)
    })
	public List<Document> listOfDocuments = null;

	public void setDocuments(ArrayList<Document> arrayList) {
	
		this.listOfDocuments = arrayList; 	
	}
}