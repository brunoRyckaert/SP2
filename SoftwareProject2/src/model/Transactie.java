package model;

public class Transactie {
	
	private int transactieId;
	private int ticketId;
	private int personeelId;
	private double totaalbedrag;
	public Transactie(int transactieId, int ticketId, int personeelId, double totaalbedrag) {
		super();
		this.transactieId = transactieId;
		this.ticketId = ticketId;
		this.personeelId = personeelId;
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
	public int getTicketId() {
		return ticketId;
	}
	public void setTicket(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getPersoneelId() {
		return personeelId;
	}
	public void setPersoneel(int personeelId) {
		this.personeelId = personeelId;
	}
	public double getTotaalbedrag() {
		return totaalbedrag;
	}
	public void setTotaalbedrag(double totaalbedrag) {
		this.totaalbedrag = totaalbedrag;
	}
	
	
	
	
		

}
