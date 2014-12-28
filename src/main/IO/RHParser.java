package IO;

import Models.ReleaseHistory;
import Models.ReleaseInformation;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class RHParser {

	/**
	 * Parses a file and returns a ReleaseHistory object
	 * @param fname 
	 * @return 
	 * @throws ParseException 
	 */
	public static ReleaseHistory getReleaseHistory(String fileName) throws IOException, ParseException { 
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
               
        ReleaseHistory rh = new ReleaseHistory(getRHName(scanner));
        RHParser.addInitialRelease(rh, scanner);
        RHParser.addReleases(rh, scanner);
        
        scanner.close();
        return rh;
	 }
	
	 private static String getRHName(Scanner scanner) throws IOException {
		 Scanner lScanner = new Scanner(scanner.nextLine());
         lScanner.useDelimiter(";");

         //Moving forwards
         lScanner.next();
         //Getting the name
         String name = lScanner.next();
         lScanner.close();
         return name;
	 }
	 
	 private static void addInitialRelease(ReleaseHistory rh, Scanner scanner) throws IOException, ParseException {
		 int id = 1;
		 int[] op = {0, 0, 0};
		 int[] ds = {0, 0, 0};
		 int opPrTot;
		 int dsPrTot;
		 Date date;
		 Date prDate;
		 
         // Read the initial operations line
		 Scanner lScanner = new Scanner(scanner.nextLine());
         lScanner.useDelimiter(";");
         lScanner.next(); // Skipping the text
         opPrTot = lScanner.nextInt();
         lScanner.close();

         // Read the initial data structures line
		 lScanner = new Scanner(scanner.nextLine()); 
         lScanner.useDelimiter(";");
         lScanner.next();// Skipping the text
         dsPrTot = lScanner.nextInt();
         lScanner.close();

         // Read the date
         scanner.nextLine(); // skip the header line
		 lScanner = new Scanner(scanner.nextLine());
         lScanner.useDelimiter(";");
         lScanner.next(); // Skipping the id
         date = parseDate(lScanner.next());
         prDate = date;
         lScanner.close();

         rh.addRelease(id, date, op, ds, opPrTot, dsPrTot, prDate);
	 }
	 
	 private static void addReleases(ReleaseHistory rh, Scanner scanner) throws IOException, ParseException {
		 while (scanner.hasNextLine()) {
			 int id;
			 int[] op = new int[3]; 
			 int[] ds = new int[3]; 
			 Date date;
			 
			 Scanner lScanner = new Scanner(scanner.nextLine());
	         lScanner.useDelimiter(";");

	         id = lScanner.nextInt(); // id
	         //System.out.println(id);
	         date = parseDate(lScanner.next()); // date
	         for (int i = 0; i < 3; i++) { // operations
	        	 op[i] = lScanner.nextInt();
	         }
	         for (int i = 0; i < 3; i++) { //data structures
	        	 ds[i] = lScanner.nextInt();
	         }
	         lScanner.close();
	         
	         // Get previous release data
	         ReleaseInformation ri = rh.getReleaseInformation(id - 1);
			 int opPrTot = ri.getOperationMetrics().getTotalNumber();
			 int dsPrTot = ri.getDSMetrics().getTotalNumber();
			 Date prDate = ri.getDate();
			 
	         rh.addRelease(id, date, op, ds, opPrTot, dsPrTot, prDate);
		 }
	 }
	 
	 private static Date parseDate(String str) throws ParseException{
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(str); 
	 }
}
