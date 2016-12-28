package controller;


import java.sql.*;

import model.Transactie;

public class TransactieDAO extends DAO {

public void createTransactie(Transactie t) throws SQLException{

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
	TicketDAO tickDAO = new TicketDAO();
	while (rs.next())
	{
	t.setTransactieId(rs.getInt("TransactieID"));
	t.setPersoneel(pDao.getPersoon(rs.getInt("KassierID")));
	t.setTicket(tickDAO.getTicket(rs.getInt("TicketID")));
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
