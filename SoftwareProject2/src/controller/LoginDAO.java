package controller;

import java.sql.*;

import model.Login;


public class LoginDAO extends DAO{
	
	public Login checkLogin(Login log)
	{
		try
		{
		con = DAO.getInstance();
		PreparedStatement stmt = con.prepareStatement("select * from Login where Usernaam = ? AND Wachtwoord = ?");
		stmt.setString(1,log.getUsername());
		stmt.setString(2,log.getWachtwoord());
		ResultSet rs = stmt.executeQuery();
		while (rs.next())
		{
		log.setId(rs.getInt("LoginID"));
		log.setUsername(rs.getString("Usernaam"));
		log.setWachtwoord(rs.getString("Wachtwoord"));
		}
		if(log.getUsername() == null || log.getWachtwoord() == null)
		{
		return null;
		}
		else
		{
		return log;
		}
		
		}
		catch (SQLException exc)
		{
			System.out.println("PROBLEEM: "+exc.getMessage());
			System.out.println("fout code: "+ exc.getErrorCode());
			return null;
		}
		
	}
	public Login getLogin(String naam,String ww) throws SQLException
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
	public void setWw(int loginID,String ww) throws SQLException
	{
		try
		{
			if( con == null || con.isClosed())
			{
				con = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1","SP2GR1","6xBfsv");
			}
			if( con == null || con.isClosed())
			{
				
			}
		PreparedStatement stmt = con.prepareStatement("update Login set Wachtwoord = ? WHERE LoginID = ?");
		stmt.setString(1,ww);
		stmt.setInt(2,loginID);
		stmt.executeUpdate();
		con.close();
		}
		catch (SQLException exc)
		{
			System.out.println("PROBLEEM: "+exc.getMessage());
			System.out.println("fout code: "+ exc.getErrorCode());
			con.close();
		}
	}
}
