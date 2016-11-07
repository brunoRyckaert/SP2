package model;

import java.util.Date;

public class Ticket extends TicketSoort {

	private enum Klasse {
		Eerste(0), Tweede(1), Klasseverhoging(2);
		private int getal;

		Klasse(int getal) {
			this.setGetal(getal);
		}

		public void setGetal(int getal) {
			this.getal = getal;
		};
	}

	private Klasse klasse;
	private int ticketID;
	private int ticketsoortID;
	private Date heenDatum;
	private Date terugDatum;
	private String beginStation;
	private String eindStation;
	private double prijs;
	private float korting;
	private int aantalReizigers;
	private String aankoopTijd;
	private int verkoper;

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public int getTicketsoortID() {
		return ticketsoortID;
	}

	public void setTicketsoortID(int ticketsoortID) {
		this.ticketsoortID = ticketsoortID;
	}

	public Date getHeenDatum() {
		return heenDatum;
	}

	public void setHeenDatum(Date heenDatum) {
		this.heenDatum = heenDatum;
	}

	public Date getTerugDatum() {
		return terugDatum;
	}

	public void setTerugDatum(Date terugDatum) {
		this.terugDatum = terugDatum;
	}

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

	public double getPrijs() {
		return prijs;
	}

	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}

	public float getKorting() {
		return korting;
	}

	public void setKorting(int korting) {
		this.korting = korting;
	}

	public int getAantalReizigers() {
		return aantalReizigers;
	}

	public void setAantalReizigers(int aantalReizigers) {
		this.aantalReizigers = aantalReizigers;
	}

	public String getAankoopTijd() {
		return aankoopTijd;
	}

	public void setAankoopTijd(String aankoopTijd) {
		this.aankoopTijd = aankoopTijd;
	}

	public int getVerkoper() {
		return verkoper;
	}

	public void setVerkoper(int verkoper) {
		this.verkoper = verkoper;
	}

	public Klasse getKlasse() {
		return klasse;
	}
	public int getKlasseGetal()
	{
		return this.klasse.getal;
	}

	public void setKlasse(int klasse) {
		if(klasse == 0)
		{
			this.klasse = Klasse.Eerste;
		}
		else if(klasse == 1)
		{
			this.klasse = Klasse.Tweede;
		}
		else
		{
			this.klasse = Klasse.Klasseverhoging;
		}
	}

}
