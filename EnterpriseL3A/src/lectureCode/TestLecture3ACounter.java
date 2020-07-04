package lectureCode;

public class TestLecture3ACounter {


	public static void main(String[] args) {
		  Counter c = new Counter();		
		  for(int i=0; i<4; i++) { // create three simultaneous threads
				Thread t = new Thread(c);
				t.start(); // starts the thread
		   }
	}
}
