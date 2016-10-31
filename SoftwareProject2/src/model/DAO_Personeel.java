package model;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DAO_Personeel extends DAO_Connect {

	public static boolean createPersoneel(Personeelslid a) throws SQLException
	{
		
		 Connection con = null; 
		PreparedStatement pstmt = null;  
        try {
            con = (Connection) DriverManager.getConnection(
                      "jdbc:default:connection");

            try {
				pstmt = (PreparedStatement) con.prepareStatement(
				            "INSERT INTO Kassier Values ("+ a.getNaam() + ", " + a.getDatabaseID()  );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                      

            pstmt.setString(1, a.getNaam());
            pstmt.setInt(2, a.getDatabaseID());
            
            pstmt.executeUpdate();
        }
        finally {
            if (pstmt != null) pstmt.close();
        }
    
		
		return true;
		
	}
	
	public static boolean deletePersoneel(Personeelslid a) throws SQLException
	{
		 Connection con = null; 
		PreparedStatement pstmt = null;  
        try {
            con = (Connection) DriverManager.getConnection(
                      "jdbc:default:connection");

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
	
	/*public static void main(String[] args) {
		Personeelslid a = null;
		
		try {
			createPersoneel(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}*/
	  public static void main(String[] args) {      
		    try {
		      Class.forName("com.mysql.jdbc.Driver");
		      System.out.println("Driver O.K.");

		      String url = "jdbc:mysql://dt5.ehb.be:443/phpmyadmin";
		      String user = "SP2GR1";
		      String passwd = "6xBfsv";
		      

		      DriverManager.getConnection(url, user, passwd);
		      System.out.println("Connexion effective !");         
		         System.out.println("conn");
		    } catch (Exception e) {
		      e.printStackTrace();
		    }      
		  }
	
	
	
	
}
