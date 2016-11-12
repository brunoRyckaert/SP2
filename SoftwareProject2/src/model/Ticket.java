package model;

import java.sql.Date;

public class Ticket {
	
	private int ticketID;
	private TicketSoort ticketsoortID;
	private Date heenDatum;
	private Date terugDatum;
	private String beginStation;
	private String eindStation;
	private double prijs;
	private int korting;
	private int aantalReizigers;
	private String aankoopTijd;
	public enum Klasse {Eerste , Tweede };
	
	
	
	public Ticket() {
		super();
	}
	public Ticket(int ticketID, TicketSoort ticketsoortID, Date heenDatum, Date terugDatum, String beginStation,
			String eindStation, double prijs, int korting, int aantalReizigers, String aankoopTijd) {
		super();
		this.ticketID = ticketID;
		this.ticketsoortID = ticketsoortID;
		this.heenDatum = heenDatum;
		this.terugDatum = terugDatum;
		this.beginStation = beginStation;
		this.eindStation = eindStation;
		this.prijs = prijs;
		this.korting = korting;
		this.aantalReizigers = aantalReizigers;
		this.aankoopTijd = aankoopTijd;
	}
	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	public TicketSoort getTicketsoortID() {
		return ticketsoortID;
	}
	public void setTicketsoortID(TicketSoort ticketsoortID) {
		this.ticketsoortID = ticketsoortID;
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
	public int getKorting() {
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
	

}
