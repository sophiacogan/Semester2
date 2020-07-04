package lectureCode;

public class FixedCodeSynchronised implements Runnable {


//This code does not create race conditions. Note that the block in the run() method is synchronized on this
//public class FixedCodeSynchronized implements Runnable {

	private int gc = 0; // we need this to generate "unique" numbers

	public void init() { // we create the threads from within a method in the task class (that's fine)
		Thread t;
		for(int i=1; i<=100; i++) { // create some threads
			t = new Thread(this); 
			t.start(); // launches the new thread
		}
	}
	
	public void run() {
		synchronized(this) {  // forbids concurrent access of the following block (the "critical section")
			  int uniqueThreadNumber = gc;
			  System.out.println("Setting uniqueThreadNumber to " + uniqueThreadNumber );
			  gc = gc + 1;
		}
	}
}
