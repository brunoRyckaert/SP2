package controller;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.DAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class VerlorenVoorwerpDAo extends DAO {
	
	/**
	 * voert een insert in de databank van een verlorenvoorwerp object
	 * @param v
	 * @throws SQLException
	 */
	public void insertVerlorenvoorwerp (VerlorenVoorwerp v) {
		
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
	
	public VerlorenVoorwerp selectVVByNaam(String be){
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
//		
			pers.setItemId(rs.getInt("ItemID"));
			pers.setKlantId(rs.getInt("KlantID"));
			pers.setBeschrijving(rs.getString("Beschrijving"));
			pers.setStation(rs.getString("Station"));
			
		}
		
		con.close();
		return pers;
	
		}
		catch (SQLException exc)
		{
			System.out.println("PROBLEEM: "+exc.getMessage());
			System.out.println("fout code: "+ exc.getErrorCode());
			return null;
		}
	}
	
	public ArrayList<VerlorenVoorwerp> selectLijstVVByNaam(String be){
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
		ArrayList<VerlorenVoorwerp> lijst = new ArrayList<VerlorenVoorwerp>();
		
		//pers.setKlantId(null);
		//int adresID = 0;

		while (rs.next())
		{

			VerlorenVoorwerp pers = new VerlorenVoorwerp();
			pers.setItemId(rs.getInt("ItemID"));
			pers.setKlantId(rs.getInt("KlantID"));
			pers.setBeschrijving(rs.getString("Beschrijving"));
			pers.setStation(rs.getString("Station"));
			pers.setTreinid(rs.getString("treinid"));
			
			lijst.add(pers);
			
		}
		
		con.close();
		return lijst;
	
		}
		catch (SQLException exc)
		{
			System.out.println("PROBLEEM: "+exc.getMessage());
			System.out.println("fout code: "+ exc.getErrorCode());
			return null;
			
		}
	}
	

	
	public ArrayList<VerlorenVoorwerp> selectLijstVVByStation(String be){
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

		PreparedStatement stmt = con.prepareStatement("SELECT * FROM `VerlorenItem` WHERE Station like '%' ? '%'");
		stmt.setString(1,be);
		ResultSet rs = stmt.executeQuery();
		ArrayList<VerlorenVoorwerp> lijst = new ArrayList<VerlorenVoorwerp>();
		
		

		while (rs.next())
		{

			VerlorenVoorwerp pers = new VerlorenVoorwerp();
			pers.setItemId(rs.getInt("ItemID"));
			pers.setKlantId(rs.getInt("KlantID"));
			pers.setBeschrijving(rs.getString("Beschrijving"));
			pers.setStation(rs.getString("Station"));
			pers.setTreinid(rs.getString("treinid"));
			
			lijst.add(pers);
		
		}
		
		con.close();
		return lijst;
		
		}
		catch (SQLException exc)
		{
			System.out.println("PROBLEEM: "+exc.getMessage());
			System.out.println("fout code: "+ exc.getErrorCode());
			return null;
			
		}
	}
	
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

	public ArrayList<VerlorenVoorwerp> selectLijstVVByDAte(String be){
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

		PreparedStatement stmt = con.prepareStatement("SELECT * FROM `VerlorenItem` WHERE `datumGevonden` = ?");
		stmt.setString(1,be);
		ResultSet rs = stmt.executeQuery();
		ArrayList<VerlorenVoorwerp> lijst = new ArrayList<VerlorenVoorwerp>();
		
		

		while (rs.next())
		{

			VerlorenVoorwerp pers = new VerlorenVoorwerp();
			pers.setItemId(rs.getInt("ItemID"));
			pers.setKlantId(rs.getInt("KlantID"));
			pers.setBeschrijving(rs.getString("Beschrijving"));
			pers.setStation(rs.getString("Station"));
			pers.setTreinid(rs.getString("treinid"));
			
			lijst.add(pers);
		
		}
		
		con.close();
		return lijst;
		
		}
		catch (SQLException exc)
		{
			System.out.println("PROBLEEM: "+exc.getMessage());
			System.out.println("fout code: "+ exc.getErrorCode());
			return null;
			
		}
	}
public ArrayList<VerlorenVoorwerp> getAlles() throws SQLException, ClassNotFoundException {
        
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
        ArrayList<VerlorenVoorwerp> empList = new ArrayList<VerlorenVoorwerp>();
 
        while (rs.next()) {
        	VerlorenVoorwerp emp = new VerlorenVoorwerp();
            emp.setItemId(rs.getInt(1));
            emp.setKlantId(rs.getInt(2));
            emp.setBeschrijving(rs.getString(3));
            emp.setStation(rs.getString(4));
            emp.setDatumGevonden(rs.getDate(5));
            //emp.setDatumOpgehaald(rs.getDate(6));
            emp.setKassierID(rs.getInt(7));
            emp.setTreinid(rs.getString(8));
           
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

	public static void main(String[] args) {
		VerlorenVoorwerpDAo a = new VerlorenVoorwerpDAo();
		System.out.println(a.selectLijstVVByNaam("mp3").toString());
		try {
			System.out.println(a.getAlles().toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



