package lab12;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * This program demonstrate reading byte-based data as it intended type 
 * it is using DataInputStream.
 * 
 * The data represent a 6 days reading of daily rainfall from station Simpang Ampat in Alor Gajah district
 * 
 * The program calculates the average 6 days reading of daily rainfall and display it on the console.
 * 
 * @author raszreen
 *
 */
public class RainfallReader {

	public RainfallReader(FileInputStream fileInputStream) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		// 1. Declare output file 
		String sourceFile = "rainFallSimpatAmpat.txt";
		System.out.println("Reading data from " + sourceFile + "\n");

		try {

			// 2. Create stream to read data
			DataInputStream dis = new DataInputStream(new FileInputStream(sourceFile));

			// Variables for processing byte-based data
			double dailyRainfall = 0;
			double TotalRainfall = 0;
			int noOfRecords = 0;
			String state = "";
			
			// 3. Process data until end-of-file
			while(dis.available() > 0) {
				
				// Read data
				state = dis.readUTF();
				dailyRainfall = dis.readDouble();
				System.out.println( state + "\t" + dailyRainfall);
				
				// Calculate total utilization
				TotalRainfall += dailyRainfall;
				noOfRecords ++;
			}
			
			// 4. Close stream
			dis.close();
			
			// Calculate average dailyRainfall
			double averagedailyRainfall = TotalRainfall / noOfRecords;
			String formattedAverage = String.format("%.1f", averagedailyRainfall);
			System.out.print("\nAverage daily Rainfall for " + noOfRecords 
					+ " days: " + formattedAverage + "%");
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// Indicate end of program - Could be successful
		System.out.println("\nEnd of program.");
		

	}


}
