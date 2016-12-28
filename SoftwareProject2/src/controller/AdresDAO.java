package controller;

import java.sql.*;

import model.Adres;
import model.Klant;

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
				adr.setProvincie(rs.getString("provincie"));
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
			PreparedStatement stmt = con.prepareStatement("INSERT INTO `Adres` (`AdresID`, `Stad`, `straat`, `nr`, `provincie`, `bus`) VALUES (NULL, ?,?,?,?,?);");
			stmt.setString(1, adr.getStad());
			stmt.setString(2, adr.getStraat());
			stmt.setInt(3, adr.getNr());
			stmt.setString(4, adr.getProvincie());
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

	
	public void add(Adres obj) throws SQLException {
		try {
			if (con == null || con.isClosed()) {
				con = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1", "SP2GR1", "6xBfsv");
			}
			
			PreparedStatement stmt = con.prepareStatement("UPDATE `Adres` SET Stad = ?, straat = ?, nr = ?, provincie = ?, bus = ? WHERE AdresID = ?;");
			stmt.setString(1, obj.getStad());
			stmt.setString(2, obj.getStraat());
			stmt.setInt(3, obj.getNr());
			stmt.setString(4, obj.getProvincie());
			stmt.setInt(5, obj.getBus());
			
			int updateCount = stmt.executeUpdate();

			con.close();
	
		} catch (SQLException exc) {
			System.out.println("PROBLEEM: " + exc.getMessage());
			System.out.println("fout code: " + exc.getErrorCode());
			con.close();
		}
	}                      
}
