package model;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DAO_Personeel extends DAO_Connect {

	public static boolean createPersoneel(int a,int b, String c) throws SQLException
	{
		 Connection con = null; 
		PreparedStatement pstmt = null;  
        try {
            con = (Connection) DriverManager.getConnection(
                      "jdbc:default:connection");

            try {
				pstmt = (PreparedStatement) con.prepareStatement(
				            "INSERT INTO Kassier Values (?,?,?)" );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                      

            pstmt.setString(1, c);
            pstmt.setInt(2, b);
            pstmt.setInt(3 ,a);
            pstmt.executeUpdate();
        }
        finally {
            if (pstmt != null) pstmt.close();
        }
    
		
		return true;
		
	}
	
	
}
