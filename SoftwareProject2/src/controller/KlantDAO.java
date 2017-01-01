package controller;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Klant;

public class KlantDAO extends DAO{

	public Klant getKlant(int klantID) throws SQLException {

		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			if (con == null || con.isClosed()) {
				return null;
			}
			PreparedStatement stmt = con.prepareStatement("select * from Klant where KlantID = ?");
			stmt.setInt(1, klantID);
			ResultSet rs = stmt.executeQuery();
			Klant klant = new Klant();
			klant.setKlantID(klantID);
			while (rs.next()) {
				klant.setAdresID(rs.getInt("Adres"));
				klant.setNaam(rs.getString("Naam"));
				klant.setTelefoonnummer(rs.getString("Telefoonnummer"));
				klant.setGeboortedatum(rs.getDate("Geboortedatum"));
			}
			con.close();
			if (klant.getKlantID() == -1) {
			
				return null;
			} else {
				
				return klant;
			}
		} catch (SQLException exc) {
			System.out.println("PROBLEEM: " + exc.getMessage());
			System.out.println("fout code: " + exc.getErrorCode());
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	}
	
	
	public void add(Klant k) {
		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
				}
			
			if (con == null || con.isClosed()) {
				System.out.println("no connection");
				
			}
			PreparedStatement stmt = con.prepareStatement("INSERT INTO `Klant` (`KlantID`, `AdresID`, `Naam`, `telefoonnummer`, `geboortedatum`) VALUES (?,?,?,?,?)");
			stmt.setInt(1, k.getKlantID());
			stmt.setInt(2, k.getAdresID());
			stmt.setString(3, k.getNaam());
			stmt.setString(4, k.getTelefoonnummer());
			stmt.setDate(5, k.getGeboortedatum());
			
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
	
	public void update(Klant obj) {
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
			PreparedStatement stmt = con.prepareStatement("UPDATE Klant SET AdresID = ?, Naam = ?, telefoonnummer = ?, geboortedatum = ? WHERE KlantID = ?");
			stmt.setInt(1, obj.getAdresID());
			stmt.setString(2, obj.getNaam());
			stmt.setString(3, obj.getTelefoonnummer());
			stmt.setDate(4, obj.getGeboortedatum());
			
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
