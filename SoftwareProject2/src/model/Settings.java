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
	private static Settings settings;
	private static Time tijd;
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static LocalDate localDate = LocalDate.now();
	private Taal taal;
	
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

