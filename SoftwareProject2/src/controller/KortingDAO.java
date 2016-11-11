package controller;

import java.sql.*;
import model.Korting;

public class KortingDAO extends DAO {
	public Korting getKorting(int kortingID) throws SQLException {
		try {
			if (con == null || con.isClosed()) {
				con = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1", "SP2GR1", "6xBfsv");
			}
			if (con == null || con.isClosed()) {
				return null;

			}
			PreparedStatement stmt = con.prepareStatement("select * from Korting where kortingID = ?");
			stmt.setInt(1, kortingID);
			ResultSet rs = stmt.executeQuery();
			Korting korting = new Korting();
			korting.setKortingID(kortingID);
			while (rs.next()) {
				korting.setPrijs(rs.getDouble("Prijs"));
				korting.setIsProcent(rs.getBoolean("IsProcent?"));
				korting.setAantal(rs.getInt("Aantal"));
				korting.setIsAantal(rs.getBoolean("IsAantal? "));
				korting.setType(rs.getInt("Type"));
				con.close();
				if (korting.getKortingID() == -1) {

					return null;
				} else {

					return korting;
				}
			}
		} catch (SQLException exc) {
			System.out.println("PROBLEEM: " + exc.getMessage());
			System.out.println("fout code: " + exc.getErrorCode());
			con.close();
			return null;
		}
	}

	public void setKorting(Korting k) throws SQLException {
		try {
			if (con == null || con.isClosed()) {
				con = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1", "SP2GR1", "6xBfsv");
			}
			if (con == null || con.isClosed()) {

			}
			PreparedStatement stmt = con.prepareStatement("INSERT INTO `Korting` (`kortingID`, `Prijs`, `IsProcent?`, `Aantal`, `IsAantal?`, `Type`) VALUES (NULL,?,?,?,?,?)");
			stmt.setInt(1, k.getKortingID());
			stmt.setDouble(2, k.getPrijs());
			stmt.setBoolean(3, k.getIsProcent());
			stmt.setInt(4, k.getAantal());
			stmt.setBoolean(5, k.getIsAantal());
			stmt.setInt(6, k.getTypeGetal());
			int updateCount = stmt.executeUpdate();

			con.close();

		} catch (SQLException exc) {
			System.out.println("PROBLEEM: " + exc.getMessage());
			System.out.println("fout code: " + exc.getErrorCode());
			con.close();
		}
	}
}
