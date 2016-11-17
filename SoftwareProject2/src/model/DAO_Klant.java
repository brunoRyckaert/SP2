package model;

import java.security.Timestamp;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DAO_Klant extends DAO_Connect {

	public static boolean createKlant(Klant k) throws SQLException
	{
		
		 Connection con = null; 
		PreparedStatement pstmt = null;  
        try {
            con = (Connection) DriverManager.getConnection(
            		"jdbc:mysql://dt5.ehb.be/SP2GR1","SP2GR1","6xBfsv");

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
            pstmt.setTime(5, (Time) k.getGeboortedatum().getTime(), k.getGeboortedatum());
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
            		"jdbc:mysql://dt5.ehb.be/SP2GR1","SP2GR1","6xBfsv");

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
          
            pstmt.setDate(5 ,  (java.sql.Date) k.getGeboortedatum().getTime()); // Ik kan geen manier vinden om een Calendar type naar tabel te sturen
         // pstmt.setTime(5 , k.getGeboortedatum());
       //     pstmt.setDate(5, k.getGeboortedatum();

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
            		"jdbc:mysql://dt5.ehb.be/SP2GR1","SP2GR1","6xBfsv");

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
	public static void main(String[] args)   {
		
		 
		try{
			Connection conn =   (Connection) DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1","SP2GR1","6xBfsv");
			
			Calendar cal = Calendar.getInstance();
			  cal.set(1998, 2, 14);
			Klant k = new Klant(101,"Matt", cal,(long)489635214,2 );
			DAO_Klant.createKlant(k);
			Calendar cal1 = Calendar.getInstance();
			 cal1.set(1998, 2, 14);
			Klant k1 = new Klant(102,"Jake", cal1,(long)483625814,3 );
			DAO_Klant.createKlant(k1);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
			
		
	}
}
