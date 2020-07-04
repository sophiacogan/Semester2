package ie.nuig.cs.ct545restt;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hellosingleton")
//comment out singleton
//@Singleton
public class HelloSingleton {

	int timesCalled = 0;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		timesCalled++;
		return "Hello World number: " + timesCalled;
	}
}