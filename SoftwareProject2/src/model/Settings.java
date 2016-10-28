package model;

public class Settings {
	/**
	 * Houdt bij welk personeelslid is aangemeld, of null indien geen personeelslid.
	 * Design pattern: Singleton (private constructor, public getInstance())
	 */
	private static Settings settings;
	
	private Personeelslid ingelogdPersoneelslid;
	
	private Settings() {
		ingelogdPersoneelslid = null;
	}
	public Settings getInstance() {
		if (Settings.settings == null) {
			Settings.settings = new Settings();
		}
		return Settings.settings;
	}

	public Personeelslid getIngelogdPersoneelslid() {
		return ingelogdPersoneelslid;
	}

	public void setIngelogdPersoneelslid(Personeelslid ingelogdPersoneelslid) {
		this.ingelogdPersoneelslid = ingelogdPersoneelslid;
	}
}
