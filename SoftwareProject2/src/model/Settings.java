package model;

import java.sql.Time;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import model.Taal.TaalEnum;

public class Settings {
	/**
	 * Houdt bij welk personeelslid is aangemeld, of null indien geen personeelslid.
	 * Design pattern: Singleton (private constructor, public getInstance())
	 */
	//api key restricties 
	/*
	 2,500 free elements per day, calculated as the sum of client-side and server-side queries.
	Maximum of 25 origins or 25 destinations per request.
	100 elements per request.
	100 elements per second, calculated as the sum of client-side and server-side queries.
	 */
	private static String api_key = "AIzaSyA9W6a84C5eHWbDcKj4LDtwK0PL5bwCL4o";
	private static Settings settings;
	private static Time tijd;
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static LocalDate localDate = LocalDate.now();
	private Taal taal;
	private static double prijsPerStation = 0.33;
	private static double prijsPerKilometer= 0.33;
	
	static {
		settings = new Settings();
	}
	
	
	public Taal getTaal() {
		return taal;
	}
	public void setTaal(Taal taal) {
		System.out.println("Taal wordt veranderd");
		this.taal.setTaal(taal.getTaal());}

	private static Personeel ingelogdPersoneelslid;
	
	private Settings() {
		ingelogdPersoneelslid = null;
		if (taal == null)
			taal = new Taal(TaalEnum.NL);
	}
	public static Settings getInstance() {
		if (Settings.settings == null) {
			Settings.settings = new Settings();
		}
		return Settings.settings;
	}

	public static Personeel getIngelogdPersoneelslid() {
		return ingelogdPersoneelslid;
	}

	public void setIngelogdPersoneelslid(Personeel ingelogdPersoneelslid) {
		this.ingelogdPersoneelslid = ingelogdPersoneelslid;
	}
	public static Time getTijd()
	{
		tijd = new Time(System.currentTimeMillis());
		return tijd;
	}
	public static String getDag()
	{
	String dag = new String();
	dag = dtf.format(localDate);
		return dag;
	}
	public static LocalDate getLocalDate()
	{
		return localDate;
	}

}

