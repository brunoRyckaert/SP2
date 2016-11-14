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
	
	public Abonnement()
	{
		
	}	
	
	// getter/setter begin-en eindStation
	
	public Calendar getBeginDatum() {
		return beginDatum;
	}
	
	public void setBeginDatum(Calendar beginDatum) {
		this.beginDatum = beginDatum;
		// eindDatum is altijd 1 jaar later
		this.eindDatum = beginDatum;
		this.eindDatum.add(eindDatum.YEAR, +1);
	}
	
	public int getAbonnementNummer() {
		return abonnementNummer;
	}

	public void setAbonnementNummer(int abonnementNummer) {
		this.abonnementNummer = abonnementNummer;
	}

	public int getKlantNummer() {
		return klantNummer;
	}

	public void setKlantNummer(int klantNummer) {
		this.klantNummer = klantNummer;
	}

	public Calendar getAankoopTijd() {
		return aankoopTijd;
	}

	public void setAankoopTijd(Calendar aankoopTijd) {
		this.aankoopTijd = aankoopTijd;
	}

	public boolean isGeldig() {
		return isGeldig;
	}

	public void setGeldig(boolean isGeldig) {
		this.isGeldig = isGeldig;
	}

	public double getPrijs() {
		return prijs;
	}

	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}

	public int getKortingNummer() {
		return kortingNummer;
	}

	public void setKortingNummer(int kortingNummer) {
		this.kortingNummer = kortingNummer;
	}

	public Calendar getEindDatum() {
		return eindDatum;
	}
	public void setEindDatum(Calendar eindDatum) {
		this.eindDatum = eindDatum;
		// beginDatum is altijd 1 jaar vroeger
		this.beginDatum = eindDatum;
		this.beginDatum.add(beginDatum.YEAR, -1);
	}	
}
