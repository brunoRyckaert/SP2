package controller;
import java.sql.*;


import controller.Login;

public class Main {
	public static void main(String[] args) {
	// connectie maken
		try
		{
		Connection con = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/phpmyadmin/SP2GR1","SP2GR1","6xBfsv");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Login");
		while (rs.next())
		{
		Integer id = rs.getInt("LoginID");
		String naam = rs.getString("Usernaam");
		String ww = rs.getString("Wachtwoord");
		System.out.println(id + "" + "naam: " + naam + "  wachtwoord: "+ ww);
		}
		
		}
		catch (SQLException exc)
		{
			System.out.println("t'heeft ni gewerkt");
			System.out.println(exc.getMessage());
		}
	}
}
