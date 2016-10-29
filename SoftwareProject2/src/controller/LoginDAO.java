package controller;

import java.sql.*;


public class LoginDAO extends DAO{
	
	public Boolean checkLogin(String naam, String ww)

	{
		try
		{
		Connection con = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1","SP2GR1","6xBfsv");
		PreparedStatement stmt = con.prepareStatement("select * from Login where Usernaam = ? AND Wachtwoord = ?");
		stmt.setString(1,naam);
		stmt.setString(2,ww);
		ResultSet rs = stmt.executeQuery();
		Login log = new Login();
		log.setUsername(null);
		log.setWachtwoord(null);
		while (rs.next())
		{
		log.setId(rs.getInt("LoginID"));
		log.setUsername(rs.getString("Usernaam"));
		log.setWachtwoord(rs.getString("Wachtwoord"));
		}
		if(log.getUsername() == null || log.getWachtwoord() == null)
		{
		return false;
		}
		else
		{
		return true;
		}
		}
		catch (SQLException exc)
		{
			System.out.println("PROBLEEM: "+exc.getMessage());
			System.out.println("fout code: "+ exc.getErrorCode());
			return false;
		}
	}
	public Login getLogin(String naam,String ww) throws SQLException
	{
		
		try
		{
		Connection con = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1","SP2GR1","6xBfsv");
		PreparedStatement stmt = con.prepareStatement("select * from Login where Usernaam = ? AND Wachtwoord = ?");
		stmt.setString(1,naam);
		stmt.setString(2,ww);
		ResultSet rs = stmt.executeQuery();
		Login log = new Login();
		while (rs.next())
		{
		log.setId(rs.getInt("LoginID"));
		log.setUsername(rs.getString("Usernaam"));
		log.setWachtwoord(rs.getString("Wachtwoord"));
		}
		con.close();
		return log;
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
