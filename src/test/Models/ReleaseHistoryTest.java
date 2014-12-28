package Models;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import IO.RHParser;

public class ReleaseHistoryTest {

	private static ReleaseHistory rh;
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
	public void testGetChangesData() {
		Map<Integer, Integer> opMap = rh.getChangesData(ReleaseInfo.operations);
		Map<Integer, Integer> dsMap = rh.getChangesData(ReleaseInfo.dataStructures);

		for (int i = 0; i < 20; i++) {
			int id = rh.getReleaseByID(i + 1).getId();
			int op = opMap.get(id);
			assertEquals("Wrong number of operations change data in index " + (i + 1), opChg[i], op);
			
			int ds = dsMap.get(id);
			assertEquals("Wrong number of DS change data in index " + (i + 1), dsChg[i], ds);
		}
	}

}
