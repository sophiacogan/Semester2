package ie.nuigalway.a1_16366736;

public abstract class Shape {

	private String name;
	private double area;

	public Shape() {
		name = "unasigned";
		area = 0;

	}

	public Shape(String name, double area) {
		this.name = name;
		this.area = area;

	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

	}

	@Override

	// to String for shapes
	public String toString() {
		return getName() + ", its area is = " + getArea() + "\n";
	}
}