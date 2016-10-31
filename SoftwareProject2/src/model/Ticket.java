package model;

public class Ticket {
	
	private int ticketID;
	private int ticketsoortID;
	private String heenDatum;
	private int terugDatum;
	private String beginStation;
	private String eindStation;
	private double prijs;
	private int korting;
	private int aantalReizigers;
	private String aankoopTijd;
	public enum Klasse {Eerste , Tweede };
	
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
	
	public String getHeenDatum() {
		return heenDatum;
	}
	public void setHeenDatum(String heenDatum) {
		this.heenDatum = heenDatum;
	}
	public int getTerugDatum() {
		return terugDatum;
	}
	public void setTerugDatum(int terugDatum) {
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
	

}
