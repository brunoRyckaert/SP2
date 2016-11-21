package controller;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Klant;

public class KlantDAO extends DAO{
	public static Klant getKlant(int klantID) throws SQLException {
		try {
			if (con == null || con.isClosed()) {
				con = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1", "SP2GR1", "6xBfsv");
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
				klant.setGeboortedatum(rs.getString("Geboortedatum"));
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
			con.close();
			return null;
		}
	}
	public void setTicket(Klant k) throws SQLException {
		try {
			if (con == null || con.isClosed()) {
				con = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1", "SP2GR1", "6xBfsv");
			}
			if (con == null || con.isClosed()) {

				
			}
			PreparedStatement stmt = con.prepareStatement("INSERT INTO `Klant` (`KlantID`, `AdresID`, `Naam`, `telefoonnummer`, `geboortedatum`) VALUES (?,?,?,?,?)");
			stmt.setInt(1, k.getKlantID());
			stmt.setInt(2, k.getAdresID());
			stmt.setString(3, k.getNaam());
			stmt.setString(4, k.getTelefoonnummer());
			stmt.setString(5, k.getGeboortedatum());
			
			int updateCount = stmt.executeUpdate();

			
			con.close();
	
		} catch (SQLException exc) {
			System.out.println("PROBLEEM: " + exc.getMessage());
			System.out.println("fout code: " + exc.getErrorCode());
			con.close();
		}
	}
}