package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

public class StatistiekDAO  extends DAO{


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

public ArrayList<StatStation> TopVijfMeestStation()
{
	
	try {
		if (con == null || con.isClosed()) {
			con = DAO.getInstance();
		}
		if (con == null || con.isClosed()) {

			
		}
		Statement st = con.createStatement();//con.prepareStatement("sELECT BeginStation, count(BeginStation) FROM `Ticket` group BY BeginStation ORDER BY count(BeginStation) desc limit 1");
		ResultSet rs = st.executeQuery("sELECT BeginStation, count(BeginStation) FROM `Ticket` group BY BeginStation ORDER BY count(BeginStation) desc limit 5");
		ArrayList<StatStation> stations = new ArrayList<StatStation>();
		while (rs.next()) {
			StatStation az= new StatStation();
			az.setAantal(rs.getInt(2));
			az.setNaam(rs.getString(1));
			stations.add(az);
			

		}
		
		con.close();

		return stations;
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
public static void main(String[] args) {
	ArrayList<StatStation> a=new ArrayList<StatStation>();
	StatistiekDAO b = new StatistiekDAO(); 
	System.out.println(b.TopVijfMeestStation().toString());
}
}
