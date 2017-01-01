package model;

import java.util.ArrayList;

public class Station {
	ArrayList<String> naam = new ArrayList<>();
	String longitude;
	String latitude;
	public Station(ArrayList<String> naam, String longitude, String latitude) {
		super();
		this.naam = naam;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public ArrayList<String> getNaam() {
		return naam;
	}
	public void setNaam(ArrayList<String> naam) {
		this.naam = naam;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	
}
