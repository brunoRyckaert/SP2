package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.TicketSoort;


public class TicketSoortDAO extends DAO {

public TicketSoort getTicket(int ticketsoortid) throws SQLException {
	try {
		if (con == null || con.isClosed()) {
			con = DAO.getInstance();
		}
		if (con == null || con.isClosed()) {
			return null;
			
		}
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM `TicketSoort` WHERE TicketSoortID = ?");
		stmt.setInt(1, ticketsoortid);
		ResultSet rs = stmt.executeQuery();
		TicketSoort ticket = new TicketSoort();
			
		while (rs.next()) {
		ticket.setTicketSoortID(rs.getInt(1));
		ticket.setNaam(rs.getString("Naam"));
		ticket.setBeschrijving("Beschrijving");
		ticket.setPrijsberekening(rs.getString(4));
		
		}
				con.close();
	
				return ticket;
	} catch (SQLException exc) {
		System.out.println("PROBLEEM: " + exc.getMessage());
		System.out.println("fout code: " + exc.getErrorCode());
		con.close();
		return null;
		}
	}

public void insertTicketSoort(TicketSoort t)
{
	try {
		if (con == null || con.isClosed()) {
			con = DAO.getInstance();
		}
		
		PreparedStatement stmt = con.prepareStatement("INSERT INTO `TicketSoort` (`TicketSoortID`, `Naam`, `Beschrijving`, `PrijsBerekening`) VALUES (NULL,?,?,?);");
		stmt.setString(1, t.getNaam());
		stmt.setString(2, t.getBeschrijving());
		stmt.setString(3, t.getPrijsberekening());
		ResultSet rs = stmt.executeQuery();
		TicketSoort ticket = new TicketSoort();
			
		while (rs.next()) {
		ticket.setTicketSoortID(rs.getInt(1));
		ticket.setNaam(rs.getString("Naam"));
		ticket.setBeschrijving("Beschrijving");
		ticket.setPrijsberekening(rs.getString(4));
		
		}
				con.close();
	
			
	} catch (SQLException exc) {
		System.out.println("PROBLEEM: " + exc.getMessage());
		System.out.println("fout code: " + exc.getErrorCode());
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}finally
	{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}

public ObservableList<TicketSoort> getAlles()
{
	try {
		if (con == null || con.isClosed()) {
			con = DAO.getInstance();
		}
		if (con == null || con.isClosed()) {
			return null;
		
		}
		java.sql.Statement stmt = con.createStatement();
	
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM `TicketSoort`");
		ObservableList<TicketSoort> lijst =  FXCollections.observableArrayList();
			
		while (rs.next()) {
			TicketSoort ticket = new TicketSoort();
		ticket.setTicketSoortID(rs.getInt("TicketSoortID"));
		ticket.setNaam(rs.getString("Naam"));
		ticket.setBeschrijving("Beschrijving");
		ticket.setPrijsberekening(rs.getString(4));
		System.out.println(ticket.toString());
		 lijst.add(ticket);
		}
				con.close();
	
				return lijst;
	} catch (SQLException exc) {
		System.out.println("PROBLEEM: " + exc.getMessage());
		System.out.println("fout code: " + exc.getErrorCode());
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		}
}

//public static void main(String[] args) {
//	TicketSoortDAO a = new TicketSoortDAO();
//	try {
//		System.out.println(a.getTicket(1).toString());
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//}
}
