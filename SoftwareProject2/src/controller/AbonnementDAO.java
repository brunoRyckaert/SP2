package controller;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Abonnement;
import java.util.Calendar;

public class AbonnementDAO extends DAO {
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
			PreparedStatement stmt = con.prepareStatement("select * from Abonnement where abonnementId = ?");
			stmt.setInt(1, abonnementID);
			ResultSet rs = stmt.executeQuery();
			Abonnement abo = new Abonnement();
			abo.setAbonnementNummer(0);
			
			while (rs.next()){
				abo.setAbonnementNummer(rs.getInt("abonnementId"));
				abo.setKlantNummer(rs.getInt("klantId"));
				// Stations
				
				Calendar calendar = Calendar.getInstance(); //Convert Timestamp naar Calendar
				calendar.setTime(rs.getTimestamp("aankoopTijd")); // calendar zetten op aankooptijd
				abo.setAankoopTijd(calendar);
				calendar.setTime(rs.getTimestamp("beginDatum")); // calendar zetten op beginDatum
				abo.setBeginDatum(calendar);
				calendar.setTime(rs.getTimestamp("eindDatum")); // calendar zetten op eindDatum
				abo.setEindDatum(calendar);
				
				abo.setGeldig(rs.getBoolean("isGeldig"));
				abo.setPrijs(rs.getDouble("prijs"));
				abo.setKortingNummer(rs.getInt("kortingId"));
			}
			con.close();
			if(abo.getAbonnementNummer() == 0)
			{
				return null;
			}
			else{
				return abo;
			}
		}
		catch (SQLException exc)
		{
			return null;
		}
	}
}
