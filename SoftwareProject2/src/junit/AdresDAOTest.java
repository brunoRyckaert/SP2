package junit;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import controller.AdresDAO;
import model.Adres;

public class AdresDAOTest {
	
	Adres a = new Adres(1, "Overboelare", "Veldekensdreef", 15, "Oost-Vlaanderen");
	Adres a1 = new Adres(2, "Aalst", "Pontweg", 3, "Oost-Vlaanderen");
	@Test
	public void testAddLost() {
		AdresDAO.getInstance().add(a);
		Lost l2 = LostDAO.getInstance().getByID(l.getLostID());
		assertEquals(l.getLostID(), l2.getLostID());
		assertEquals(l.getDatum(), l2.getDatum());
		assertEquals(l.getOpmerking(), l2.getOpmerking());
		assertEquals(l.getTreinID(), l2.getTreinID());
		assertEquals(true, l.isActief() == l2.isActief());
		assertEquals(true, l.isOpgehaald() == l2.isOpgehaald());
	}
	
	
	@Test
	public void testUpdateLost(){
		LostDAO.getInstance().add(l);
		l.setDatum(TimeManagement.stringToTimestamp("25/03/1996"));
		l.setOpmerking("testtest");
		l.setActief(false);
		l.setOpgehaald(false);
		l.setTreinID(90);
		
		LostDAO.getInstance().update(l);
		Lost l2 = LostDAO.getInstance().getByID(l.getLostID());
		
		assertEquals(l.getLostID(), l2.getLostID());
		assertEquals(l.getDatum(), l2.getDatum());
		assertEquals(l.getOpmerking(), l2.getOpmerking());
		assertEquals(l.getTreinID(), l2.getTreinID());
		assertEquals(true, l.isActief() == l2.isActief());
		assertEquals(true, l.isOpgehaald() == l2.isOpgehaald());
	}

	@Test
	public void testDeleteLos(){
		LostDAO.getInstance().add(l);
		LostDAO.getInstance().delete(l);
		Lost l2 = LostDAO.getInstance().getByID(l.getLostID());
		assertEquals(false, l2.isActief());
	}
	
	@Test
	public void testGetAll(){
		LostDAO.getInstance().add(l);
		LostDAO.getInstance().add(l3);
		
		List <Lost> all;
		all = LostDAO.getInstance().getAll();
		assertEquals(all.get(0), l);
		assertEquals(all.get(1), l3);
	}
}
