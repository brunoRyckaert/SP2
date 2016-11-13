package model;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class Klant {

	private int klantID; 
	private String naam; 
	//private String voornaam; 
	private Calendar geboortedatum; 
	private long telefoonnummer;
	private int adresID; 
	
	public Klant(){}
	public Klant(int klantID, String naam, Calendar geboortedatum, long telefoonnummer, int adresID){
		this.klantID=klantID; 
		this.naam=naam; 
	//this.voornaam=voornaam; 
		this.geboortedatum=geboortedatum; 
		this.telefoonnummer=telefoonnummer;
		this.adresID=adresID;
	}
	public int getKlantID() {
		return klantID;
	}
	public void setKlantID(int klantID) {
		this.klantID = klantID;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Calendar getGeboortedatum() {
		
		return geboortedatum;
	}
public String getGeboortedatumAsString() {
	SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy");
	return "Geboortedatum: " + myFormat.format(geboortedatum.getTime());
	}
	public void setGeboortedatum(Calendar c) {
		
		this.geboortedatum =  c;
	}
	public long getTelefoonnummer() {
		return telefoonnummer;
	}
	public void setTelefoonnummer(long telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}
	public int getAdresID() {
		return adresID;
	}
	public void setAdresID(int adresID) {
		this.adresID = adresID;
	}
	
	
}
