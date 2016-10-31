package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Settings;

public class SettingsTest {
   //Deze code was genomen van http://stackoverflow.com/questions/14077842/how-to-test-a-private-constructor-in-java-application
	Constructor<Util> c = Utils.class.getDeclaredConstructor();
	c.setAccessible(true);
	Utils u = c.newInstance();
	Settings s = new Settings();
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
