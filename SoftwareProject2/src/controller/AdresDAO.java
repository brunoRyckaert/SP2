package controller;

import java.sql.*;

import model.Adres;

public class AdresDAO extends DAO {

	public Adres getAdres(int adresID) throws SQLException {
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
	
	public void insertAdres(Adres a)
	{
		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			if (con == null || con.isClosed()) {
				System.out.println("no connection");
			}
			PreparedStatement stmt = con.prepareStatement("INSERT INTO `Adres` (`AdresID`, `Stad`, `straat`, `nr`, `provincie`, `bus`) VALUES (NULL, ?,?,?,?, ?);");
			stmt.setString(1,a.getProvince());
			stmt.setString(2,a.getStraat());
			stmt.setInt(3,a.getNr());
			stmt.setString(4, a.getStad());
			stmt.setInt(5,a.getBus());
			stmt.executeUpdate();
			
			
			con.close();
			
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
	}
	
	public Adres selectAdres (Adres a)
	{
		//SELECT * FROM `Adres` where Stad like '% %' and straat like '% %' and nr like'%1%' and provincie like '%%' and bus like '%0%'
		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			if (con == null || con.isClosed()) {
				return null;
			}
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM `Adres` where Stad = ? and straat = ? and nr = ? and provincie = ? and bus = ? ");
			stmt.setString(1, a.getStad());
			stmt.setString(2, a.getStraat());
			stmt.setInt(3, a.getNr());
			stmt.setString(4, a.getProvince());
			stmt.setInt(5, a.getBus());
			ResultSet rs = stmt.executeQuery();
			Adres adr = new Adres();		
			
			while (rs.next()) {
				adr.setAdresID(rs.getInt(1));
				adr.setStad(rs.getString(2));
				adr.setStraat(rs.getString(3));
				adr.setNr(rs.getInt(4));
				adr.setProvincie(rs.getString(5));
				adr.setBus(rs.getInt(6));
			}
			con.close();
			
				return adr;
			
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
	}
	public static void main(String[] args) {
	
		Adres a = new Adres();
		a.setBus(4);
		a.setProvincie("Brussel");
		a.setNr(30);
		a.setStad("Molenbeek");
		a.setStraat("geen straat");
		AdresDAO b = new AdresDAO();
		System.out.println(b.selectAdres(a).toString());
	}
	
}
