package model;

import java.util.Calendar;
//Adres moet er nog bij komen
public class Klant {

	private int klantNummer; 
	private String naam; 
	private String voornaam; 
	private Calendar geboortedatum; 
	private long telefoonNummer;
	
	public Klant(){}
	public Klant(int klantNummer, String naam, String voornaam, Calendar geboortedatum, long telefoonNummer){
		this.klantNummer=klantNummer; 
		this.naam=naam; 
		this.voornaam=voornaam; 
		this.geboortedatum=geboortedatum; 
		this.telefoonNummer=telefoonNummer; 
	}
	public int getKlantNummer() {
		return klantNummer;
	}
	public void setKlantNummer(int klantNummer) {
		this.klantNummer = klantNummer;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getVoornaam() {
		return voornaam;
	}
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	public Calendar getGeboortedatum() {
		
		return geboortedatum;
	}
	public void setGeboortedatum(Calendar geboortedatum) {
		this.geboortedatum = geboortedatum;
	}
	public long getTelefoonNummer() {
		return telefoonNummer;
	}
	public void setTelefoonNummer(long telefoonNummer) {
		this.telefoonNummer = telefoonNummer;
	}
}
