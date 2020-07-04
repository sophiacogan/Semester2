package ie.nuig.cs.assignment5;

import java.util.ArrayList;
import java.util.List;

public class BookingList {
	

	public BookingList(){
		
	}

	//array list to hold bookings
	private List<Booking> bookingList = new ArrayList<Booking>();

	public List<Booking> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<Booking> bookingList) {
		this.bookingList = bookingList;
	}

	//method to add booking
	public void add(Booking booking) {
		this.bookingList.add(booking);
	}

	//method to delete a booking
	public void remove(Booking n) {
		this.bookingList.remove(n);
		
		
	}

}
