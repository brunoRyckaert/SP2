package model;

import java.sql.Date;

public class Personeel implements SerializableVoorCache  {
	private int personneelsId;
	private int adresId;
	private int loginID;
	private String naam;
	private Boolean isActief;
	private Date geboorteDatum;
	private Boolean Admin;
	private String Station;
	public String getStation() {
		return Station;
	}
	public void setStation(String station) {
		Station = station;
	}
	public Boolean getAdmin() {
		return Admin;
	}
	public void setAdmin(Boolean admin) {
		Admin = admin;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public Boolean getIsActief() {
		return isActief;
	}
	public void setIsActief(Boolean isActief) {
		this.isActief = isActief;
	}
	public Date getGeboorteDatum() {
		return geboorteDatum;
	}
	public void setGeboorteDatum(Date geboorteDatum) {
		this.geboorteDatum = geboorteDatum;
	}
	public int getPersonneelsId() {
		return personneelsId;
	}
	public void setPersonneelsId(int personneelsId) {
		this.personneelsId = personneelsId;
	}
	public int getAdresId() {
		return adresId;
	}
	public void setAdresId(int adresId) {
		this.adresId = adresId;
	}
	public int getLoginID() {
		return loginID;
	}
	public void setLoginID(int loginID) {
		this.loginID = loginID;
	}
	

}
