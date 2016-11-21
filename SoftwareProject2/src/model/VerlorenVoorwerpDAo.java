package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.DAO;

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
	}
	public static void main(String[] args) throws SQLException {
		VerlorenVoorwerp v=new VerlorenVoorwerp(1,4,"k3 map","Brussel-Noord");
		//(int itemId, int klantId, String beschrijving, String station
		
		insertVerlorenvoorwerp(v);
		
	}
}



