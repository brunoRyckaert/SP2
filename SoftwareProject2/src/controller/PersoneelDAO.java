package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersoneelDAO extends DAO{
	
public Personeel getPersoon(int loginID)
{
	try
	{
	con = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1","SP2GR1","6xBfsv");
	PreparedStatement stmt = con.prepareStatement("select * from Kassier where LoginID = ?");
	stmt.setInt(1,loginID);
	ResultSet rs = stmt.executeQuery();
	Personeel pers = new Personeel();
	pers.setNaam(null);
	int adresID = 0;
	while (rs.next())
	{
	pers.setId(rs.getInt("KassierID"));
	pers.setNaam(rs.getString("Naam"));
	pers.setGeboorteDatum(rs.getDate("geboortedatum"));
	pers.setIsActief(rs.getBoolean("actief"));
	adresID = rs.getInt("adresID");
	}
	con.close();
	if(pers.getNaam() == null)
	{
	return null;
	}
	else
	{
	AdresDAO adresDAO = new AdresDAO();
	pers.setAdres(adresDAO.getAdres(adresID));
	return pers;
	}
	}
	catch (SQLException exc)
	{
		System.out.println("PROBLEEM: "+exc.getMessage());
		System.out.println("fout code: "+ exc.getErrorCode());
		return null;
	}
}
}
