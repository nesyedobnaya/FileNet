package webapp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ru.grusha.utils.FactoryUtil;
import ru.grusha.utils.JsonFileWriter;

@Path("/ecm")
public class EmployeesController {
	@Path("/employees")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloXML(){
		FactoryUtil.loadStaff();
		JsonFileWriter jsonWriter = new JsonFileWriter();
		String peopleJson = jsonWriter.objectToJsonString(FactoryUtil.loadedPeople);
		return peopleJson;
	}
	
	@Path("/employees/{id}")
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayHelloJson(@PathParam("id") int ID){
		String resource=null;
		return resource;
	}
}
