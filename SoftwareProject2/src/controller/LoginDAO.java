package controller;

import java.sql.*;

import model.Login;


public class LoginDAO extends DAO{
	
	public Login checkLogin(Login log)
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
		PreparedStatement stmt = con.prepareStatement("select * from Login where Usernaam = ? AND Wachtwoord = ?");
		stmt.setString(1,log.getUsername());
		stmt.setString(2,log.getWachtwoord());
		ResultSet rs = stmt.executeQuery();
		log.setId(-1);
		while (rs.next())
		{
		log.setId(rs.getInt("LoginID"));
		log.setUsername(rs.getString("Usernaam"));
		log.setWachtwoord(rs.getString("Wachtwoord"));
		}
		if(log.getId() == -1)
		{
			log.setId(-1);
			log.setUsername("");
			log.setWachtwoord("");
		return log;
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
	public Boolean checkUsername(String naam)//zelfde usernaam vermijden
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

		PreparedStatement stmt = con.prepareStatement("select * from Login where Usernaam = ?");
		stmt.setString(1,naam);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next())
		{
	
			return true;
		}
		
		else
		{
		return false;
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
				con = DAO.getInstance();
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
				con = DAO.getInstance();
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
	public void createLogin(String naam,String ww)
	{
		try
		{
			if( con == null || con.isClosed())
			{
				con = DAO.getInstance();
			}
			if( con == null || con.isClosed())
			{
				
			}
		PreparedStatement stmt = con.prepareStatement("INSERT INTO `Login` (`LoginID`, `Usernaam`, `Wachtwoord`) VALUES (NULL,?, ?);");
		stmt.setString(2,ww);
		stmt.setString(1,naam);
		stmt.executeUpdate();
		con.close();
		}
		catch (SQLException exc)
		{
			if(exc.getErrorCode() == 1062){
				System.out.println("deze usernaam bestaat al ");
			}
			else
			{
			exc.printStackTrace();
			
			System.out.println("PROBLEEM: "+exc.getMessage());
			System.out.println("fout code: "+ exc.getErrorCode());
			}
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
