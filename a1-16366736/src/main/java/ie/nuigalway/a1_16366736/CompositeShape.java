package ie.nuigalway.a1_16366736;

import java.util.*;

//composite shape extends Shape
public class CompositeShape extends Shape {

	// create a hash set to insure everything is unique in comp Shape
	private HashSet<Shape> cShape;

	public CompositeShape() {
		cShape = new HashSet<Shape>();
	}

	public HashSet<Shape> getCShape() {
		return cShape;

	}

	// method for adding shapes to composite shape
	public void addCShape(Shape s) {
		cShape.add(s);
	}

	// method for getting the size (number of shapes) in composite shape
	public int getSize() {
		return cShape.size();
	}

	@Override
	// method for getting the area of composite shapes
	public double getArea() {
		double area = 0;
		for (Shape s : cShape) {
			area += s.getArea();
		}
		return area;
	}

}
