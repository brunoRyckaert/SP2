package controller;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Klant;

public class KlantDAO extends DAO{
	/**
	 * geeft een klant terug op basis van zijn klantid
	 * @param klantID
	 * @return
	 */
	public Klant getKlant(int klantID) {
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
				klant.setGeboortedatum(rs.getString("Geboortedatum"));
			}
			return klant;
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
	
	public ArrayList<Klant> alleKlanten()
	{
		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			if (con == null || con.isClosed()) {
				return null;
				
			}
			PreparedStatement stmt = con.prepareStatement("select * from Klant ");
			
			ResultSet rs = stmt.executeQuery();
			ArrayList<Klant> klanten = new ArrayList<Klant>();
			
			while (rs.next()) {
				Klant klant=new Klant();
				klant.setKlantID(rs.getInt(1));
				klant.setAdresID(rs.getInt(2));
				klant.setNaam(rs.getString("Naam"));
				klant.setTelefoonnummer(rs.getString("Telefoonnummer"));
				klant.setGeboortedatum(rs.getString("Geboortedatum"));
				
				klanten.add(klant);
			}
			return klanten;
		} catch (SQLException exc) {
//			System.out.println("PROBLEEM: " + exc.getMessage());
//			System.out.println("fout code: " + exc.getErrorCode());
			System.out.println("SQLException");
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
	
	/**
	 * voegt een klant toe in de databank dankzij een object klant
	 * @param k
	 */
	public void insertKlant(Klant k) {
		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			if (con == null || con.isClosed()) {
				System.out.println("no connection");
				
			}
			PreparedStatement stmt = con.prepareStatement("INSERT INTO `Klant` (`KlantID`, `AdresID`, `Naam`, `telefoonnummer`, `geboortedatum`) VALUES (null,?,?,?,?)");
			//stmt.setInt(1, k.getKlantID());
			stmt.setInt(1, k.getAdresID());
			stmt.setString(2, k.getNaam());
			stmt.setString(3, k.getTelefoonnummer());
			stmt.setString(4, k.getGeboortedatum());
			
			int updateCount = stmt.executeUpdate();

			
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

public static void main(String[] args) {
	KlantDAO k = new KlantDAO();
	for (int i = 0; i < k.alleKlanten().size(); i++) {
		System.out.println(k.alleKlanten().get(i).toString()+ "\n");	}
}

}
