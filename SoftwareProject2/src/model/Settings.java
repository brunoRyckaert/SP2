package model;

import model.Taal.TaalEnum;

public class Settings {
	/**
	 * Houdt bij welk personeelslid is aangemeld, of null indien geen personeelslid.
	 * Design pattern: Singleton (private constructor, public getInstance())
	 */
	private static Settings settings;
	
	private Taal taal;
	
	static {
		settings = new Settings();
	}
	
	
	public Taal getTaal() {
		return taal;
	}
	public void setTaal(Taal taal) {
		System.out.println("Taal wordt veranderd");
		taal.setTaal(taal.getTaal());}

	private Personeel ingelogdPersoneelslid;
	
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

	public Personeel getIngelogdPersoneelslid() {
		return ingelogdPersoneelslid;
	}

	public void setIngelogdPersoneelslid(Personeel ingelogdPersoneelslid) {
		this.ingelogdPersoneelslid = ingelogdPersoneelslid;
	}
}
