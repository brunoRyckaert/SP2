package model;

import java.sql.*;
import java.sql.SQLException;


import controller.DAO;

public class DAO_Personeel extends DAO_Connect {

	public static boolean createPersoneel(Personeelslid a) throws SQLException
	{
		
		 Connection con = null; 
		PreparedStatement pstmt = null;  
        try {
            con = DAO.getInstance();

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
	
	/*public static void main(String[] args) {
		Personeelslid a = null;
		
		try {
			createPersoneel(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}*/
	 
	
	
	
	
}
