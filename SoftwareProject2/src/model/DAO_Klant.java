package model;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DAO_Klant extends DAO_Connect {

	public static boolean createKlant(Klant k) throws SQLException
	{
		
		 Connection con = null; 
		PreparedStatement pstmt = null;  
        try {
            con = (Connection) DriverManager.getConnection(
                      "jdbc:default:connection");

            try {
				pstmt = (PreparedStatement) con.prepareStatement(
				            "INSERT INTO Klant(KlantID,AdresID,Naam,telefoonnummer,geboortedatum) Values (?,?,?,?,?)");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                      

           pstmt.setInt(1, k.getKlantID());
            pstmt.setInt(2, k.getAdresID());
            pstmt.setString(3, k.getNaam());
            pstmt.setLong(4, k.getTelefoonnummer());
            pstmt.setDate(5, k.getGeboortedatum());
            pstmt.executeUpdate();
        }
        finally {
            if (pstmt != null) pstmt.close();
        }
    
		
		return true;
		
	}
	public static boolean modifyKlant(Klant k) throws SQLException
	{
		
		 Connection con = null; 
		PreparedStatement pstmt = null;  
        try {
            con = (Connection) DriverManager.getConnection(
                      "jdbc:default:connection");

            try {
				pstmt = (PreparedStatement) con.prepareStatement(
				            "UPDATE Klant SET KlantID = ? , AdresID = ?, Naam = ?, telefoonnummer = ?, geboortedatum =? WHERE KlantID = ?");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                      

           pstmt.setInt(1, k.getKlantID());
            pstmt.setInt(2, k.getAdresID());
            pstmt.setString(3, k.getNaam());
            pstmt.setLong(4, k.getTelefoonnummer());
            pstmt.setDate(5, k.getGeboortedatum());
            pstmt.setInt(6, k.getKlantID());
            pstmt.executeUpdate();
        }
        finally {
            if (pstmt != null) pstmt.close();
        }
    
		
		return true;
		
	}
	public static boolean deleteKlant(Klant k) throws SQLException
	{
		 Connection con = null; 
		PreparedStatement pstmt = null;  
        try {
            con = (Connection) DriverManager.getConnection(
                      "jdbc:default:connection");

            try {
				pstmt = (PreparedStatement) con.prepareStatement(
				            "DELETE FROM Klant WHERE KlantID = ?");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                      

            
            pstmt.setInt(1, k.getKlantID());
            pstmt.execute();
        }
        finally {
            if (pstmt != null) pstmt.close();
        }
    
		
		return true;
		
	}
}
