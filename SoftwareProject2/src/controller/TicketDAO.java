package controller;

import java.sql.*;
import java.util.Calendar;

import model.Ticket;
import model.Transactie;

public class TicketDAO extends DAO{
	public Ticket getTicket(int ticketID) throws SQLException {
		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			if (con == null || con.isClosed()) {
				return null;
				
			}
			PreparedStatement stmt = con.prepareStatement("select * from Ticket where TicketID = ?");
			stmt.setInt(1, ticketID);
			ResultSet rs = stmt.executeQuery();
			Ticket ticket = new Ticket();
			ticket.setTicketID(ticketID);
			ticket.setVerkoper(1);
			ticket.setTicketSoortID(-1);		
			while (rs.next()) {
				ticket.setPrijs(rs.getDouble("Prijs"));
				ticket.setAantalReizigers(rs.getInt("AantalReizigers"));
				ticket.setHeenDatum(rs.getDate("HeenDatum"));
				ticket.setTerugDatum(rs.getDate("TerugDatum"));
				ticket.setBeginStation(rs.getString("BeginStation"));
				ticket.setEindStation(rs.getString("EindStation"));
				ticket.setKorting(rs.getInt("Korting"));
				ticket.setAankoopTijd(rs.getString("Aankooptijd"));
				ticket.setKlasse(rs.getInt("Klasse"));
				ticket.setTicketSoortID(rs.getInt("TicketSoortID"));
			}
			Transactie t = new Transactie();

			TransactieDAO transDAO = new TransactieDAO();
			ticket.setVerkoper(transDAO.getVerkoper(ticket.getTicketID()));

			TransactieDAO tran = new TransactieDAO();
			ticket.setVerkoper(tran.getVerkoper(ticket.getTicketID()));

			con.close();
			if (ticket.getTicketsoortID() == -1) {
			
				return null;
			} else {
				
				return ticket;
			}
		} catch (SQLException exc) {
			System.out.println("PROBLEEM: " + exc.getMessage());
			System.out.println("fout code: " + exc.getErrorCode());
			con.close();
			return null;
		}
	}
	public void setTicket(Ticket t) throws SQLException {
		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			if (con == null || con.isClosed()) {

				
			}
			PreparedStatement stmt = con.prepareStatement("INSERT INTO `Ticket` (`TicketID`, `TicketSoortID`, `HeenDatum`, `TerugDatum`, `BeginStation`, `EindStation`, `Prijs`, `Korting`, `AantalReizigers`, `Aankooptijd`, `Klasse`) VALUES (NULL,?,?,?,?,?,?,?,?, CURRENT_TIMESTAMP,?)");
			stmt.setInt(1, t.getTicketSoortID());
			stmt.setDate(2, (Date) t.getHeenDatum());
			stmt.setDate(3, (Date) t.getTerugDatum());
			stmt.setString(4, t.getBeginStation());
			stmt.setString(5, t.getEindStation());
			stmt.setDouble(6, t.getPrijs());
			stmt.setFloat(7, t.getKorting());
			stmt.setInt(8, t.getAantalReizigers());
			stmt.setInt(9, t.getKlasseGetal());
			int updateCount = stmt.executeUpdate();
			con.close();
	
		} catch (SQLException exc) {
			System.out.println("PROBLEEM: " + exc.getMessage());
			System.out.println("fout code: " + exc.getErrorCode());
			con.close();
		}
	}
	
	
}
