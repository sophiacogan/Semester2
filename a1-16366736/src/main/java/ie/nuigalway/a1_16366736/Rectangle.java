package ie.nuigalway.a1_16366736;

public class Rectangle extends Polygon {

	// declare variables
	private double base;
	private double height;

	public Rectangle() {
		super();

	}

	public Rectangle(double base, double height) {
		this.base = base;
		this.height = height;
	}

	// getters and setters
	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	// get area method
	public double getArea() {
		return base * height;
	}
}
