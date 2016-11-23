package controller;

public class VerlorenVoorwerp {

	private int itemId;
	private int klantId;
	private String beschrijving;
	private String station;
	
	
	
	public VerlorenVoorwerp() {
		super();
	}
	
	
	public VerlorenVoorwerp(int itemId, int klantId, String beschrijving, String station) {
		super();
		this.itemId = itemId;
		this.klantId = klantId;
		this.beschrijving = beschrijving;
		this.station = station;
	}


	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getKlantId() {
		return klantId;
	}
	public void setKlantId(int klantId) {
		this.klantId = klantId;
	}
	public String getBeschrijving() {
		return beschrijving;
	}
	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}


	@Override
	public String toString() {
		return "VerlorenVoorwerp [itemId=" + itemId + ", klantId=" + klantId + ", beschrijving=" + beschrijving
				+ ", station=" + station + "]";
	}
	
	
	
	
	
}
