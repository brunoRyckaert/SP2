package model;

public class Klant {
	private int klantID;
	private int adresID;
	private String naam;
	private String telefoonnummer;
	private String geboortedatum;

	public Klant(int klantID, int adresID, String naam, String telefoonnummer, String geboortedatum) {
		super();
		this.klantID = klantID;
		this.adresID = adresID;
		this.naam = naam;
		this.telefoonnummer = telefoonnummer;
		this.geboortedatum = geboortedatum;
	}
	
	public Klant(){
		super();
	}
	public int getKlantID() {
		return klantID;
	}
	public void setKlantID(int klantID) {
		this.klantID = klantID;
	}
	public int getAdresID() {
		return adresID;
	}
	public void setAdresID(int adresID) {
		this.adresID = adresID;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getTelefoonnummer() {
		return telefoonnummer;
	}
	public void setTelefoonnummer(String telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}
	public String getGeboortedatum() {
		return geboortedatum;
	}
	public void setGeboortedatum(String geboortedatum) {
		this.geboortedatum = geboortedatum;
	}

	@Override
	public String toString() {
		return "Klant [getKlantID()=" + getKlantID() + ", getAdresID()=" + getAdresID() + ", getNaam()=" + getNaam()
				+ ", getTelefoonnummer()=" + getTelefoonnummer() + ", getGeboortedatum()=" + getGeboortedatum() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adresID;
		result = prime * result + ((geboortedatum == null) ? 0 : geboortedatum.hashCode());
		result = prime * result + klantID;
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Klant other = (Klant) obj;
		if (adresID != other.adresID)
			return false;
		if (geboortedatum == null) {
			if (other.geboortedatum != null)
				return false;
		} else if (!geboortedatum.equals(other.geboortedatum))
			return false;
		if (klantID != other.klantID)
			return false;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}
	
}
