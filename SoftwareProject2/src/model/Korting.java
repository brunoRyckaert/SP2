package model;

public class Korting {
	
	private String beschrijving;
	private int kortingID;
	private float prijs;
	private Boolean isProcent;
	private int aantal;
	int ticketSoortID;
	
	public int getTicketSoortID() {
		return ticketSoortID;
	}
	public void setTicketSoortID(int ticketSoortID) {
		this.ticketSoortID = ticketSoortID;
	}
	public int getKortingID() {
		return kortingID;
	}
	public void setKortingID(int kortingID) {
		this.kortingID = kortingID;
	}
	public float getPrijs() {
		return prijs;
	}
	public void setPrijs(float prijs) {
		this.prijs = prijs;
	}
	public Boolean getIsProcent() {
		return isProcent;
	}
	public void setIsProcent(Boolean isProcent) {
		this.isProcent = isProcent;
	}
	public int getAantal() {
		return aantal;
	}
	public void setAantal(int aantal) {
		this.aantal = aantal;
	}
	public String getBeschrijving() {
		return beschrijving;
	}
	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}
}