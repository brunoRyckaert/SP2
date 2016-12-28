package controller;

import java.sql.*;
import java.util.ArrayList;

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
			PreparedStatement stmt = con.prepareStatement("select * from Korting where kortingID = ?");
			stmt.setInt(1, kortingID);
			ResultSet rs = stmt.executeQuery();
			Korting korting = new Korting();
			korting.setKortingID(kortingID);
			while (rs.next()) {
				korting.setPrijs(rs.getFloat("PercentageGetal"));
				korting.setIsProcent(rs.getBoolean("Procent"));
				korting.setAantal(rs.getInt("Aantal"));
				korting.setBeschrijving(rs.getString("Beschrijving"));
				//korting.setTicketSoortID((ArrayList<Integer>) rs.getArray("TicketSoortID"));
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

	public void setKorting(Korting k) throws SQLException{
		try {
<<<<<<< HEAD
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();}
			if (con == null || con.isClosed()) {

			}
			PreparedStatement stmt = con.prepareStatement("INSERT INTO `Korting` (`kortingID`, `PercentageGetal`, `IsProcent?`, `Aantal`, `Beschrijving`) VALUES (NULL,?,?,?,?)");
=======
			
				con = DAO.getInstance();
			
					PreparedStatement stmt = con.prepareStatement("INSERT INTO `Korting` (`kortingID`, `PercentageGetal`, `IsProcent?`, `Aantal`, `Beschrijving`) VALUES (NULL,?,?,?,?)");
>>>>>>> branch 'dev' of https://github.com/brunoRyckaert/SP2.git
			stmt.setInt(1, k.getKortingID());
			stmt.setDouble(2, k.getPrijs());
			stmt.setBoolean(3, k.getIsProcent());
			stmt.setInt(4, k.getAantal());
			stmt.setString(5, k.getBeschrijving());
			int updateCount = stmt.executeUpdate();

			con.close();

		} catch (SQLException exc) {
			System.out.println("PROBLEEM: " + exc.getMessage());
			System.out.println("fout code: " + exc.getErrorCode());
			con.close();
		}
	}
}
