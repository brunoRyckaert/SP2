package controller;

import java.sql.*;


public class AdresDAO extends DAO{
	
public Adres getAdres(int adresID) throws SQLException
{
	try
	{
		if( con == null || con.isClosed())
		{
			con = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1","SP2GR1","6xBfsv");
		}
		if( con == null || con.isClosed())
		{
			return null;
		}
	PreparedStatement stmt = con.prepareStatement("select * from Adres where AdresID = ?");
	stmt.setInt(1,adresID);
	ResultSet rs = stmt.executeQuery();
	Adres adr = new Adres();
	adr.setAdresID(adresID);
	adr.setStraat(null);
	while (rs.next())
	{
	adr.setStad(rs.getString("Stad"));
	adr.setStraat(rs.getString("straat"));
	adr.setNr(rs.getInt("nr"));
	adr.setGemeente(rs.getString("gemeente"));
	adr.setBus(rs.getInt("bus"));
	}
	con.close();
	if(adr.getStraat() == null)
	{
	return null;
	}
	else
	{
	return adr;
	}
	}
	catch (SQLException exc)
	{
		System.out.println("PROBLEEM: "+exc.getMessage());
		System.out.println("fout code: "+ exc.getErrorCode());
		con.close();
		return null;
	}
}
}
