package assignment1;

import java.util.Scanner;
import java.text.DecimalFormat;

public class TicketSales {

public static void main(String[] args) {
	
	//Data Members
	int seatA, seatB, seatC;
	double priceA, priceB, priceC, totalSales;
	
	//creating scanner and decimal format
	Scanner sc = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("0.00");

	try {
		System.out.println("Enter number of A seats sold:");
		seatA = sc.nextInt();
		System.out.println("Enter price of A tickets:");
		priceA =sc.nextDouble();
		System.out.println("Enter number of B seats sold:");
		seatB = sc.nextInt();
		System.out.println("Enter price of B tickets:");
		priceB = sc.nextDouble();
		System.out.println("Enter number of C seats sold:");
		seatC = sc.nextInt();
		System.out.println("Enter price of C tickets:");
		priceC =sc.nextDouble();
		//Calculating total sales
		totalSales = ((seatA * priceA) + (seatB * priceB) + (seatC * priceC));
		
		//displaying Ticket Sales
		System.out.println( "\n \t \t" + "Tickets Sold " +"\t" + "Price Per Ticket");
		System.out.print( "\n" + "A Tickets: " +"\t" + seatA +"\t \t" + priceA);
		System.out.print( "\n" + "B Tickets: " +"\t" + seatB +"\t \t" + priceB);
		System.out.println( "\n" + "C Tickets: " +"\t" + seatC +"\t \t" + priceC);
		System.out.println("\n \t"+"Total Sales €"+ totalSales);
	}finally {
		
		//close scanner
			sc.close();
			
		
		}
}//end method
}//end class
	
	
