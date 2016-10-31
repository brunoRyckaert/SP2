package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Ticket;

public class TicketTest {
    Ticket t = new Ticket();
    Ticket t1 = new Ticket();
    
    
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
		
	}
	/*
	@Test
	public void testOfKlasse1is(){
	
	}
	
	@Test
	public void testOfKlasse2is(){
		
	}
	*/
	@Test
	public void testGetTicketsoortID() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTicketsoortID() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHeenDatum() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetHeenDatum() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTerugDatum() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTerugDatum() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBeginStation() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBeginStation() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEindStation() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEindStation() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPrijs() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPrijs() {
		fail("Not yet implemented");
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
