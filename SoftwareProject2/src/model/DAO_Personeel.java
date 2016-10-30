package model;

public class DAO_Personeel extends DAO_Connect {

	public static boolean createPersoneel(int a,int b, String c)
	{
		 Connection con = null; 
		PreparedStatement pstmt = null;  
        try {
            con = DriverManager.getConnection(
                      "jdbc:default:connection");

            pstmt = con.prepareStatement(
                        "INSERT INTO Kassier Values (?,?,?)" );
                      

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
