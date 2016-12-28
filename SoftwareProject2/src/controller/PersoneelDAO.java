package controller;

import java.sql.*;


import model.Login;
import model.Personeel;
import model.Personeelslid;

public class PersoneelDAO extends DAO{
	
public Personeel getPersoon(int loginID)
{
	try
	{
		if( con == null || con.isClosed())
		{
			con = DAO.getInstance();
		}
		if( con == null || con.isClosed())
		{
			return null;
		}

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
	pers.setAdmin(rs.getBoolean("isAdmin"));
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

public boolean createPersoneel(Personeel a,Login log) throws SQLException
{

	PreparedStatement pstmt = null;  
    try {
    	if(con == null || con.isClosed())
    	{
        con = DAO.getInstance();
    	}
    	if(con == null || con.isClosed())
    	{
    		return false;
    	}
    	LoginDAO  logDAO = new LoginDAO();
        	logDAO.createLogin(log.getUsername(), log.getWachtwoord());
        	log = logDAO.getLogin(log.getUsername(), log.getWachtwoord());
			pstmt = con.prepareStatement("INSERT INTO `Kassier` (`KassierID`, `LoginID`, `adresID`, `Naam`, `geboortedatum`, `actief`, `isAdmin`) VALUES (NULL, '?', '?', '?', '?', '?', '?');");

        pstmt.setString(1, a.getNaam());
        pstmt.setInt(2, log.getId());
        pstmt.setInt(3, a.getAdres().getId());
        pstmt.setString(4, a.getNaam());
        pstmt.setDate(5, a.getGeboorteDatum());
        pstmt.setBoolean(6, a.getIsActief());
        pstmt.setBoolean(7, a.getAdmin());
        pstmt.executeUpdate();
    }
    catch(SQLException exc)
    {
    	exc.printStackTrace();
    }
    finally {
        if (pstmt != null) pstmt.close();
    }

	
	return true;
	
}

public boolean deletePersoneel(Personeelslid a) throws SQLException
{
	 Connection con = null; 
	PreparedStatement pstmt = null;  
    try {
        con = DAO.getInstance();

        try {
			pstmt = (PreparedStatement) con.prepareStatement(
			            "DELETE FROM Kassier WHERE KassierID = " + a.getDatabaseID() + ";" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                  

        
        pstmt.setInt(1, a.getDatabaseID());
        pstmt.execute();
    }
    finally {
        if (pstmt != null) pstmt.close();
    }

	
	return true;
	
}

}
