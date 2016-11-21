package model;

import java.util.ArrayList;

public class Korting {
	
	private String beschrijving;
	
	ArrayList<Integer>ticketSoortID = new ArrayList<Integer>();
	public ArrayList<Integer> getTicketSoortID() {
		return ticketSoortID;
	}
	public void setTicketSoortID(ArrayList<Integer> ticketSoortID) {
		this.ticketSoortID = ticketSoortID;
	}
	private int kortingID;
	private float prijs;
	private Boolean isProcent;
	private int aantal;
	
	
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