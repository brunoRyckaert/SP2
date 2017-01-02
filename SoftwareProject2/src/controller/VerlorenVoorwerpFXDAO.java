package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VerlorenVoorwerpFXDAO extends DAO {

	public ObservableList<VerlorenVoorwerpFX> getAlles() throws SQLException, ClassNotFoundException {
        
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
        ObservableList<VerlorenVoorwerpFX> empList = FXCollections.observableArrayList();
 
        while (rs.next()) {
        	VerlorenVoorwerpFX emp = new VerlorenVoorwerpFX();
            emp.setItemId(rs.getInt(1));
            emp.setKlantId(rs.getInt(2));
            emp.setBeschrijving(rs.getString(3));
            emp.setStation(rs.getString(4));
            emp.setDatumGevonden(rs.getDate(5));
            emp.setDatumOpgehaald(rs.getDate(6));
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

	
	public ArrayList<VerlorenVoorwerpFX> selectLijstVVByNaam(String be){
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
		ArrayList<VerlorenVoorwerpFX>lijst = new ArrayList<VerlorenVoorwerpFX>();
		
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
			VerlorenVoorwerpFX pers = new VerlorenVoorwerpFX();
			pers.setItemId(rs.getInt(1));
			pers.setKlantId(rs.getInt("KlantID"));
			pers.setBeschrijving(rs.getString("Beschrijving"));
			pers.setStation(rs.getString("Station"));
			pers.setTreinid(rs.getString("treinid"));
			
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
	
	


	public ArrayList<VerlorenVoorwerpFX> selectLijstVVByStation(String text) {
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
		stmt.setString(1,text);
		ResultSet rs = stmt.executeQuery();
		ArrayList<VerlorenVoorwerpFX> lijst = new ArrayList<VerlorenVoorwerpFX>();
		
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
			VerlorenVoorwerpFX pers = new VerlorenVoorwerpFX();
			pers.setItemId(rs.getInt("ItemID"));
			pers.setKlantId(rs.getInt("KlantID"));
			pers.setBeschrijving(rs.getString("Beschrijving"));
			pers.setStation(rs.getString("Station"));
			pers.setTreinid(rs.getString("treinid"));
			
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
			
		}	}


	public ArrayList<VerlorenVoorwerpFX> selectLijstVVByDAte(String be){
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
		ArrayList<VerlorenVoorwerpFX> lijst = new ArrayList<VerlorenVoorwerpFX>();
		
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
			VerlorenVoorwerpFX pers = new VerlorenVoorwerpFX();
			pers.setItemId(rs.getInt("ItemID"));
			pers.setKlantId(rs.getInt("KlantID"));
			pers.setBeschrijving(rs.getString("Beschrijving"));
			pers.setStation(rs.getString("Station"));
			pers.setTreinid(rs.getString("treinid"));
			pers.setDatumOpgehaald(rs.getDate("datumOpgehaald"));
			
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
	public static void main(String[] args) {
		VerlorenVoorwerpFXDAO a = new VerlorenVoorwerpFXDAO();
		System.out.println(a.selectLijstVVByNaam("mp3").toString());
	}
}
