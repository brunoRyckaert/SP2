package model;

public class Settings {
	/**
	 * Houdt bij welk personeelslid is aangemeld, of null indien geen personeelslid.
	 * Design pattern: Singleton (private constructor, public getInstance())
	 */
	private static Settings settings;
	
	private Personeel ingelogdPersoneelslid;
	
	private Settings() {
		ingelogdPersoneelslid = null;
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
