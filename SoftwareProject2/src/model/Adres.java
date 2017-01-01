package model;

public class Adres {
	private int adresID;
	private String stad;
	private String straat;
	private int nr;
	private String provincie;
	private int bus;
<<<<<<< HEAD
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
=======

	public Adres(int adresID, String stad, String straat, int nr, String provincie, int bus) {
		this.adresID = adresID;
		this.stad = stad;
		this.straat = straat;
		this.nr = nr;
		this.provincie = provincie;
		this.bus = bus;
	}
	
	public Adres(int adresID, String stad, String straat, int nr, String provincie) {
		this.adresID = adresID;
		this.stad = stad;
		this.straat = straat;
		this.nr = nr;
		this.provincie = provincie;
	}

	public Adres() {
>>>>>>> branch 'dev' of https://github.com/brunoRyckaert/SP2.git
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

	public String getProvincie() {
		return provincie;
	}

	public void setProvincie(String provincie) {
		this.provincie = provincie;
	}

	public int getBus() {
		return bus;
	}

	public void setBus(int bus) {
		this.bus = bus;
	}
}