package model;

import java.sql.Date;
import java.util.Calendar;

public class Personeel {
	Login login = new Login();
	private Integer id;
	private Adres adres;
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
	public void setId(Integer id) {
		this.id = id;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Adres getAdres() {
		return adres;
	}
	public void setAdres(Adres adres) {
		this.adres = adres;
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
	

}
