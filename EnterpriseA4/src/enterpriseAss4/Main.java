package enterpriseAss4;
//imports
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		// create a date format
		DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
		builder.parseCaseInsensitive();
		builder.appendPattern("d-MMM-yyyy HH:mm");
		DateTimeFormatter dateFormat = builder.toFormatter();

		// create an array list to hold measurements
		ArrayList<Measurement> list = new ArrayList<Measurement>();

		// assign csv file to a string
		String txtFileName = "hly3723.csv";

		// buffered reader to read in the csv file
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(txtFileName))) {
			// for loop to skip the first 23 lines
			for (int i = 0; i < 24; i++) {
				reader.readLine();
			}
			// line data reads in lines from csv file
			String lineData = reader.readLine();

			while (lineData != null) {

				if (!lineData.isEmpty()) {

					// split values by ,
					String[] lists = lineData.split(",");

					// parse in variables and their index numbers in csv file
					LocalDateTime dateAndTime = LocalDateTime.parse(lists[0], dateFormat);
					double rain = Double.parseDouble(lists[2]);
					double temp = Double.parseDouble(lists[4]);
					String wetb = (lists[6]);
					double dewpt = Double.parseDouble(lists[7]);
					double vappr = Double.parseDouble(lists[8]);
					double rhum = Double.parseDouble(lists[9]);
					double msl = Double.parseDouble(lists[10]);
					double wdsp = Double.parseDouble(lists[12]);
					double wddir = Double.parseDouble(lists[14]);
					double sun = Double.parseDouble(lists[17]);

					// overloaded constructor
					Measurement measurement = new Measurement(dateAndTime, rain,wetb, temp, dewpt, vappr, rhum, msl, wdsp,
							wddir, sun);

					// add measurement values to list
					list.add(measurement);

				}
				lineData = reader.readLine();
			}
		}

		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		// LAMBDA EXPRESSIONS
		// calculating the maximum temperature
		OptionalDouble maxTemp = list.stream().mapToDouble(measurement -> measurement.temp).max();
		System.out.println("\t Q1. Maximum temperature recorded is: " + maxTemp.getAsDouble());

		// calculating average sunshine hours
		OptionalDouble avgSun = list.stream().mapToDouble(measurement -> measurement.sun).average();
		System.out.println("\t Q2. The average amount of sunshine per hour in the dataset is: " + avgSun.getAsDouble());

		// calculating total rainfall
		double rainfall = list.stream().mapToDouble(measurement -> measurement.rain).sum();
		System.out.println("\t Q3. The total amount of rainfall over all the datapoints " + rainfall);

		// Calculating November sun
		double temp = list.stream().filter(measurement -> measurement.dateAndTime.getMonthValue() == 11
				&& measurement.dateAndTime.getYear() == 2001).mapToDouble(measurement -> measurement.sun).sum();

		System.out.println("\t Q4. Total sunshine hours in November 2001 " + temp);

		// Calculating rainfall over 5mm
		Predicate<Measurement> numData = measurement -> measurement.rain > 5.0;
		double rainData = list.stream().filter(numData).mapToDouble(measurement -> measurement.rain).count();
		System.out.println("\t Q5. The number of hours where rainfall was greater than 5mm " + rainData);

		// Calculating sea pressure over 1047.2hPa

		List<Measurement> mslVals = list.stream().filter(measurement -> measurement.msl > 1047.2)
				.collect(Collectors.toList());
		System.out.println("\t Q6. The list of dates and times when Main Sea level pressure exceeded 1047.2hPa ");

		// printing out the values using the correct date format
		mslVals.forEach(val -> System.out.println("\t \t" + dateFormat.format(val.dateAndTime)));

	}

}