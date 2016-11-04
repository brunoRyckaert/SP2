package JUnitTest;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.junit.Test;

import model.Klant;

public class KlantTest {
      Klant k1= new Klant();
      Klant k2= new Klant();
	@Test
	public void testKlantIsNietNull() {
		assertNotNull(k1);
		assertNull(null);
	}

	@Test
	public void testOfTweeKlantenDezelfdeZijn() {
		 k1.setKlantNummer(101);
       k2.setKlantNummer(100);
       Integer a= k1.getKlantNummer();
       Integer b =k2.getKlantNummer();
		assertTrue(a.equals(b));
	}

	

	@Test
	public void testVoornaamIsgegeven() {
		k1.setVoornaam("");
		assertFalse(k1.getNaam().isEmpty());
	}


	@Test
	public void testGetVoornaam() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetVoornaam() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsPersoonMinstens18() {
		
		Calendar d =Calendar.getInstance();
	    d.setTime(d.getTime());
		Calendar c = Calendar.getInstance();
		c.set(1996,05,23);
		k2.setGeboortedatum(c);
		//Ik zoek nog een manier om dit testje nauwkeuriger te maken..
		assertTrue( ( d.YEAR - k2.getGeboortedatum().YEAR)>=18);
	}

	@Test
	public void testOfTweetelefoonNummersDezelfdeZijn() {
		k1.setTelefoonNummer(489456302);
	 k2.setTelefoonNummer(487520921);
	assertTrue(k1.getTelefoonNummer()==k2.getTelefoonNummer());
	
		
	}


}
