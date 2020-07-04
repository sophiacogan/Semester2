package ie.nuig.cs.assignment5;

public class Vehicle {

//variables
	private String registration;
	private String manufacturer;
	private String colour;

	// default constructor
	public Vehicle() {

	}

	// overloaded constructor
	public Vehicle(String registration, String manufacturer, String colour) {
		this.registration = registration;
		this.colour = colour;
		this.manufacturer = manufacturer;
	}

	// Getters and Setters
	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	// toString method
	@Override
	public String toString() {
		return "Vehicle [registration=" + registration + ", manufacturer=" + manufacturer + ", colour=" + colour + "]";
	}

}
