package main.webapp.WebContent;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.view.Viewable;

@Path("/path")
@Produces(MediaType.TEXT_HTML)
public class JSPclass {

    @GET
    @Path("/index")
    @Produces({MediaType.TEXT_HTML})
    public Viewable index(@Context HttpServletRequest request) {
        System.out.println("/INDEX called");
        return new Viewable("/index.jsp", null);
    }
}