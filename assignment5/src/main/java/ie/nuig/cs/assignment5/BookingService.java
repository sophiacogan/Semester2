package ie.nuig.cs.assignment5;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("/bookingservice")
@Singleton

public class BookingService {
	BookingList list;

	public BookingService() {

		list = new BookingList();
		
		//creating bookings
		Customer customer = new Customer("Sophia", "Cogan", "Sligo");
		Vehicle vehicle = new Vehicle("10-SO-361", "Opal", "Silver");
		Booking booking = new Booking("10-5-20", "11-5-20", customer, vehicle);

		Customer customer2 = new Customer("Laura", "Kidd", "Galway");
		Vehicle vehicle2 = new Vehicle("11-G-210", "Ford", "Blue");
		Booking booking2 = new Booking("15-5-20", "18-5-20", customer2, vehicle2);

		Customer customer3 = new Customer("Jack", "King", "Mayo");
		Vehicle vehicle3 = new Vehicle("131-MO-6543", "Toyota", "Green");
		Booking booking3 = new Booking("15-6-20", "18-6-20", customer3, vehicle3);

		Customer customer4 = new Customer("Amy", "Kelly", "Limerick");
		Vehicle vehicle4 = new Vehicle("141-L-6543", "BMW", "Black");
		Booking booking4 = new Booking("19-5-20", "21-5-20", customer4, vehicle4);

		//creating array list
		ArrayList<Booking> bList = new ArrayList<Booking>();

		list.setBookingList(bList);
		
		//adding bookings to array list
		list.getBookingList().add(booking);
		list.getBookingList().add(booking2);
		list.getBookingList().add(booking3);
		list.getBookingList().add(booking4);

	}

	//GET Request
	@GET
	@Produces(MediaType.APPLICATION_JSON)

	//getAll method that returns all the contents of the list
	public BookingList getAll() {
		return list;
	}

	//POST METHOD
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	//adds new booking to the list
	public Response addBooking(Booking e) {
		list.getBookingList().add(e);

		//status 201 response
		return Response.ok(e).status(201).build();
	}

	//GET by id request
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getBooking(@PathParam("id") int id) {
		//for loop to check if id matches the one entered
		for (Booking e : list.getBookingList()) {
			
			if (e.getId() == id) {
				return Response.ok(e).build();
			}
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	//PUT Request to update a booking by id
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response updateBooking(@PathParam("id") int id, Booking e) {
		//for loop to get the correct id
		for (Booking n : list.getBookingList()) {
			//if statement that updates booking details
			if (n.getId() == id) {
				n.setCustomer(e.getCustomer());
				n.setVehicle(e.getVehicle());
				n.setStartDate(e.getStartDate());
				n.setEndDate(e.getEndDate());
				
				return Response.ok(n).build();	
			}
			
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	
	//DELETE Request
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deleteBooking(@PathParam("id") int id, Booking e) {
        for (Booking n : list.getBookingList()) {
        	//if id matches the one entered remove it 
        	//from the list
            if (n.getId() == id) {
                list.remove(n);
                return Response.ok().build();
            }

        }
        return Response.status(Status.NOT_FOUND).build();
    }
}

