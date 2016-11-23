package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.DAO;
import model.Personeel;

public class VerlorenVoorwerpDAo extends DAO {
	
	/**
	 * @param v
	 * @throws SQLException
	 */
	public static void insertVerlorenvoorwerp (VerlorenVoorwerp v) throws SQLException {
		
		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			if (con == null || con.isClosed()) {

				
			}
			PreparedStatement stmt = con.prepareStatement(""
					+ "INSERT INTO `VerlorenItem` (`ItemID`, `KlantID`, `Beschrijving`, `Station`) VALUES (NULL,?, ?, ?);");
			
			stmt.setInt(1, v.getKlantId());
			stmt.setString(2, v.getBeschrijving());
			stmt.setString(3, v.getStation());
			/*stmt.setInt(1, t.getTicketSoortID());
			stmt.setDate(2, (Date) t.getHeenDatum());
			stmt.setDate(3, (Date) t.getTerugDatum());
			stmt.setString(4, t.getBeginStation());
			stmt.setString(5, t.getEindStation());
			stmt.setDouble(6, t.getPrijs());
			stmt.setFloat(7, t.getKorting());
			stmt.setInt(8, t.getAantalReizigers());
			stmt.setInt(9, t.getKlasseGetal());*/
			int updateCount = stmt.executeUpdate();

			
			con.close();
	
	
		} catch (SQLException exc) {
			System.out.println("PROBLEEM: " + exc.getMessage());
			System.out.println("fout code: " + exc.getErrorCode());
			con.close();
		}
		finally
		{
			con.close();
		}
		
	}
	
	public static VerlorenVoorwerp selectVVByNaam(String be) throws SQLException{
		try
		{
			if( con == null || con.isClosed())
			{
				con = DAO.getInstance();
			}
			if( con == null || con.isClosed())
			{
				return null;
			}

		PreparedStatement stmt = con.prepareStatement("SELECT * FROM `VerlorenItem` WHERE `Beschrijving` LIKE ?");
		stmt.setString(1,be);
		ResultSet rs = stmt.executeQuery();
		VerlorenVoorwerp pers = new VerlorenVoorwerp();
		//pers.setKlantId(null);
		//int adresID = 0;

		while (rs.next())
		{
//		pers.setId(rs.getInt("KassierID"));
//		pers.setNaam(rs.getString("Naam"));
//		pers.setGeboorteDatum(rs.getDate("geboortedatum"));
//		pers.setIsActief(rs.getBoolean("actief"));
//		adresID = rs.getInt("adresID");
//		pers.setAdmin(rs.getBoolean("isAdmin"));
			pers.setItemId(rs.getInt("ItemID"));
			pers.setKlantId(rs.getInt("KlantID"));
			pers.setBeschrijving(rs.getString("Beschrijving"));
			pers.setStation(rs.getString("Station"));
			
		}
		
		con.close();
		return pers;
		//System.out.println(pers.toString());
		}
		catch (SQLException exc)
		{
			System.out.println("PROBLEEM: "+exc.getMessage());
			System.out.println("fout code: "+ exc.getErrorCode());
			return null;
		}
	}

	public static void main(String[] args) throws SQLException {
		System.out.println(selectVVByNaam("k3 map").toString());
		//p
	}
}



