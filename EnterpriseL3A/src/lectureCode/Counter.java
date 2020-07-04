package lectureCode;

public class Counter implements Runnable { // the task class
	private int totalCounterNum = 0, limit = 3;

	private void pause(double seconds) {
		try {
			Thread.sleep(Math.round(1000*seconds));
		}
		catch(InterruptedException e) {
			// do something with the caught exception
		}
	}

	public void run() { // the task (the code the respective thread should execute)
		int counterNum = totalCounterNum++; 
		for(int i=0; i<=limit; i++) {
			System.out.printf("Counter %s: %s\n",counterNum, i);
			pause(Math.random()); 
		}
	} 
}
