package controller;

import java.sql.*;
import java.util.ArrayList;

import model.Abonnement;
import model.Ticket;
import model.Transactie;
import model.TransactieDAO;

public class AbonnementDAO extends DAO {
	
	public Abonnement getAbonnement(int abonnementID) throws SQLException {
		try {
			if (con == null || con.isClosed()) {
				con = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1", "SP2GR1", "6xBfsv");
			}
			if (con == null || con.isClosed()) {
				return null;
			}
			PreparedStatement stmt = con.prepareStatement("select * from Abbonement where abbonementId = ?");
			stmt.setInt(1, abonnementID);
			ResultSet rs = stmt.executeQuery();
			Abonnement abbo = new Abonnement();
			abbo.setAbonnementId(abonnementID);
			while (rs.next()) {
				abbo.setKlantId(rs.getInt("klantId"));
				abbo.setBeginStation(rs.getString("beginStation"));
				abbo.setEindStation(rs.getString("eindStation"));
				abbo.setBeginDatum(rs.getDate("beginDatum"));
				abbo.setEindDatum(rs.getDate("eindDatum"));
				abbo.setGeldig(rs.getBoolean("isGeldig"));
				abbo.setPrijs(rs.getDouble("prijs"));
				abbo.setKortingId(rs.getInt("kortingId"));
				abbo.setAankoopTijd(rs.getTimestamp("aankopTijd"));
			}
			con.close();
			if (abbo.getBeginStation() == null) {
				return null;
			}
			if (abbo.getBeginStation() == null) {
				return null;
			} else {
				return abbo;
			}
		} catch (SQLException exc) {
			System.out.println("PROBLEEM: " + exc.getMessage());
			System.out.println("fout code: " + exc.getErrorCode());
			con.close();
			return null;
		}
	}

	public void add(Abonnement a) {

		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}

			PreparedStatement stmt = con.prepareStatement("INSERT INTO `Abonnement` (`abonnementId`, `klantId`, `beginStation`, `eindStation`, `beginDatum`, `eindDatum`, `isGeldig`, `prijs`, `kortingId`, `aankoopTijd`) VALUES (NULL,?,?,?,?,?,?,?,?, CURRENT_TIMESTAMP)");
			stmt.setInt(1, a.getKlantId());
			stmt.setString(2, a.getBeginStation());
			stmt.setString(3, a.getEindStation());
			stmt.setDate(4, a.getBeginDatum());
			stmt.setDate(5, a.getEindDatum());
			stmt.setBoolean(6, a.getIsGeldig());
			stmt.setDouble(7, a.getPrijs());
			stmt.setInt(8, a.getKortingId());
			stmt.setTimestamp(8, a.getAankoopTijd());

			stmt.executeUpdate();
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

	public void update(Abonnement obj) {
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
			PreparedStatement stmt = con.prepareStatement("UPDATE Abonnement SET klantId = ?, beginStation = ?, eindStation = ?, beginDatum = ?, eindDatum = ?, isGeldig = ?, prijs = ?, kortingId = ?, aankoopTijd = ? WHERE abonnementId = ?");
			stmt.setInt(1, obj.getKlantId());
			stmt.setString(2, obj.getBeginStation());
			stmt.setString(3, obj.getEindStation());
			stmt.setDate(4, obj.getBeginDatum());
			stmt.setDate(5, obj.getEindDatum());
			stmt.setBoolean(6, obj.getIsGeldig());
			stmt.setDouble(7, obj.getPrijs());
			stmt.setInt(8, obj.getKortingId());
			stmt.setTimestamp(9, obj.getAankoopTijd());
			
			int updateCount = stmt.executeUpdate();
			System.out.println("abonnement werd geupdate");
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

	public Abonnement zoekAbonnement(int abid) {
		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			if (con == null || con.isClosed()) {
				return null;

			}
			Abonnement ab = new Abonnement();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM `Abonnement` WHERE abonnementId = 1");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				ab.setAbonnementId(rs.getInt("abonnementId"));
				ab.setKlantId(rs.getInt("klantId"));
				ab.setBeginStation(rs.getString("beginStation"));
				ab.setEindStation(rs.getString("eindStation"));
				ab.setBeginDatum(rs.getDate("beginDatum"));
				ab.setEindDatum(rs.getDate("eindDatum"));
				ab.setGeldig(true);
				ab.setPrijs(rs.getDouble(8));
				ab.setKortingId(rs.getInt(9));
				ab.setAankoopTijd(rs.getTimestamp(10));

			}

			return ab;

		} catch (SQLException exc) {
			System.out.println("PROBLEEM: " + exc.getMessage());
			System.out.println("fout code: " + exc.getErrorCode());
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Abonnement> lijstAbonnement() {

		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			if (con == null || con.isClosed()) {
				return null;

			}

			ArrayList<Abonnement> lijst = new ArrayList<Abonnement>();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM `Abonnement` WHERE isGeldig = 1");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Abonnement ab = new Abonnement();
				ab.setAbonnementId(rs.getInt("abonnementId"));
				ab.setKlantId(rs.getInt("klantId"));
				ab.setBeginStation(rs.getString("beginStation"));
				ab.setEindStation(rs.getString("eindStation"));
				ab.setBeginDatum(rs.getDate("beginDatum"));
				ab.setEindDatum(rs.getDate("eindDatum"));
				ab.setGeldig(true);
				ab.setPrijs(rs.getDouble(8));
				ab.setKortingId(rs.getInt(9));
				ab.setAankoopTijd(rs.getTimestamp(10));

				lijst.add(ab);

			}

			return lijst;

		} catch (SQLException exc) {
			System.out.println("PROBLEEM: " + exc.getMessage());
			System.out.println("fout code: " + exc.getErrorCode());
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
