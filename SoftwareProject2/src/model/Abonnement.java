package model;

import java.io.File;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import controller.CacheController;

public class Abonnement implements SerializableVoorCache {
	private int abonnementId;
	private int klantId;
	private String beginStation;
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
	private String eindStation;
	private Timestamp aankoopTijd;
	private Date beginDatum;
	private Date eindDatum;
	private boolean isGeldig;
	private double prijs;
	private int kortingId;
	
	public Abonnement( int klantId, String beginStation, String eindStation, Timestamp aankoopTijd,
			Date beginDatum, Date eindDatum, boolean isGeldig, double prijs, int kortingId){
		super();
		this.klantId = klantId;
		this.beginStation = beginStation;
		this.eindStation = eindStation;
		this.aankoopTijd = aankoopTijd;
		this.beginDatum = beginDatum;
		this.eindDatum = eindDatum;
		this.isGeldig = true;
		this.prijs = prijs;
		this.kortingId = kortingId;
	}
	
	public Abonnement() {
	}
	public int getAbonnementId() {
		return abonnementId;
	}
	public int getKlantId() {
		return klantId;
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
	public boolean getIsGeldig() {
		return isGeldig;
	}
	public double getPrijs() {
		return prijs;
	}
	public int getKortingId() {
		return kortingId;
	}
	public void setKlantId(int klantId) {
		this.klantId = klantId;
	}
	public void setBeginDatum(Date beginDatum) {
		this.beginDatum = beginDatum;
	}
	public void setEindDatum(Date eindDatum) {
		this.eindDatum = eindDatum;
	}
	
	public void setAbonnementId(int abonnementId) {
		this.abonnementId = abonnementId;
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
				+ ", getAbonnementId()=" + getAbonnementId() + ", getKlantNummer()=" + getKlantId()
				+ ", getAankoopTijd()=" + getAankoopTijd() + ", getBeginDatum()=" + getBeginDatum()
				+ ", getEindDatum()=" + getEindDatum() + ", isGeldig()=" + isGeldig() + ", getPrijs()=" + getPrijs()
				+ ", getKortingNummer()=" + getKortingId() + "]";
	}

	public void setGeldig(boolean isGeldig) {
		this.isGeldig = isGeldig;
	}
	public void setKortingId(int kortingId) {
		this.kortingId = kortingId;
	}
	public boolean isGeldig() {
		return isGeldig;
	}
}
