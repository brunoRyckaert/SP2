package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Ticket;

public class TicketTest {
    Ticket t = new Ticket();
    Ticket t1 = new Ticket();
    
    @Test
    public void testofNullObject(){
    	assertNull(t);
    }
	@Test
	public void testOfTweeTicketsGelijkZijn() {
		assertNotNull(t);
		assertNotNull(t1);
		t.setTicketID(100);
		t1.setTicketID(101);
		assertTrue(t==t1);
		
	}

	@Test
	public void testOfKortingDezelfdeIsAlsPrijs() {
		t.setKorting(50);
		t.setPrijs(120);
		assertTrue((t.getKorting()* t.getPrijs()/(100))==t.getPrijs());
	}
	
	
	@Test
	public void testOfTweeDatumsGelijkZijn(){
		t.setHeenDatum("04.11.2016");
		t1.setHeenDatum("05.12.2016");
		assertFalse(t.getHeenDatum().equals(t1.getHeenDatum()));
	}

	

	@Test
	public void testAantalReizigersIsPositief() {
		t.setAantalReizigers(15);
		
		assertTrue(t.getAantalReizigers()>0);
	}

	@Test
	public void testBeginStationIsEmpty() {
	 t1.setBeginStation("");
	 assertEquals("",t1.getBeginStation());
	}

	@Test
	public void testGetEindStation() {
		fail("Not yet implemented");
	}

	

	@Test
	public void testPrijsIsPositiefOfNul() {
		t.setPrijs(500);
		assertTrue(t.getPrijs()>=0);
	}

	

	@Test
	public void testGetKorting() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetKorting() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAantalReizigers() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAantalReizigers() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAankoopTijd() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAankoopTijd() {
		fail("Not yet implemented");
	}

}
