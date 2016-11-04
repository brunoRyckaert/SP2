package controller;

import java.sql.*;

public abstract class DAO {
	// connectie maken
	protected static Connection con ;
	
	public static Connection getInstance()
	{
		try {
		if(con == null || con.isClosed())
		{
				con = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1","SP2GR1","6xBfsv");
		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return con;
		
	}
	
}
