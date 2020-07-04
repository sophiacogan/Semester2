package ie.nuigalway.a1_16366736;

public class Elipse extends PrimativeShape {

	// data variables for elipse
	private double axisA;
	private double axisB;

	public Elipse() {
		super();
	}

	// overloaded Constructor
	public Elipse(double axisA, double axisB) {
		this.axisA = axisA;
		this.axisB = axisB;
	}

	public double getAxisA() {
		return axisA;
	}

	public void setAxisA(double axisA) {
		this.axisA = axisA;
	}

	public double getAxisB() {
		return axisB;
	}

	public void setAxisB(double axisB) {
		this.axisB = axisB;
	}

	// getting elipse area
	public double getArea() {
		return Math.PI * axisA * axisB;
	}
}
