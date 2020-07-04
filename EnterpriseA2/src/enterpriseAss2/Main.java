package enterpriseAss2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

	// static Random rand = new Random(System.currentTimeMillis());
	static Random rand = new Random();
	// this.showroom = new CarShowroom();

	public static void main(String[] args) throws InterruptedException {
		CarShowroom carshowroom = new CarShowroom();

		int i = 1;

		// while loop that iterates for 30 days
		while (i < 31) {

			System.out.println("\n---------------------------Day " + i + " beginning---------------------------");
			System.out.println("There are " + carshowroom.getSize() + " cars in the showroom today \n");

			// set random number of sellers (0-3)
			int n = rand.nextInt(3);

			for (int j = 0; j < n; j++) {
				Seller sell = new Seller(carshowroom);

				// create Seller thread
				Thread t = new Thread(sell);
				// start seller thread
				t.start();

			}
			// set random number of buyers (0-3)
			int m = rand.nextInt(3);

			for (int j = 0; j < m; j++) {
				Buyer buy = new Buyer(carshowroom);

				// create buyer thread
				Thread t = new Thread(buy);
				// start buyer thread
				t.start();

			}

			// increment number of days
			i++;

			// delay at the end of each day to slow down execution
			TimeUnit.SECONDS.sleep(1);
		}

	}

}


