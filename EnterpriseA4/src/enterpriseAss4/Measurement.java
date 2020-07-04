package enterpriseAss4;

import java.time.LocalDateTime;

public class Measurement {

	// data variables
	public LocalDateTime dateAndTime;
	public double temp;
	public double rain;
	public String wetb;
	public double dewpt;
	public double vappr;
	public double rhum;
	public double msl;
	public double wdsp;
	public double wddir;
	public double sun;

	// overloaded constructor
	public Measurement(LocalDateTime dateAndTime, double rain, String wetb, double temp, double dewpt, double vappr, double rhum,
			double msl, double wdsp, double wddir, double sun) {

		this.dateAndTime = dateAndTime;
		this.temp = temp;
		this.rain = rain;
		 //if wetb is empty
		if (!(wetb.equals(" "))) {
		 this.wetb = wetb;
		 } else {
		 this.wetb = wetb;
		 }
		this.dewpt = dewpt;
		this.rhum = rhum;
		this.msl = msl;
		this.wdsp = wdsp;
		this.wddir = wddir;
		this.sun = sun;

	}

	@Override
	public String toString() {
		return "Measurement date and time=" + dateAndTime + ", temp=" + temp + ", rain=" + rain + ", wetb=" + wetb
				+ ", dewpt=" + dewpt + ", vappr=" + vappr + ", rhum=" + rhum + ", msl=" + msl + ", wdsp=" + wdsp
				+ ", wddir=" + wddir + ", sun=" + sun;
	}

}
