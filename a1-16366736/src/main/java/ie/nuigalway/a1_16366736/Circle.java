package ie.nuigalway.a1_16366736;

public class Circle extends PrimativeShape {

	private double radius;

	// default constructor
	public Circle() {
		super();
	}

	public Circle(double radius) {

		this.radius = radius;

	}

	// getters and setters for radius
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	// getting Circle area
	public double getArea() {
		return Math.PI * radius * radius;
	}

}
