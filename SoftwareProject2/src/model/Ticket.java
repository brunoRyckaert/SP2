package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import controller.CacheController;

public class Ticket extends TicketSoort implements SerializableVoorCache {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 8421807318242705395L;

	@Override
	public String toString() {
		return "Ticket [klasse=" + klasse + ", ticketID=" + ticketID + ", ticketsoortID=" + ticketsoortID
				+ ", heenDatum=" + heenDatum + ", terugDatum=" + terugDatum + ", beginStation=" + beginStation
				+ ", eindStation=" + eindStation + ", prijs=" + prijs + ", korting=" + korting + ", aantalReizigers="
				+ aantalReizigers + ", aankoopTijd=" + aankoopTijd + ", verkoper=" + verkoper + "]";
	}
	
	
	public static void main(String[] args) {
		Ticket.getAfstandByStations(Definitions.getStationByName("Koksijde"), Definitions.getStationByName("Brussel-Zuid"));
	}
	
	public static int getAfstandByStations(Station beginStation, Station eindStation) {
		int afstand = -1;
		String key = "AIzaSyA9W6a84C5eHWbDcKj4LDtwK0PL5bwCL4o";
		URL url;
		
		try {
			url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?units=SI&origins=" + beginStation.getLatitude() + "," + beginStation.getLongitude() + "&destinations=" + eindStation.getLatitude() + "," + eindStation.getLongitude()+"&key=" + key);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readValue(url, JsonNode.class);
			afstand = Integer.parseInt(rootNode.get("rows").get(0).get("elements").get(0).get("distance").get("text").asText().split(" ")[0]);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return afstand;
		//maps.googleapis.com/maps/api/distancematrix/json?units=SI&origins=51.079197,2.65277&destinations=50.835707,4.336531&key=AIzaSyA9W6a84C5eHWbDcKj4LDtwK0PL5bwCL4o
	}

	private enum Klasse {
		Eerste(0), Tweede(1), Klasseverhoging(2);
		private int getal;

		Klasse(int getal) {
			this.setGetal(getal);
		}

		public void setGetal(int getal) {
			this.getal = getal;
		};
	}

	private Klasse klasse;
	private int ticketID;
	private int ticketsoortID;
	private Date heenDatum;
	private Date terugDatum;
	private String beginStation;
	private String eindStation;
	private double prijs;
	private float korting;
	private int aantalReizigers;
	private String aankoopTijd;
	private int verkoper;

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public int getTicketsoortID() {
		return ticketsoortID;
	}

	public void setTicketsoortID(int ticketsoortID) {
		this.ticketsoortID = ticketsoortID;
	}

	public Date getHeenDatum() {
		return heenDatum;
	}

	public void setHeenDatum(Date heenDatum) {
		this.heenDatum = heenDatum;
	}

	public Date getTerugDatum() {
		return terugDatum;
	}

	public void setTerugDatum(Date terugDatum) {
		this.terugDatum = terugDatum;
	}

	public String getBeginStation() {
		return beginStation;
	}

	public void setBeginStation(String beginStation) {
		this.beginStation = beginStation;
	}

	public String getEindStation() {
		return eindStation;
	}

	public void setEindStation(String eindStation) {
		this.eindStation = eindStation;
	}

	public double getPrijs() {
		return prijs;
	}

	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}

	public float getKorting() {
		return korting;
	}

	public void setKorting(int korting) {
		this.korting = korting;
	}

	public int getAantalReizigers() {
		return aantalReizigers;
	}

	public void setAantalReizigers(int aantalReizigers) {
		this.aantalReizigers = aantalReizigers;
	}

	public String getAankoopTijd() {
		return aankoopTijd;
	}

	public void setAankoopTijd(String aankoopTijd) {
		this.aankoopTijd = aankoopTijd;
	}

	public int getVerkoper() {
		return verkoper;
	}

	public void setVerkoper(int verkoper) {
		this.verkoper = verkoper;
	}

	public Klasse getKlasse() {
		return klasse;
	}
	public int getKlasseGetal()
	{
		return this.klasse.getal;
	}

	public void setKlasse(int klasse) {
		if(klasse == 0)
		{
			this.klasse = Klasse.Eerste;
		}
		else if(klasse == 1)
		{
			this.klasse = Klasse.Tweede;
		}
		else
		{
			this.klasse = Klasse.Klasseverhoging;
		}
	}
	
	/*public boolean serialize() {
		return serialize(Definitions.getCacheFile());
	}
	
	public boolean serialize(File destination) {
		return CacheController.serialize(this,destination);
	}*/

}
