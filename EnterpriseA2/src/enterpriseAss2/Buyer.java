package enterpriseAss2;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Buyer implements Runnable {

	CarShowroom showroom;
	Car car;
	int saleNumber;

	// Atomic integer ensuring buyer is assigned unique buyer number ID (bn)
	private static AtomicInteger bn = new AtomicInteger(1);

	Random rand = new Random();

	public Buyer() {

		// creating car showroom
		this.showroom = new CarShowroom();

	}

	public Buyer(CarShowroom c) {

		this.showroom = c;
	}

	// run method
	public void run() {

		try {

			// call buy car method
			buyCar();

		}

		// exception handler
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	// buyCar method
	public void buyCar() {

		// synchronized to ensure multiple threads access the same showroom
		synchronized (showroom) {

			// incrementing buyer number
			int buyID = bn.getAndIncrement();

			System.out.print("A new buyer #" + buyID + " just appeared \n");

			// while method if showroom is empty
			while (showroom.isEmpty()) {

				try {
					System.out.print("Buyer #" + buyID + " wants to buy a car but the showroom is empty \n");
					// buyer has to wait for a car to become available
					showroom.wait();

				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}

			// calling take car method
			Car car = showroom.takeCar();

			// statement giving info on the buyer and car just purchased
			System.out.println("Buyer " + buyID + " bought " + car.toString() + " from the showroom");

			// wakes all other threads
			showroom.notifyAll();

		}

	}

}
