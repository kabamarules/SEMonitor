package Models;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.BeforeClass;
import org.junit.Test;

import IO.RHParser;

public class MetricsRecordTest {

	private static ReleaseHistory rh;
	private static int[] opAdd = {0, 2, 2, 2, 1, 0, 5, 1, 0, 1, 0, 5, 0, 0, 1, 0, 0, 2, 3, 3};
	private static int[] opDel = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 2, 0};
	private static int[] dsAdd = {0, 9, 9, 12, 4, 0, 21, 5, 0, 4, 0, 21, 0, 0, 6, 0, 0, 9, 20, 14};
	private static int[] dsDel = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 2, 5, 0};
	private static int inOp = 21;
	private static int inDS = 105;
	
	@BeforeClass
	public static void oneTimeSetUp() {
		try {
			rh = RHParser.getReleaseHistory("src/test/resources/AmazonMechTurk.txt");
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTotalNumber() {
		
		for (int i = 0; i < 20; i++) {
			inOp += opAdd[i] - opDel[i];
			int op = rh.getReleaseInformation(i + 1).getOperationMetrics().getTotalNumber(); // numbering from 1
			assertEquals("Wrong number of total operations in release " + (i + 1), inOp, op);
			
			inDS += dsAdd[i] - dsDel[i];
			int ds = rh.getReleaseInformation(i + 1).getDSMetrics().getTotalNumber(); // numbering from 1
			assertEquals("Wrong number of total DS in release " + (i + 1), inDS, ds);
		}
	}

}
