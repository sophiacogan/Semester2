package ie.nuig.cs.ct545restt;


import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/handleform")
public class HandleForm {
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String respondToForm(@FormParam("name") String name) {
	        return "The value sent by the form was: '" + name + "'";
	    }
}
