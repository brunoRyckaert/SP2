package controller;

public class StatStation {

	private int aantal;
	private String naam;
	public StatStation() {
		super();
	}
	public StatStation(int aantal, String naam) {
		super();
		this.aantal = aantal;
		this.naam = naam;
	}
	public int getAantal() {
		return aantal;
	}
	public void setAantal(int aantal) {
		this.aantal = aantal;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	@Override
	public String toString() {
		return "StatStation [aantal=" + aantal + ", naam=" + naam + "]";
	}
}
