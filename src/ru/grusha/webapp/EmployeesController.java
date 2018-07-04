package ru.grusha.webapp;

import java.util.ArrayList;
import java.util.TreeSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ru.grusha.model.Document;
import ru.grusha.staff.Person;
import ru.grusha.storage.DocumentStorage;
import ru.grusha.utils.FactoryUtil;
import ru.grusha.utils.JaxbParser;
import ru.grusha.utils.JsonFileWriter;
import ru.grusha.utils.ReportUtil;
import ru.grusha.wrappers.Documents;

@Path("/ecm")
public class EmployeesController {
	@Path("/employees")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloXML(){
		JsonFileWriter jsonWriter = new JsonFileWriter();
		String peopleJson = jsonWriter.objectToJsonString(FactoryUtil.loadedPeople);
		return peopleJson;
	}
	
	@Path("/employees/{id}")
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayHelloJson(@PathParam("id") int ID){
		
		Documents docs = new Documents();
		
		String ReportXML=null;
		TreeSet<Person> setOfAuthors = ReportUtil.authorsToSet(DocumentStorage.data);
		for (Person authorFromSet: setOfAuthors) {
			if (authorFromSet.getID()==(ID)){
				docs.setDocuments(new ArrayList<Document>());
				for (Document documentFromStorage: DocumentStorage.data) {
					if (authorFromSet.equals(documentFromStorage.getAuthor())) {
						docs.listOfDocuments.add(documentFromStorage);
					}
				}
				ReportXML=JaxbParser.marshalToString(docs);
			}
		}
		return ReportXML;
	}
}
