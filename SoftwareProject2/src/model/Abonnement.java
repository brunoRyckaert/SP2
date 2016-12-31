package model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

public class Abonnement {
	private int abonnementNummer;
	private int klantNummer;
	private String beginStation;
	
	private String eindStation;
	private Timestamp aankoopTijd;
	private Date beginDatum;
	private Date eindDatum;
	private boolean isGeldig;
	private double prijs;
	private int kortingNummer;
	public String getBeginStation() {
		return beginStation;
	}

	public void setBeginStation(String beginStation) {
		this.beginStation = beginStation;
	}

	public String getEindStation() {
		return eindStation;
	}

	public void setEindStation(String eindStation) {
		this.eindStation = eindStation;
	}
	
	public Abonnement( int klantNummer, String beginStation, String eindStation, Timestamp aankoopTijd,
			Date beginDatum, Date eindDatum, boolean isGeldig, double prijs, int kortingNummer){
		super();
		// set uniek abonnementNummer
		this.klantNummer = klantNummer;
		this.beginStation = beginStation;
		this.eindStation = eindStation;
		this.aankoopTijd = aankoopTijd;
		this.beginDatum = beginDatum;
		this.eindDatum = eindDatum;
		this.isGeldig = true;
		this.prijs = prijs;
		this.kortingNummer = kortingNummer;
	}
	
	public Abonnement() {
		// TODO Auto-generated constructor stub
	}

	// getter/setter begin-en eindStation
	public int getAbonnementNummer() {
		return abonnementNummer;
	}
	public int getKlantNummer() {
		return klantNummer;
	}
	public Timestamp getAankoopTijd() {
		return aankoopTijd;
	}
	public Date getBeginDatum() {
		return beginDatum;
	}
	public Date getEindDatum() {
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
	public void setBeginDatum(Date beginDatum) {
		this.beginDatum = beginDatum;
		
	}
	public void setEindDatum(Date eindDatum) {
		this.eindDatum = eindDatum;
				
	
	}
	
	
	
	public void setAbonnementNummer(int abonnementNummer) {
		this.abonnementNummer = abonnementNummer;
	}

	public void setAankoopTijd(Timestamp aankoopTijd) {
		this.aankoopTijd = aankoopTijd;
	}

	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}

	@Override
	public String toString() {
		return "Abonnement [getBeginStation()=" + getBeginStation() + ", getEindStation()=" + getEindStation()
				+ ", getAbonnementNummer()=" + getAbonnementNummer() + ", getKlantNummer()=" + getKlantNummer()
				+ ", getAankoopTijd()=" + getAankoopTijd() + ", getBeginDatum()=" + getBeginDatum()
				+ ", getEindDatum()=" + getEindDatum() + ", isGeldig()=" + isGeldig() + ", getPrijs()=" + getPrijs()
				+ ", getKortingNummer()=" + getKortingNummer() + "]";
	}

	public void setGeldig(boolean isGeldig) {
		this.isGeldig = isGeldig;
	}
	public void setKortingNummer(int kortingNummer) {
		this.kortingNummer = kortingNummer;
	}

}
