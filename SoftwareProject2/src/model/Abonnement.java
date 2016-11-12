package model;

import java.util.Calendar;

public class Abonnement {
	private int abonnementNummer;
	private int klantNummer;
	//private Station beginStation;
	//private Station eindStation;
	private Calendar aankoopTijd;
	private Calendar beginDatum;
	private Calendar eindDatum;
	private boolean isGeldig;
	private double prijs;
	private int kortingNummer;
	
	public Abonnement(int klantNummer, Station beginStation, Station eindStation, Calendar aankoopTijd,
			Calendar beginDatum, Calendar eindDatum, boolean isGeldig, double prijs, int kortingNummer) {
		super();
		// set uniek abonnementNummer
		this.klantNummer = klantNummer;
		//this.beginStation = beginStation;
		//this.eindStation = eindStation;
		this.aankoopTijd = aankoopTijd;
		this.beginDatum = beginDatum;
		this.eindDatum = eindDatum;
		this.isGeldig = true;
		this.prijs = prijs;
		this.kortingNummer = kortingNummer;
	}
	
	// getter/setter begin-en eindStation
	public int getAbonnementNummer() {
		return abonnementNummer;
	}
	public int getKlantNummer() {
		return klantNummer;
	}
	public Calendar getAankoopTijd() {
		return aankoopTijd;
	}
	public Calendar getBeginDatum() {
		return beginDatum;
	}
	public Calendar getEindDatum() {
		return eindDatum;
	}
	public boolean isGeldig() {
		return isGeldig;
	}
	public double getPrijs() {
		return prijs;
	}
	public int getKortingNummer() {
		return kortingNummer;
	}
	public void setKlantNummer(int klantNummer) {
		this.klantNummer = klantNummer;
	}
	public void setBeginDatum(Calendar beginDatum) {
		this.beginDatum = beginDatum;
		// eindDatum is altijd 1 jaar later
		this.eindDatum = beginDatum;
		this.eindDatum.add(eindDatum.YEAR, +1);
	}
	public void setEindDatum(Calendar eindDatum) {
		this.eindDatum = eindDatum;
		// beginDatum is altijd 1 jaar vroeger
		this.beginDatum = eindDatum;
		this.beginDatum.add(beginDatum.YEAR, -1);
	}
	public void setGeldig(boolean isGeldig) {
		this.isGeldig = isGeldig;
	}
	public void setKortingNummer(int kortingNummer) {
		this.kortingNummer = kortingNummer;
	}
}
