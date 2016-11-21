package model;


import java.sql.*;


import controller.DAO;
import controller.PersoneelDAO;
import controller.TicketDAO;

public class TransactieDAO extends DAO {

public static void createTransactie(Transactie t) throws SQLException{

	 Connection con = null; 
		PreparedStatement pstmt = null;  
  try {
    //  con = (Connection) DriverManager.getConnection(
      //          "jdbc:default:connection");
 	 con = DAO.getInstance();

      try {
				pstmt = con.prepareStatement(
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

public static Transactie selectTransactie(int id)
{
	try
	{
		if( con == null || con.isClosed())
		{
			con = DAO.getInstance();
		}
		if( con == null || con.isClosed())
		{
			return null;
		}
	PreparedStatement stmt = con.prepareStatement("select * from Transactie where TransactieID = ?");
	stmt.setInt(1,id);
	ResultSet rs = stmt.executeQuery();
	Transactie t = new Transactie();
	PersoneelDAO pDao = new PersoneelDAO();
	
	while (rs.next())
	{
	t.setTransactieId(rs.getInt("TransactieID"));
	t.setPersoneel(pDao.getPersoon(rs.getInt("KassierID")));
	t.setTicket(TicketDAO.getTicket(rs.getInt("TicketID")));
	t.setTotaalbedrag(rs.getDouble("totaalBedrag"));
	}
	con.close();
	return t;
	}
	catch (SQLException exc)
	{
		System.out.println("PROBLEEM: "+exc.getMessage());
		System.out.println("fout code: "+ exc.getErrorCode());
		return null;
	}
}

public static int getVerkoper(int ticketID)
{
	try
	{
		if( con == null || con.isClosed())
		{
			con = DAO.getInstance();
		}
		if( con == null || con.isClosed())
		{
			return -1;
		}
	PreparedStatement stmt = con.prepareStatement("select * from Transactie where TicketID = ?");
	stmt.setInt(1,ticketID);
	ResultSet rs = stmt.executeQuery();
	int i  = -1;
	while (rs.next())
	{
	i = rs.getInt("TicketID");
	}
	con.close();
	return i;
	}
	catch (SQLException exc)
	{
		System.out.println("PROBLEEM: "+exc.getMessage());
		System.out.println("fout code: "+ exc.getErrorCode());
		return -1;
	}
}
}
