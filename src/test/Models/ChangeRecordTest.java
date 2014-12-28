package Models;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.BeforeClass;
import org.junit.Test;

import IO.RHParser;

public class ChangeRecordTest {

	private static ReleaseHistory rh;
	private static int[] opAdd = {0, 2, 2, 2, 1, 0, 5, 1, 0, 1, 0, 5, 0, 0, 1, 0, 0, 2, 3, 3};
	private static int[] opDel = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 2, 0};
	private static int[] dsAdd = {0, 9, 9, 12, 4, 0, 21, 5, 0, 4, 0, 21, 0, 0, 6, 0, 0, 9, 20, 14};
	private static int[] dsDel = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 2, 5, 0};
	private static int[] opChg = {0, 9, 5, 8, 8, 0, 6, 1, 0, 4, 0, 35, 0, 0, 1, 0, 0, 1, 5, 7};
	private static int[] dsChg = {0, 23, 10, 19, 20, 0, 14, 4, 0, 11, 0, 36, 0, 0, 3, 0, 1, 3, 13, 17};
	
	@BeforeClass
	public static void oneTimeSetUp() {
		try {
			rh = RHParser.getReleaseHistory("src/test/resources/AmazonMechTurk.txt");
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAdditions() {
		for (int i = 0; i < 20; i++) {
			int op = rh.getReleaseInformation(i + 1).getChangesRecord(ReleaseInfo.operations).getAdditions();
			assertEquals("Wrong number of operations additions in release " + (i + 1), opAdd[i], op);
			
			int ds = rh.getReleaseInformation(i + 1).getChangesRecord(ReleaseInfo.dataStructures).getAdditions();
			assertEquals("Wrong number of DS additions in release " + (i + 1), dsAdd[i], ds);
		}
	}
	
	@Test
	public void testGetDeletions() {
		for (int i = 0; i < 20; i++) {
			int op = rh.getReleaseInformation(i + 1).getChangesRecord(ReleaseInfo.operations).getDeletions();
			assertEquals("Wrong number of operations deletion in release " + (i + 1), opDel[i], op);
			
			int ds = rh.getReleaseInformation(i + 1).getChangesRecord(ReleaseInfo.dataStructures).getDeletions();
			assertEquals("Wrong number of DS deletions in release " + (i + 1), dsDel[i], ds);
		}
	}
	
	@Test
	public void testGetChanges() {
		for (int i = 0; i < 20; i++) {
			int op = rh.getReleaseInformation(i + 1).getChangesRecord(ReleaseInfo.operations).getChanges();
			assertEquals("Wrong number of operations changes in release " + (i + 1), opChg[i], op);
			
			int ds = rh.getReleaseInformation(i + 1).getChangesRecord(ReleaseInfo.dataStructures).getChanges();
			assertEquals("Wrong number of DS changes in release " + (i + 1), dsChg[i], ds);
		}
	}
}
