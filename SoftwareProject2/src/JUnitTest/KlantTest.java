package JUnitTest;

import static org.junit.Assert.*;


import java.util.Calendar;

import org.junit.Test;

import model.Adres;
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
		 k1.setKlantID(101);
       k2.setKlantID(100);
       Integer a= k1.getKlantID();
       Integer b =k2.getKlantID();
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
		//assertTrue( ( d.YEAR - k2.getGeboortedatum().getYear())>=18);
	}

	@Test
	public void testOfTweetelefoonNummersDezelfdeZijn() {
		k1.setTelefoonnummer(489456302);
	 k2.setTelefoonnummer(487520921);
	assertTrue(k1.getTelefoonnummer()==k2.getTelefoonnummer());
	
		
	}


}
