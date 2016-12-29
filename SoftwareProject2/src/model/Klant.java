package model;

import java.sql.Date;

public class Klant {
	private int klantID;
	private int adresID;
	private String naam;
	private String telefoonnummer;
	private Date geboortedatum;

	public Klant(int klantID, int adresID, String naam, String telefoonnummer, Date geboortedatum) {
		super();
		this.klantID = klantID;
		this.adresID = adresID;
		this.naam = naam;
		this.telefoonnummer = telefoonnummer;
		this.geboortedatum = geboortedatum;
	}
	
	public Klant(){
		super();
	}
	public int getKlantID() {
		return klantID;
	}
	public void setKlantID(int klantID) {
		this.klantID = klantID;
	}
	public int getAdresID() {
		return adresID;
	}
	public void setAdresID(int adresID) {
		this.adresID = adresID;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getTelefoonnummer() {
		return telefoonnummer;
	}
	public void setTelefoonnummer(String telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}
	public Date getGeboortedatum() {
		return geboortedatum;
	}
	public void setGeboortedatum(Date geboortedatum) {
		this.geboortedatum = geboortedatum;
	}
	
}
