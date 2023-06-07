package lab12;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

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

public class RainfallGenerator {

	public static void main(String[] args) {
		
		
		// 1. Declare output file 
		String outFile = "rainFallSimpatAmpat.txt";
		
		// Data declaration
		String days[] = {"2/6","3/6","4/6","5/6","6/6","7/6"};
		double dailyRainfall[] = {0.0, 4.0, 1.0, 0.0, 6.0, 19.0};
		
		try {
			
			// 2. Create stream to read data
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(outFile));
			
			// Process data
			for (int index = 0; index < days.length; index++) {
				
				// 3. Write data into data stream
				dos.writeUTF(days[index]);
				dos.writeDouble(dailyRainfall[index]);
				
				// 4. Flush for each writing
				dos.flush();
			}
			
			// 5. Close stream
			dos.close();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		// Indicate end of program - Could be successful
		System.out.println("End of program. Check out " + outFile); 
	}


}
