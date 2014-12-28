package IO;

import java.io.IOException;
import java.text.ParseException;

import Models.ReleaseHistory;

import org.junit.Test;

import static org.junit.Assert.*;

public class RHParserTest {

	@Test
	public void testReadingCorrectFile() {
		try {
			ReleaseHistory rh = RHParser.getReleaseHistory("src/test/resources/AmazonMechTurk.txt");
			assertEquals("Wrong number of releases", 20, rh.getReleases().size());
		} catch (IOException e) {
			  fail("Threw Exception: " + e.toString());
		} catch (ParseException e) {
			  fail("Threw Exception: " + e.toString());
		}
	}

	@Test(expected = Exception.class)  
	public void testReadingErroneousFile() throws IOException, ParseException {
		RHParser.getReleaseHistory("src/test/resources/empty.txt");
	}
}
