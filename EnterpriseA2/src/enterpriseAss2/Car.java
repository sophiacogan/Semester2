package enterpriseAss2;

import java.util.Random;

public class Car {

	private String registration;
	private int saleValue;

	// array listing colours
	private static final String[] colour = { "yellow", "silver", "black", "white", "green", "red", "pink" };

	private String carColour;

	// array with different county registration codes
	private static final String[] countyReg = { "G", "SO", "RN", "MO", "LM", "DL", "C", "KK", "KY", "CE", "CW", "D",
			"MN", "OY", "TN", "TS", "KE", "L", "LD", "LH", "LM", "LS", "MH", "W", "WH", "WX", "WW" };

	Random rand = new Random();

	public Car() {

		// randomly generating reg plates using 00-G-100 format
		// highest year is 20

		this.registration = String.valueOf(String.format("%02d", rand.nextInt(20))) + "-"
				+ countyReg[rand.nextInt(countyReg.length)] + "-" + String.valueOf(rand.nextInt(9000));

		// randomly choosing car colour
		carColour = colour[rand.nextInt(colour.length)];

		// randomly setting price between 1000 and 20000
		saleValue = rand.nextInt(19000) + 1000;
	}

	// getter methods
	public String getRegistration() {

		return registration;
	}

	// getSaleValue method
	private int getSaleValue() {

		return this.saleValue;
	}

	private String getColour() {

		return carColour;
	}

	// to String method
	public String toString() {

		return getColour() + " car, with registration " + getRegistration() + " worth €" + getSaleValue();

	}
}
