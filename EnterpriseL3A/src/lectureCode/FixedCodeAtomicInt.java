package lectureCode;

import java.util.concurrent.atomic.AtomicInteger;
//This code does not create race conditions.
//It's fine to use an instance of AtomicInteger outside a synchronized block, as it provides methods for atomic operations.
public class FixedCodeAtomicInt implements Runnable {

	// AtomicInteger can be used for atomically incremented (i.e. thread safe) counters
	// https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/AtomicInteger.html
	private AtomicInteger gc = new AtomicInteger(0); 

	public void init() { // we create the threads from within a method in the task class (that's fine)
		Thread t;
		for(int i=1; i<=100; i++) { // create some threads
			t = new Thread(this); 
			t.start(); // launches the new thread
		}
	}

	public void run() {
		// getAndIncrement() is an atomic operation that increments gc and returns the previous (not incremented) value
		// Note how this allows us to avoid wrapping the code in run() in a synchronized block
		int uniqueThreadNumber = gc.getAndIncrement(); 
		System.out.println("Setting uniqueThreadNumber to " + uniqueThreadNumber );
	}
}
