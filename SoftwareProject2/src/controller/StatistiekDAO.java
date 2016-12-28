package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.TreeMap;

import model.Settings;

public class StatistiekDAO  extends DAO{

	/*
	haalt alle tickets op dat dit personeelslid heeft verkocht in 1 week tijd 
//	 */
//public TreeMap<Timestamp, Integer> PersoneelAantalTicketten(String usernaam)
//{
//	try
//	{
//		if( con == null || con.isClosed())
//		{
//			con = DAO.getInstance();
//		}
//		if( con == null || con.isClosed())
//		{
//			return null;
//		}
//		int id = -1;
//	PreparedStatement stmtKassierId = con.prepareStatement("select KassierID from Kassier where LoginID = (select LoginID from Login where Usernaam = ?)");
//	stmtKassierId.setString(1, usernaam);
//	ResultSet kassierId = stmtKassierId.executeQuery();
//	while(kassierId.next())
//	{
//		id = kassierId.getInt("KassierID");
//	}
////	System.out.println("id: "+ id);	
//	String vandaag = Settings.getDag();
//	LocalDate vorigeWeek  = Settings.getLocalDate();
//	vorigeWeek.minusDays(7);
//int maand =	vorigeWeek.getDayOfMonth();
//	int dag = vorigeWeek.getDayOfMonth();
//	int jaar = vorigeWeek.getYear();
//
//	Timestamp tijd = new Timestamp(System.currentTimeMillis());
//	tijd.setYear(jaar);
//	tijd.setMonth(maand);
//	tijd.setDate(dag);
//	Timestamp tijd2 = tijd;
//	tijd.setHours(0);
//	tijd2.setHours(23);
//	StatistiekDAO dao = new StatistiekDAO();
//	TreeMap<Timestamp,Integer>map = new TreeMap<Timestamp,Integer>();
//	for(int i = 0;i<7;i++)
//	{
//		map.put(tijd, dao.aantalTicket(tijd,tijd2,id));
//		if(con.isClosed() || con == null)
//		{
//			con = DAO.getInstance();
//		}
//		dag++;
//		maand++;
//		jaar++;
//		tijd.setYear(jaar);
//		tijd.setMonth(maand);
//		tijd.setDate(dag);
//		tijd2.setYear(jaar);
//		tijd2.setMonth(maand);
//		tijd2.setDate(dag);
//	}
//
//	con.close();
//	return map;
//	}
//	catch (SQLException exc)
//	{
//		System.out.println("PROBLEEM: "+exc.getMessage());
//		System.out.println("fout code: "+ exc.getErrorCode());
//		return null;
//	}
//}
/**
 * geeft het totaal bedrag dat vandaag werdt verkocht
 * @return
 */

public int totaalOmzetVandeDag()
{
	try
	{
		if( con == null || con.isClosed())
		{
			con = DAO.getInstance();
		}
		if( con == null || con.isClosed())
		{
			return -1;
		}
	PreparedStatement stmt = con.prepareStatement("select sum(TotaalBedrag) from Transactie t JOIN Ticket p on( t.TicketID = p.TicketID And p.Aankooptijd >=curdate())");
	
	ResultSet rs = stmt.executeQuery();
	int i  = -1;
	while (rs.next())
	{
	i = rs.getInt("sum(TotaalBedrag)");
	}
	con.close();
	return i;
	}
	catch (SQLException exc)
	{
		System.out.println("PROBLEEM: "+exc.getMessage());
		System.out.println("fout code: "+ exc.getErrorCode());
		return -1;
	}
}

/**
 * geeft de omzet voor een bepaalde periode
 * @param a
 * @param b
 * @return
 */

public int totaalOmzetBinnenEenBepaaldePeriode(String a, String b)
{
	try
	{
		if( con == null || con.isClosed())
		{
			con = DAO.getInstance();
		}
		if( con == null || con.isClosed())
		{
			return -1;
		}
	PreparedStatement stmt = con.prepareStatement("select sum(TotaalBedrag) from Transactie t JOIN Ticket p on( t.TicketID = p.TicketID And p.Aankooptijd BETWEEN ? AND ?)");
	stmt.setString(1, a);
	stmt.setString(2,b);
	ResultSet rs = stmt.executeQuery();
	int i  = -1;
	while (rs.next())
	{
	i = rs.getInt("sum(TotaalBedrag)");
	}
	con.close();
	return i;
	}
	catch (SQLException exc)
	{
		System.out.println("PROBLEEM: "+exc.getMessage());
		System.out.println("fout code: "+ exc.getErrorCode());
		return -1;
	}
}

/**
 * zegt hoeveel ticketten er werden gemaakt tussen 2 momenten
 * @param b
 * @param c
 * @return
 */
public int aantalTicket(Timestamp b, Timestamp c)
{
	try {
		if (con == null || con.isClosed()) {
			con = DAO.getInstance();
		}
		if (con == null || con.isClosed()) {

			
		}
		int aantal=0;
	//	Timestamp begin ;
		//Timestamp eind ;
		PreparedStatement stmt = con.prepareStatement("SELECT count(*) FROM `Ticket` WHERE `Aankooptijd` BETWEEN ? AND ? ;");
		 
		
		stmt.setTimestamp(1, b);
		stmt.setTimestamp(2, c);
		
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			aantal = rs.getInt("count(*)");
			return aantal;

		}
		
		
		return aantal;

	
	} catch (SQLException exc) {
		System.out.println("PROBLEEM: " + exc.getMessage());
		System.out.println("fout code: " + exc.getErrorCode());
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return 0;
}
/**
 * geeft de 5 stations die het meest verkocht hebben op dalende waarde
 * @return
 */

public String TopVijfMeestStation()
{
	
	try {
		if (con == null || con.isClosed()) {
			con = DAO.getInstance();
		}
		if (con == null || con.isClosed()) {

			
		}
		Statement st = con.createStatement();//con.prepareStatement("sELECT BeginStation, count(BeginStation) FROM `Ticket` group BY BeginStation ORDER BY count(BeginStation) desc limit 1");
		ResultSet rs = st.executeQuery("sELECT BeginStation, count(BeginStation) FROM `Ticket` group BY BeginStation ORDER BY count(BeginStation) desc limit 5");
		String begin,aantal;
		while (rs.next()) {
			begin = rs.getString(1);
			aantal = rs.getString(2);
			return begin +" "+ aantal;

		}
		
		con.close();

	} catch (SQLException exc) {
		System.out.println("PROBLEEM: " + exc.getMessage());
		System.out.println("fout code: " + exc.getErrorCode());
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return null;
}
//aantal Tickets van een bepaald personeelslid
//public int aantalTicket(Timestamp b, Timestamp c,int kassierId)
//{
//	try {
//		if (con == null || con.isClosed()) {
//			con = DAO.getInstance();
//		}
//		if (con == null || con.isClosed()) {
//
//			
//		}
//		int aantal=0;
//	//	Timestamp begin ;
//		//Timestamp eind ;
//		PreparedStatement stmt = con.prepareStatement("SELECT count(*) FROM `Ticket` WHERE `Aankooptijd` BETWEEN ? AND ? AND (KassierID = ?);");
//		 
//		
//		stmt.setTimestamp(1, b);
//		stmt.setTimestamp(2, c);
//		stmt.setInt(3, kassierId);
//		ResultSet rs = stmt.executeQuery();
//		while (rs.next()) {
//			aantal = rs.getInt("count(*)");
//			return aantal;
//
//		}
//		
//		
//		return aantal;
//
//	
//	} catch (SQLException exc) {
//		System.out.println("PROBLEEM: " + exc.getMessage());
//		System.out.println("fout code: " + exc.getErrorCode());
//		try {
//			con.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	return 0;
//}
}