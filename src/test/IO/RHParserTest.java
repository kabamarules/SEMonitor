package IO;

import java.io.IOException;
import java.text.ParseException;

import Models.ReleaseHistory;

import org.junit.Test;
import static org.junit.Assert.*;

public class RHParserTest {

	@Test
	public void testReadingSampleFile() {
		int[] opAdd = {0, 2, 2, 2, 1, 0, 5, 1, 0, 1, 0, 5, 0, 0, 1, 0, 0, 2, 3, 3};
		int[] opDel = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 2, 0};
		int[] dsAdd = {0, 9, 9, 12, 4, 0, 21, 5, 0, 4, 0, 21, 0, 0, 6, 0, 0, 9, 20, 14};
		int[] dsDel = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 2, 5, 0};
		
		try {
			ReleaseHistory rh = RHParser.getReleaseHistory("src/test/resources/AmazonMechTurk.txt");

			assertEquals("Wrong number of releases", 20, rh.getReleases().size());
			
			int inOp = rh.getReleaseInformation(1).getOperationMetrics().getTotalNumber();
			int inDS = rh.getReleaseInformation(1).getDSMetrics().getTotalNumber();
			
			for (int i = 0; i < 20; i++) {
				inOp += opAdd[i] - opDel[i];
				int op = rh.getReleaseInformation(i + 1).getOperationMetrics().getTotalNumber(); // numbering from 1
				assertEquals("Wrong number of total operations in release " + (i + 1), inOp, op);
				
				inDS += dsAdd[i] - dsDel[i];
				int ds = rh.getReleaseInformation(i + 1).getDSMetrics().getTotalNumber(); // numbering from 1
				assertEquals("Wrong number of total DS in release " + (i + 1), inDS, ds);
			}
			
		} catch (IOException e) {
			  fail("Threw Exception: " + e.toString());
		} catch (ParseException e) {
			  fail("Threw Exception: " + e.toString());
		}
	}

}
