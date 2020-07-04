package ie.nuig.cs.assignment5;

import java.util.concurrent.atomic.*;
public class Booking {

	//declare variables
	private int id;
	private String startDate;
	private String endDate;
	private Customer customer;
	private Vehicle vehicle;
	//unique booking id for each booking
	private static AtomicInteger bId = new AtomicInteger(0);
	
	
	
	//default constructor
	public Booking() {
		//increment each booking id
		this.id = bId.incrementAndGet();
	}
	//overloaded constructor
	public Booking( String startDate, String endDate, Customer customer, Vehicle vehicle) {
		
		this.id = bId.incrementAndGet();
		this.customer =customer;
		this.vehicle = vehicle;
		this.startDate = startDate;
		this.endDate = endDate;
}

	//getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = bId.incrementAndGet();
		
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public Vehicle getVehicle() {
		return vehicle;
	}



	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
}