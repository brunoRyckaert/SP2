package model;

public class TicketSoort implements SerializableVoorCache  {
	
	private int ticketSoortID;
	private String Naam;
	private String Beschrijving;
	private String prijsBerekening;

	@Override
	public String toString() {
		return "TicketSoort [getPrijsBerekening()=" + getPrijsBerekening() + ", getTicketSoortID()="
				+ getTicketSoortID() + ", getNaam()=" + getNaam() + ", getBeschrijving()=" + getBeschrijving() + "]";
	}
	public String getPrijsBerekening() {
		return prijsBerekening;
	}
	public void setPrijsBerekening(String prijsBerekening) {
		this.prijsBerekening = prijsBerekening;
	}
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
