package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.DAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Personeel;

public class VerlorenVoorwerpDAo extends DAO {
	
	/**
	 * voert een insert in de databank van een verlorenvoorwerp object
	 * @param v
	 * @throws SQLException
	 */

	public void insertVerlorenvoorwerp (VerlorenVoorwerp v) throws SQLException {
		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			if (con == null || con.isClosed()) {

				
			}
			PreparedStatement stmt = con.prepareStatement(""
					+ "INSERT INTO `VerlorenItem` (`ItemID`, `KlantID`, `Beschrijving`, `Station`, `datumGevonden`, `datumOpgehaald`, `kassierID`) VALUES (NULL,?,?,?,CURRENT_DATE, NULL,?);");
			
			stmt.setInt(1, v.getKlantId());
			stmt.setString(2, v.getBeschrijving());
			stmt.setString(3, v.getStation());
			
			stmt.setInt(4,v.getKassierID());
			/*stmt.setInt(1, t.getTicketSoortID());
			stmt.setDate(2, (Date) t.getHeenDatum());
			stmt.setDate(3, (Date) t.getTerugDatum());
			stmt.setString(4, t.getBeginStation());
			stmt.setString(5, t.getEindStation());
			stmt.setDouble(6, t.getPrijs());
			stmt.setFloat(7, t.getKorting());
			stmt.setInt(8, t.getAantalReizigers());
			stmt.setInt(9, t.getKlasseGetal());*/
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
	

	public VerlorenVoorwerp selectVVByNaam(String be) throws SQLException{

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

		PreparedStatement stmt = con.prepareStatement("SELECT * FROM `VerlorenItem` WHERE Beschrijving like '%' ? '%'");
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
	
	public ObservableList<VerlorenVoorwerp> selectLijstVVByNaam(String be){
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
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM `VerlorenItem` WHERE Beschrijving like '%' ? '%'");
		stmt.setString(1,be);
		ResultSet rs = stmt.executeQuery();
		ObservableList<VerlorenVoorwerp> lijst = FXCollections.observableArrayList();
		
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
			VerlorenVoorwerp pers = new VerlorenVoorwerp();
			pers.setItemId(rs.getInt("ItemID"));
			pers.setKlantId(rs.getInt("KlantID"));
			pers.setBeschrijving(rs.getString("Beschrijving"));
			pers.setStation(rs.getString("Station"));
			
			lijst.add(pers);
			//pers = null;
		}
		
		con.close();
		return lijst;
		//System.out.println(pers.toString());
		}
		catch (SQLException exc)
		{
			System.out.println("PROBLEEM: "+exc.getMessage());
			System.out.println("fout code: "+ exc.getErrorCode());
			return null;
			
		}
	}
	
	public ObservableList<VerlorenVoorwerp> selectLijstVVByDate(String be){
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
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM `VerlorenItem` WHERE datumGevonden = ?");
		stmt.setString(1,be);
		ResultSet rs = stmt.executeQuery();
		ObservableList<VerlorenVoorwerp> lijst = FXCollections.observableArrayList() ;
		
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
			VerlorenVoorwerp pers = new VerlorenVoorwerp();
			pers.setItemId(rs.getInt("ItemID"));
			pers.setKlantId(rs.getInt("KlantID"));
			pers.setBeschrijving(rs.getString("Beschrijving"));
			pers.setStation(rs.getString("Station"));
			
			lijst.add(pers);
			//pers = null;
		}
		
		con.close();
		return lijst;
		//System.out.println(pers.toString());
		}
		catch (SQLException exc)
		{
			System.out.println("PROBLEEM: "+exc.getMessage());
			System.out.println("fout code: "+ exc.getErrorCode());
			return null;
			
		}
	}
	
//	update VerlorenItem set datumOpgehaald = CURRENT_DATE where Beschrijving like '%mp3%'
	/**
	 * wanneer een voorwerp wordt opgehaald dan wordt de datum overschreven naar de database
	 * @param besch
	 */
	public void ophalenVoorwerp(String besch)
	{

		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			if (con == null || con.isClosed()) {

				
			}
			PreparedStatement stmt = con.prepareStatement(""
					+ "update VerlorenItem set datumOpgehaald = CURRENT_DATE where Beschrijving like '%' ? '%';");
			
			stmt.setString(1, besch);
			
			
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
	public void updateVerlorenvoorwerp (int a, int b ) {
		
		try {
			if (con == null || con.isClosed()) {
				con = DAO.getInstance();
			}
			if (con == null || con.isClosed()) {

				
			}
			PreparedStatement stmt = con.prepareStatement(""
					+ "UPDATE `VerlorenItem` SET `KlantID` = ? WHERE `VerlorenItem`.`ItemID` = ?;");
			
			stmt.setInt(1,a);
			stmt.setInt(2,b);
			
//			stmt.setInt(1, t.getTicketSoortID());
//			stmt.setDate(2, (Date) t.getHeenDatum());
//			stmt.setDate(3, (Date) t.getTerugDatum());
//			stmt.setString(4, t.getBeginStation());
//			stmt.setString(5, t.getEindStation());
//			stmt.setDouble(6, t.getPrijs());
//			stmt.setFloat(7, t.getKorting());
//			stmt.setInt(8, t.getAantalReizigers());
//			stmt.setInt(9, t.getKlasseGetal());
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
public  ObservableList<VerlorenVoorwerp> getAlles() throws SQLException, ClassNotFoundException {
        
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

		PreparedStatement stmt = con.prepareStatement("SELECT * FROM `VerlorenItem`");
		
		ResultSet rs = stmt.executeQuery();
		
		//Declare a observable List which comprises of Employee objects
        ObservableList<VerlorenVoorwerp> empList = FXCollections.observableArrayList(); ;

        while (rs.next()) {
        	VerlorenVoorwerp emp = new VerlorenVoorwerp();
            emp.setItemId(rs.getInt(1));
            emp.setKlantId(rs.getInt(2));
            emp.setBeschrijving(rs.getString(3));
            emp.setStation(rs.getString(4));
            emp.setDatumGevonden(rs.getDate(5));
            emp.setDatumOpgehaald(rs.getDate(6));
            emp.setKassierID(rs.getInt(7));
          //  emp.setTreinid(rs.getString(8)); uncommenten!
           
            //Add employee to the ObservableList
            empList.add(emp);
        }
        //return empList (ObservableList of Employees)
        System.out.println(empList.toString());
        return empList;
    } 
		catch (SQLException exc) {
		System.out.println("PROBLEEM: " + exc.getMessage());
		System.out.println("fout code: " + exc.getErrorCode());
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			con.close();
		}
}
		return null;
	}


public ObservableList<VerlorenVoorwerp> selectLijstVVByStation(String text) {
	// TODO Auto-generated method stub

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

	PreparedStatement stmt = con.prepareStatement("SELECT * FROM `VerlorenItem` where station like '%' ? '%'");
	stmt.setString(1, text);
	ResultSet rs = stmt.executeQuery();
	
	//Declare a observable List which comprises of Employee objects
    ObservableList<VerlorenVoorwerp> empList = FXCollections.observableArrayList(); ;

    while (rs.next()) {
    	VerlorenVoorwerp emp = new VerlorenVoorwerp();
        emp.setItemId(rs.getInt(1));
        emp.setKlantId(rs.getInt(2));
        emp.setBeschrijving(rs.getString(3));
        emp.setStation(rs.getString(4));
        emp.setDatumGevonden(rs.getDate(5));
        emp.setDatumOpgehaald(rs.getDate(6));
        emp.setKassierID(rs.getInt(7));
      //  emp.setTreinid(rs.getString(8)); uncommenten!
       
        //Add employee to the ObservableList
        empList.add(emp);
    }
    //return empList (ObservableList of Employees)
    System.out.println(empList.toString());
    return empList;
} 
	catch (SQLException exc) {
	System.out.println("PROBLEEM: " + exc.getMessage());
	System.out.println("fout code: " + exc.getErrorCode());
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
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
	return null;
	
}
}



