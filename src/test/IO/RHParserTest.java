package IO;

import java.io.IOException;
import java.text.ParseException;

import Models.ReleaseHistory;

import org.junit.Test;
import static org.junit.Assert.*;

public class RHParserTest {

	@Test
	public void testReadingSampleFile() {
		try {
			ReleaseHistory rh = RHParser.getReleaseHistory("src/test/resources/AmazonMechTurk.txt");
			
		} catch (IOException e) {
			  fail("Threw Exception: " + e.toString());
		} catch (ParseException e) {
			  fail("Threw Exception: " + e.toString());
		}
	}

}
