package IO;

import java.io.FileWriter;
import java.io.IOException;

import Models.ReleaseHistory;

public class ReportGenerator {

	/**
	 * 
	 * @param rh 
	 * @param fname 
	 * @throws IOException 
	 */
	public static void saveReport(ReleaseHistory rh, String fname) throws IOException { 
		FileWriter fr = new FileWriter(fname + ".html");

	} 

}
