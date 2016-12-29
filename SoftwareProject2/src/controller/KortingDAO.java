package controller;

import java.sql.*;
import model.Korting;

public class KortingDAO extends DAO {
	public Korting getKorting(int kortingID) {
		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			if (con == null || con.isClosed()) {
				return null;

			}
			PreparedStatement stmt = con.prepareStatement("select * from Korting where KortingID = ?");
			stmt.setInt(1, kortingID);
			ResultSet rs = stmt.executeQuery();
			Korting korting = new Korting();
			korting.setKortingID(kortingID);
			while (rs.next()) {
				korting.setTicketSoortID(rs.getInt("TicketSoortID"));
				korting.setBeschrijving(rs.getString("Beschrijving"));
				korting.setPrijs(rs.getFloat("PercentageGetal"));
				korting.setIsProcent(rs.getBoolean("Procent"));
				korting.setAantal(rs.getInt("Aantal"));
			}
			con.close();

			if (korting.getKortingID() == -1) {

				return null;
			} else {

				return korting;
			}

		} catch (SQLException exc) {
			System.out.println("PROBLEEM: " + exc.getMessage());
			System.out.println("fout code: " + exc.getErrorCode());
			return null;

		}
	}

	public void add(Korting k) throws SQLException {
		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			if (con == null || con.isClosed()) {
				System.out.println("no connection");
			}
			
			PreparedStatement stmt = con.prepareStatement("INSERT INTO `Korting` (`KortingID`, `TicketSoortID`, `Beschrijving`, `PercentageGetal`, `Procent`, `aantal`) VALUES (NULL,?,?,?,?,?)");
			stmt.setInt(1, k.getKortingID());
			stmt.setDouble(2, k.getTicketSoortID());
			stmt.setString(3, k.getBeschrijving());
			stmt.setFloat(4, k.getPrijs());
			stmt.setBoolean(5, k.getIsProcent());
			stmt.setInt(6, k.getAantal());
			int updateCount = stmt.executeUpdate();

			con.close();

		} catch (SQLException exc) {
			System.out.println("PROBLEEM: " + exc.getMessage());
			System.out.println("fout code: " + exc.getErrorCode());
			con.close();
		}
	}
	
	public void update(Korting obj) {
		try {
			try {
				if (con == null || con.isClosed()) {
					con = DAO.getInstance();
				} else {
					System.out.println("no connection");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			PreparedStatement stmt = con.prepareStatement("UPDATE Korting SET TicketSoortID = ?, Beschrijving = ?, PercentageGetal = ?, Procent = ?, aantal = ? WHERE KortingID = ?");
			stmt.setInt(1, obj.getKortingID());
			stmt.setInt(2, obj.getTicketSoortID());
			stmt.setString(3, obj.getBeschrijving());
			stmt.setBoolean(4, obj.getIsProcent());
			stmt.setFloat(5, obj.getPrijs());
			
			int updateCount = stmt.executeUpdate();
			System.out.println("klant werd geupdate");
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
