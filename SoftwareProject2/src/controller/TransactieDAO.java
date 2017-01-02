package controller;

import java.sql.*;

import model.Adres;
import model.Transactie;

public class TransactieDAO extends DAO {

	public Transactie getTransactie(int transactieId) throws SQLException {

		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			if (con == null || con.isClosed()) {
				return null;
			}
			PreparedStatement stmt = con.prepareStatement("select * from Transactie where TransactieID = ?");
			stmt.setInt(1, transactieId);
			ResultSet rs = stmt.executeQuery();
			Transactie tr = new Transactie();
			tr.setTransactieId(transactieId);
			while (rs.next()) {
				tr.setTicket(rs.getInt("TicketID"));
				tr.setPersoneel(rs.getInt("KassierID"));;
				tr.setTotaalbedrag(rs.getDouble("TotaalBedrag"));
			}
			con.close();
			if (tr.getTicketId() == -1) {
				return null;
			} 
			if (tr.getPersoneelId() == -1) {
				return null;
			}
			else {
				return tr;
			}
		} catch (SQLException exc) {
			System.out.println("PROBLEEM: " + exc.getMessage());
			System.out.println("fout code: " + exc.getErrorCode());
			con.close();
			return null;
		}

	}

	public void add(Transactie tr)
	{
		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			PreparedStatement stmt = con.prepareStatement("INSERT INTO `Transactie` (`TransactieID`, `TicketID`, `KassierID`, `TotaalBedrag`) VALUES (NULL,?,?,?);");
			stmt.setInt(1, tr.getTicketId());
			stmt.setInt(2, tr.getPersoneelId());
			stmt.setDouble(3, tr.getTotaalbedrag());
			stmt.executeQuery();
			con.close();
			
		} catch (SQLException exc) {
			System.out.println("PROBLEEM: " + exc.getMessage());
			System.out.println("fout code: " + exc.getErrorCode());
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update(Transactie obj) {
		try {
			if (con == null || con.isClosed()) {
				con = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1", "SP2GR1", "6xBfsv");
			}
			
			PreparedStatement stmt = con.prepareStatement("UPDATE Transactie SET TicketID = ?, KassierID = ?, TotaalBedrag = ? WHERE TransactieID = ?");
			stmt.setInt(1, obj.getTicketId());
			stmt.setInt(2, obj.getPersoneelId());
			stmt.setDouble(3, obj.getTotaalbedrag());
			
			int updateCount = stmt.executeUpdate();

			con.close();
	
		} catch (SQLException exc) {
			System.out.println("PROBLEEM: " + exc.getMessage());
			System.out.println("fout code: " + exc.getErrorCode());
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}       
}
