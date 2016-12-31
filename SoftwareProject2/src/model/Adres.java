package model;

public class Adres {
	private int adresID;
	private String stad;
	private String straat;
	private int nr;
	private String provincie;
	private int bus;
	
	

	public Adres() {
		super();
	}

	public Adres(int adresID, String stad, String straat, int nr, String gemeente, int bus) {
		super();
		this.adresID = adresID;
		this.stad = stad;
		this.straat = straat;
		this.nr = nr;
		this.provincie = gemeente;
		this.bus = bus;
	}

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

	public String getProvince() {
		return provincie;
	}

	public void setProvincie(String gemeente) {
		this.provincie = gemeente;
	}

	public int getBus() {
		return bus;
	}

	public void setBus(int bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "Adres [getAdresID()=" + getAdresID() + ", getStad()=" + getStad() + ", getStraat()=" + getStraat()
				+ ", getNr()=" + getNr() + ", getProvince()=" + getProvince() + ", getBus()=" + getBus() + "]";
	}
	
}
