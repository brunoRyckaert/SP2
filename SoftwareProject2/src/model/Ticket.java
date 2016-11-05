package model;

import java.time.LocalDate;

public class Ticket extends Halte{
	
	private int ticketID;
	private double prijs;
	private int aantalRijzigers;
	private String verkoper;
	private static enum Type{WEEKEND, STANDAARD, GOPASS, ANDER};
	private static enum Klasse{EERSTE, TWEEDE, KLASSEVERHOGING};
	private LocalDate startDatum;
	private LocalDate eindDatum;
	private LocalDate verkoopDatum;
	private Halte beginStation;
	private Halte eindStation;
	
	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	public double getPrijs() {
		return prijs;
	}
	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
	public int getAantalRijzigers() {
		return aantalRijzigers;
	}
	public void setAantalRijzigers(int aantalRijzigers) {
		this.aantalRijzigers = aantalRijzigers;
	}
	public String getVerkoper() {
		return verkoper;
	}
	public void setVerkoper(String verkoper) {
		this.verkoper = verkoper;
	}
	public LocalDate getStartDatum() {
		return startDatum;
	}
	public void setStartDatum(LocalDate startDatum) {
		this.startDatum = startDatum;
	}
	public LocalDate getEindDatum() {
		return eindDatum;
	}
	public void setEindDatum(LocalDate eindDatum) {
		this.eindDatum = eindDatum;
	}
	public LocalDate getVerkoopDatum() {
		return verkoopDatum;
	}
	public void setVerkoopDatum(LocalDate verkoopDatum) {
		this.verkoopDatum = verkoopDatum;
	}
	public Halte getBeginStation() {
		return beginStation;
	}
	public void setBeginStation(Halte beginStation) {
		this.beginStation = beginStation;
	}
	public Halte getEindStation() {
		return eindStation;
	}
	public void setEindStation(Halte eindStation) {
		this.eindStation = eindStation;
	}
	
	
}
