package model;

public class Transactie {
	
	private int transactieId;
	private Ticket ticket;
	private Personeel personeel;
	private double totaalbedrag;
	public Transactie(int transactieId, Ticket ticket, Personeel personeel, double totaalbedrag) {
		super();
		this.transactieId = transactieId;
		this.ticket = ticket;
		this.personeel = personeel;
		this.totaalbedrag = totaalbedrag;
	}
	public Transactie() {
		super();
	}
	public int getTransactieId() {
		return transactieId;
	}
	public void setTransactieId(int transactieId) {
		this.transactieId = transactieId;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public Personeel getPersoneel() {
		return personeel;
	}
	public void setPersoneel(Personeel personeel) {
		this.personeel = personeel;
	}
	public double getTotaalbedrag() {
		return totaalbedrag;
	}
	public void setTotaalbedrag(double totaalbedrag) {
		this.totaalbedrag = totaalbedrag;
	}
	
	
	
	
		

}
