package enterpriseAss2;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Seller implements Runnable {

	CarShowroom showroom;
	Car car;

	// Atomic integer ensuring seller is assigned unique buyer number ID (sn)
	private static AtomicInteger sn = new AtomicInteger(1);
	// atomic integer to count number of sales
	private static AtomicInteger purchase = new AtomicInteger(1);

	Random rand = new Random();

	// seller constructor
	public Seller() {

		this.car = new Car();
		this.showroom = new CarShowroom();
	}

	public Seller(CarShowroom c) {
		this.car = new Car();

		this.showroom = c;
	}

	// run method
	public void run() {

		synchronized (showroom) {

			// Assign each new seller a new ID
			int sellID = sn.getAndIncrement();

			// new seller arrives to showroom and sells their car
			System.out
					.print("A new seller #" + sellID + " just appeared with a " + this.car.toString() + " to sell \n");
			System.out.print("Seller #" + sellID + " sold their " + this.car.toString() + " to the showroom \n");

			System.out.println("this is sale number #" + purchase + "\n");
			// increment sale number
			purchase.getAndIncrement();

			// if the showroom is full ie. capacity is 5
			while (showroom.isFull()) {

				try {

					// when showroom is full seller has to wait
					System.out.print("Seller #" + sellID + " wants to sell their car, but the showroom is full \n");
					showroom.wait();

				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}

			// add car to showroom
			showroom.addCar(car);

			// wake other threads
			showroom.notifyAll();

		}

	}
}

