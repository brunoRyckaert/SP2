package model;

public class TicketSoort {
	
	private int ticketSoortID;
	private String Naam;
	private String Beschrijving;

	public int getTicketSoortID() {
		return ticketSoortID;
	}
	public void setTicketSoortID(int ticketSoortID) {
		this.ticketSoortID = ticketSoortID;
	}
	public String getNaam() {
		return Naam;
	}
	public void setNaam(String naam) {
		Naam = naam;
	}
	public String getBeschrijving() {
		return Beschrijving;
	}
	public void setBeschrijving(String beschrijving) {
		Beschrijving = beschrijving;
	}
	
	
}
