package model;

public class Adres {
	private int adresID;
	private String stad;
	private String straat;
	private int nr;
	private String gemeente;
	private int bus;

	public int getAdresID() {
		return adresID;
	}

	public void setAdresID(int adresID) {
		this.adresID = adresID;
	}

	public String getStad() {
		return stad;
	}

	public void setStad(String stad) {
		this.stad = stad;
	}

	public String getStraat() {
		return straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public String getGemeente() {
		return gemeente;
	}

	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}

	public int getBus() {
		return bus;
	}

	public void setBus(int bus) {
		this.bus = bus;
	}
}
