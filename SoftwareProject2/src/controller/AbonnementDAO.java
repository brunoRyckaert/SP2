package controller;


import java.sql.*;
import java.util.ArrayList;

import model.Abonnement;
import model.Adres;
import model.Ticket;
import model.Transactie;
import model.TransactieDAO;

public class AbonnementDAO extends DAO {
	/* Abonnement tabel moet nog gecreëerd worden
	public Abonnement getAbonnement(int abonnementID)
	{
		try
		{
			if( con == null || con.isClosed())
			{
				con = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR1","SP2GR1","6xBfsv");
			}
			if( con == null || con.isClosed())
			{
				return null;
			}
			
		}
	}
	*/
	
	public void insertAbonnement(Abonnement a) {
	
	try {
		if (con == null || con.isClosed()) {
			con = DAO.getInstance();
		}
		
		PreparedStatement stmt = con.prepareStatement("INSERT INTO `Abonnement` (`abonnementId`, `klantId`, `beginStation`, `eindStation`, `beginDatum`, `eindDatum`, `isGeldig`, `prijs`, `kortingId`, `aankoopTijd`) VALUES (NULL, ?, ?, ?,?,?,?,?,?, CURRENT_TIMESTAMP)");
		stmt.setInt(1,a.getKlantNummer());
		stmt.setString(2, a.getBeginStation());
		stmt.setString(3, a.getEindStation());
		stmt.setDate(4, a.getBeginDatum());
		stmt.setDate(5, a.getEindDatum());
		stmt.setBoolean(6, a.isGeldig());
		stmt.setDouble(7, a.getPrijs());
		stmt.setInt(8, a.getKortingNummer());
		
		stmt.executeUpdate();
		
	
	} catch (SQLException exc) {
		System.out.println("PROBLEEM: " + exc.getMessage());
		System.out.println("fout code: " + exc.getErrorCode());
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	finally
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	public void extendAbonnement(Date datum, int abid)
	{
		try {
			try {
				if (con == null || con.isClosed()) {
					con = DAO.getInstance();
				}
				else{
					System.out.println("no connection");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//String sql = "UPDATE Abonnement set eindDatum = ? where abonnementId = ?";
			PreparedStatement stmt = con.prepareStatement("UPDATE Abonnement set eindDatum = ? where abonnementId = ?");
			stmt.setInt(2,abid);
			stmt.setDate(1,datum);
			stmt.executeUpdate();
			System.out.println("abonnement werdt geUpdate");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				con.isClosed();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
	}
	
	public  Abonnement zoekAbonnement(int abid)
	{
		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			if (con == null || con.isClosed()) {
				return null;
				
			}
			
					//ArrayList<Abonnement>lijst=new ArrayList<Abonnement>();
					Abonnement ab = new Abonnement();
					PreparedStatement stmt = con.prepareStatement("SELECT * FROM `Abonnement` WHERE abonnementId = 1");
					
					ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
			
				ab.setAbonnementNummer(rs.getInt("abonnementid"));
				ab.setKlantNummer(rs.getInt("klantid"));
				ab.setBeginStation(rs.getString("beginStation"));
				ab.setEindStation(rs.getString("eindStation"));
				ab.setBeginDatum(rs.getDate("beginDatum"));
				ab.setEindDatum(rs.getDate("eindDatum"));
				ab.setGeldig(true);
				ab.setPrijs(rs.getDouble(8));
				ab.setKortingNummer(rs.getInt(9));
				ab.setAankoopTijd(rs.getTimestamp(10));
				
			}
			
			return ab;
	
			
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
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static ArrayList<Abonnement> lijstAbonnement()
	{
		
		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			if (con == null || con.isClosed()) {
				return null;
				
			}
			
			ArrayList<Abonnement> lijst=new ArrayList<Abonnement>();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM `Abonnement` WHERE isGeldig = 1");
			
			ResultSet rs = stmt.executeQuery();
	while (rs.next()) {
		Abonnement ab = new Abonnement();
		ab.setAbonnementNummer(rs.getInt("abonnementid"));
		ab.setKlantNummer(rs.getInt("klantid"));
		ab.setBeginStation(rs.getString("beginStation"));
		ab.setEindStation(rs.getString("eindStation"));
		ab.setBeginDatum(rs.getDate("beginDatum"));
		ab.setEindDatum(rs.getDate("eindDatum"));
		ab.setGeldig(true);
		ab.setPrijs(rs.getDouble(8));
		ab.setKortingNummer(rs.getInt(9));
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
		
	}
	

	
	public static void main(String[] args) {
		
		System.out.println(lijstAbonnement().toString());
	}
}
