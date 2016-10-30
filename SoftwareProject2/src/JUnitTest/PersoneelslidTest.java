package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Personeelslid;

public class PersoneelslidTest {
     
	Personeelslid p1 = new Personeelslid();
	Personeelslid p2 = new Personeelslid();
	Personeelslid p3;
	@Test
	public void testofTweeNamenDezeldeZijn() {
		p3= new Personeelslid(); 
		p3.setNaam("Jose");
		p2.setNaam("Matt");
		assertFalse(p3.getNaam().equals(p2.getNaam()));
		
	}

	@Test
	public void testNaamEquals() {
		p1.setNaam("Lucia");
		assertEquals(p1.getNaam(),"Lucia");
	}

	@Test
	public void testofTweeDataseIdsDezelfdeZijn() {
		
		p2.setDatabaseID(101);
		p1.setDatabaseID(100);
		assertTrue(p1.getDatabaseID()== p2.getDatabaseID());
	}

	



}
