package model;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class TransactieDAO {

public static void createTransactie(Transactie t) throws SQLException{

	 Connection con = null; 
		PreparedStatement pstmt = null;  
  try {
    //  con = (Connection) DriverManager.getConnection(
      //          "jdbc:default:connection");
 	 con = (Connection) DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1","SP2GR1","6xBfsv");

      try {
				pstmt = (PreparedStatement) con.prepareStatement(
"INSERT INTO `Transactie` (`TransactieID`, `TicketID`, `KassierID`, `TotaalBedrag`) VALUES (NULL,"+t.getTicket().getTicketID()+", '"+t.getPersoneel().getId()+"', '"+t.getTotaalbedrag()+"')"	

				//		"INSERT INTO `Transactie` (`TransactieID`, `TicketID`, `KassierID`, `TotaalBedrag`) VALUES (NULL, '1', '1', '55.23');"
						);	    } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                

  
      pstmt.executeUpdate();
  }
  finally {
      if (pstmt != null) pstmt.close();
  }

		
		
}

 public static void main(String[] args) throws SQLException {
	
	 Ticket a=new Ticket();
	 
	 TicketSoort s=new TicketSoort();
	 s.setTicketSoortID(1);
	 a.setTicketsoortID(s);
	 a.setTicketID(5);
	 Personeel p=new Personeel();
	 p.setId(1);
	 Transactie t =new Transactie(7,a,p,52.33);
	createTransactie(t);
	System.out.println("transactie gemaakt");
	
}
}
