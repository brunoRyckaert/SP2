package model;


import java.sql.*;


import controller.DAO;
import controller.PersoneelDAO;
import controller.TicketDAO;

public class TransactieDAO extends DAO {
	
	/**
	 * schrijft een object transactie naar de a databank over
	 * @param t
	 */

public void createTransactie(Transactie t){

	 Connection con = null; 
		PreparedStatement pstmt = null;  
  try {
    //  con = (Connection) DriverManager.getConnection(
      //          "jdbc:default:connection");
 	 con = DAO.getInstance();

      try {
				pstmt = con.prepareStatement(
"INSERT INTO `Transactie` (`TransactieID`, `TicketID`, `KassierID`, `TotaalBedrag`) VALUES (NULL,?,?,?')"	

				
						);	  
				
      pstmt.setInt(1, t.getTicket().getTicketID());
      pstmt.setInt(2, t.getPersoneel().getId());
      pstmt.setDouble(3, t.getTotaalbedrag());
      
      } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                

  
      try {
		pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  finally {
      if (pstmt != null)
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }

		
		
}

/**
 * zoekt een transactie op basis van  de transactieID
 * @param id
 * @return
 */
public Transactie selectTransactie(int id)
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
	TicketDAO d = new TicketDAO();
	
	while (rs.next())
	{
	t.setTransactieId(rs.getInt("TransactieID"));
	t.setPersoneel(pDao.getPersoon(rs.getInt("KassierID")));
	t.setTicket(d.getTicket(rs.getInt("TicketID")));
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

/**
 * zoekt de transactie voor een bepaalde ticket en geeft dit terug
 * @param ticketID
 * @return
 */
public int getVerkoper(int ticketID)
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
