package IO;

import Models.ReleaseHistory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.Scanner;


public class RHParser {

	private static ReleaseHistory rh;
	/**
	 * 
	 * @param fname 
	 * @return 
	 */
	public static ReleaseHistory getReleaseHistory(String fname) throws IOException { 
        String fileName = "/Users/kabamaru/empty.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        
        scanner.useDelimiter(System.getProperty("line.separator"));
        
        rh = new ReleaseHistory(getRHName(scanner));
        RHParser.getInitialRelease(scanner);
        //Read the initial release
        
        scanner.close();
        return rh;
	 }
	
	 private static String getRHName(Scanner scanner) {
		 Scanner lScanner = new Scanner(scanner.next());
         lScanner.useDelimiter(";");
         //Moving forwards
         lScanner.next();
         //Getting the name
         String name = lScanner.next();
         lScanner.close();
         return name;
	 }
	 
	 private static void getInitialRelease(Scanner scanner) {
		 int id = 1;
		 int[] op = {0, 0, 0};
		 int[] ds = {0, 0, 0};
		 int opPrTot = 0;
		 int dsPrTot = 0;
		 Date date;
		 Date prDate;
		 
         // Read the initial operations line
		 Scanner lScanner = new Scanner(scanner.next());
         lScanner.useDelimiter(";");
         lScanner.next(); // Skipping the text
         op[0] = lScanner.nextInt();
         lScanner.close();

         // Read the initial data structures line
		 lScanner = new Scanner(scanner.next()); 
         lScanner.next(); // Skipping the text
         ds[0] = lScanner.nextInt();
         lScanner.close();

         // Read the date
         scanner.next(); // skip the header line
		 lScanner = new Scanner(scanner.next());
         lScanner.next(); // Skipping the id
         date = parseDate(lScanner.next());
         prDate = date;
         lScanner.close();

         rh.addRelease(id, date, op, ds, opPrTot, dsPrTot, prDate);
	 }
	 
	 private static Date parseDate(String date) {
		return null;
		 
	 }
}
