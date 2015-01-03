import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


public class DiadFrequencyTest {

	@Test
	public void test() throws IOException {
		//fail("Not yet implemented");
		DiadFrequency test = new DiadFrequency("names.txt");
		test.reader("names.txt");
	}

}
