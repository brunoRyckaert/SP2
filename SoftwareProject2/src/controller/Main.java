package controller;
import java.sql.*;


import controller.Login;

public class Main {
	public static void main(String[] args) {
	// connectie maken
		try
		{
		Connection con = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1","SP2GR1","6xBfsv");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Login");
		while (rs.next())
		{
		Integer id = rs.getInt("LoginID");
		String naam = rs.getString("Usernaam");
		String ww = rs.getString("Wachtwoord");
		System.out.println("id: "+ id + " " + "  naam: " + naam + "  wachtwoord: "+ ww);
		}
		
		}
		catch (SQLException exc)
		{
			
			System.out.println("PROBLEEM: "+exc.getMessage());
			System.out.println("fout code: "+ exc.getErrorCode());
		}
	}
}
