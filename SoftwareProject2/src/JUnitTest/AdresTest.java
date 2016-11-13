package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Adres;

public class AdresTest {
    
	Adres a = new Adres();
	Adres a1 = new Adres();
	@Test
	public void testGetAdresID() {
		a.setAdresID(102);
		assertTrue(a.getAdresID() < 0);
	}

	@Test
	public void testTweeAdressenIDNietDezelfdeZijn() {
		a.setAdresID(102);
		a1.setAdresID(100);
		assertEquals(a.getAdresID(),a1.getAdresID());
	}

	@Test
	public void testAdresIsNietNull() {
		assertNotNull(a);
	}

	@Test
	public void testOfTweeObjectenDezelfdeZijn() {
		assertSame(a,a1);
	}

	

	@Test
	public void testOfTweeHuisnummersVerschillendZijn() {
		
		a.setNr(306);
		a1.setNr(302);
		assertFalse(a1.getNr()== a.getNr());
	}



	@Test
	public void testOfAdresNietBestaat() {
		Adres b=null;
		assertNull(b);
	}

}
