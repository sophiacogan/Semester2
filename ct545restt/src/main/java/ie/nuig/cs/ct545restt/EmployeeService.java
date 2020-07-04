package ie.nuig.cs.ct545restt;


import java.util.ArrayList;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/employees")
@Singleton
public class EmployeeService {

	Employees list;
	
	public EmployeeService() {
		list = new Employees();
		list.setEmployeeList(new ArrayList<Employee>());
		list.getEmployeeList().add(new Employee(1, "Joe Smith"));
		list.getEmployeeList().add(new Employee(2, "Jane Doe"));
		list.getEmployeeList().add(new Employee(3, "Jack White"));
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Employees getAllEmployees() 
	{
		return list;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee addEmployee(Employee e) 
	{
		list.getEmployeeList().add(e);
		return e;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getEmployee(@PathParam("id") int id) 
	{
		for(Employee e : list.getEmployeeList()) {
			if(e.getId() == id) {
				return Response.ok(e).build();
			}
		}		
		return Response.status(Status.NOT_FOUND).build();
	}
	
}  
