package model;

import java.util.Calendar;

public class Klant {

	private int klantNummer; 
	private String naam; 
	private String voornaam; 
	private Calendar geboortedatum; 
	private long telefoonNummer;
	private Adres adres; 
	
	public Klant(){}
	public Klant(int klantNummer, String naam, String voornaam, Calendar geboortedatum, long telefoonNummer, Adres adres){
		this.klantNummer=klantNummer; 
		this.naam=naam; 
		this.voornaam=voornaam; 
		this.geboortedatum=geboortedatum; 
		this.telefoonNummer=telefoonNummer;
		this.adres=adres;
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
	public Adres getAdres() {
		return adres;
	}
	public void setAdres(Adres adres) {
		this.adres = adres;
	}
	
}
