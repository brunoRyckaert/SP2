package controller;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import model.Adres;
import model.Login;
import model.Personeel;
import model.Personeelslid;

public class PersoneelDAO extends DAO {

	public Personeel getPersoon(int kassierID) {
		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			if (con == null || con.isClosed()) {
				return null;
			}

			PreparedStatement stmt = con.prepareStatement("select * from Kassier where LoginID = ?");
			stmt.setInt(1, kassierID);
			ResultSet rs = stmt.executeQuery();
			Personeel pers = new Personeel();
			pers.setNaam(null);
			pers.setPersonneelsId(kassierID);
			int adresID = 0;

			while (rs.next()) {
				pers.setLoginID(rs.getInt("LoginID"));
				pers.setAdresId(rs.getInt("AdresID"));
				pers.setNaam(rs.getString("Naam"));
				pers.setGeboorteDatum(rs.getDate("Geboortedatum"));
				pers.setIsActief(rs.getBoolean("Actief"));
				pers.setAdmin(rs.getBoolean("isAdmin"));
				pers.setStation(rs.getString("Station"));
			}
			con.close();
			if (pers.getNaam() == null) {
				return null;
			} else {
				return pers;
			}
		} catch (SQLException exc) {
			System.out.println("PROBLEEM: " + exc.getMessage());
			System.out.println("fout code: " + exc.getErrorCode());
		}
		return null;
	}

	public void add(Personeel per)
	{
		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			PreparedStatement stmt = con.prepareStatement("INSERT INTO `Kassier` (`KassierID`, `LoginID`, `adresID`, `Naam`, `geboortedatum`, `actief`, `isAdmin`, `station`) VALUES (NULL,?,?,?,?,?,?,?)");
			stmt.setInt(1, per.getLoginID());
			stmt.setInt(2, per.getAdresId());
			stmt.setString(3, per.getNaam());
			stmt.setDate(4, per.getGeboorteDatum());
			stmt.setBoolean(5, per.getIsActief());
			stmt.setBoolean(6, per.getAdmin());
			stmt.setString(7, per.getStation());
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
	
	public void update(Personeel obj) {
		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			
			PreparedStatement stmt = con.prepareStatement("UPDATE Kassier SET LoginID = ?, adresID = ?, Naam = ?, geboortedatum = ?, actief = ?, isAdmin = ?, station = ? WHERE KassierID = ?;");
			stmt.setInt(1, obj.getLoginID());
			stmt.setInt(2, obj.getAdresId());
			stmt.setString(3, obj.getNaam());
			stmt.setDate(4, obj.getGeboorteDatum());
			stmt.setBoolean(5, obj.getIsActief());
			stmt.setBoolean(5, obj.getAdmin());
			stmt.setString(5, obj.getStation());
			
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
