package controller;

import java.sql.*;

import model.Adres;

public class AdresDAO extends DAO {

	public  Adres getAdres(int adresID) throws SQLException {
		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			if (con == null || con.isClosed()) {
				return null;
			}
			PreparedStatement stmt = con.prepareStatement("select * from Adres where AdresID = ?");
			stmt.setInt(1, adresID);
			ResultSet rs = stmt.executeQuery();
			Adres adr = new Adres();
			adr.setAdresID(adresID);
			adr.setStraat(null);
			while (rs.next()) {
				adr.setStad(rs.getString("Stad"));
				adr.setStraat(rs.getString("straat"));
				adr.setNr(rs.getInt("nr"));
				adr.setGemeente(rs.getString("provincie"));
				adr.setBus(rs.getInt("bus"));
				adr.setAdresID(rs.getInt("AdresID"));
			}
			con.close();
			if (adr.getStraat() == null) {
				return null;
			} else {
				return adr;
			}
		} catch (SQLException exc) {
			System.out.println("PROBLEEM: " + exc.getMessage());
			System.out.println("fout code: " + exc.getErrorCode());
			con.close();
			return null;
		}
	}
	public Boolean setAdres(Adres adr)
	{
		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			if (con == null || con.isClosed()) {
				return false;
			}
			PreparedStatement stmt = con.prepareStatement("INSERT INTO `Adres` (`AdresID`, `Stad`, `straat`, `nr`, `gemeente`, `bus`) VALUES (NULL, ?,?,?,?,?);");
			stmt.setString(1, adr.getStad());
			stmt.setString(2, adr.getStraat());
			stmt.setInt(3, adr.getNr());
			stmt.setString(4, adr.getGemeente());
			stmt.setInt(5, adr.getBus());
			stmt.executeQuery();
			con.close();
			return true;
		} catch (SQLException exc) {
			System.out.println("PROBLEEM: " + exc.getMessage());
			System.out.println("fout code: " + exc.getErrorCode());
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			return false;
		}
	}
}
