package enterpriseAss2;

import java.util.ArrayList;

public class CarShowroom {

	// setting showroom capacity to 5
	public static final int capacity = 5;

	// private field holding list of cars
	private ArrayList<Car> carList = new ArrayList<Car>();

	{

	}

	Car car;

	public CarShowroom() {

		// create array list
		carList = new ArrayList<Car>();

		this.car = new Car();
	}

	// getSize to calculate number of cars in the list
	public int getSize() {
		return carList.size();
	}

	// if the list is empty
	public boolean isEmpty() {

		if (this.carList.isEmpty()) {

			return true;

		}
		return false;
	}

	// method for when the list is at full capacity
	public boolean isFull() {

		if (carList.size() == capacity) {
			System.out.println("Showroom is full");

			return true;
		}

		return false;
	}

	// add car method
	public void addCar(Car c) {

		// if the showroom is full print
		if (carList.size() > capacity) {

		} else {

			// if theres room in the showroom, add more cars
			carList.add(c);

		}
	}

	// method for when buyer takes car from showroom
	public Car takeCar() {

		// removes first car in the list
		car = carList.get(0);

		carList.remove(0);

		return car;
	}

}
