package ie.nuigalway.a1_16366736;

import java.util.*;

public class ShapesTester {

	public static void main(String[] args) {

		// create hash set
		HashSet<Shape> h = new HashSet<Shape>();
		// LinkedList<Shape> h = new LinkedList<Shape>();

		// creating shapes and adding them to hash set
		Circle c1 = new Circle(3);
		c1.setName("circle 1");
		// adding shape to hash set
		h.add(c1);
		// testing that the same shape isnt added twice
		h.add(c1);

		// new rectangle
		Rectangle r1 = new Rectangle(5.5, 4);
		r1.setName("Rectangle 1");
		h.add(r1);

		Rectangle r2 = new Rectangle(10, 6);
		r2.setName("Rectangle 2");
		h.add(r2);

		// new triangle
		Triangle t1 = new Triangle(10, 2);
		t1.setName("Triangle 1");
		h.add(t1);

		Triangle t2 = new Triangle(14, 6);
		t2.setName("Triangle 2");
		h.add(t2);

		// new elipse
		Elipse e1 = new Elipse(6, 8);
		e1.setName("Elipse 1");
		h.add(e1);

		// creating composite shape
		CompositeShape cs1 = new CompositeShape();
		cs1.setName("Composite Shape 1");

		// adding shapes to composite shape
		cs1.addCShape(c1);
		// testing to see if the same shape will be added twice to composite shape
		cs1.addCShape(c1);
		cs1.addCShape(r1);
		cs1.addCShape(t1);

		// adding composite shape 1 to hash set
		h.add(cs1);

		CompositeShape cs2 = new CompositeShape();
		cs2.setName("Composite Shape 2");
		cs2.addCShape(c1);
		cs2.addCShape(r1);
		cs2.addCShape(t1);
		// adding composite shape to composite shape
		cs2.addCShape(cs1);
		h.add(cs2);

		// printing out hash set info
		System.out.println("Shapes in hash set");
		System.out.print("-------------------" + "\n");
		// for loop for Printing out shapes in hash set
		for (Shape s : h) {
			System.out.println(s);
		}
		// printing out the number of shapes in each composite shape
		System.out.println(cs1.getName() + " has " + cs1.getSize() + " shapes");
		System.out.println(cs2.getName() + " has " + cs2.getSize() + " shapes");

	}
}