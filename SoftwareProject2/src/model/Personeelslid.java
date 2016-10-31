package model;

public class Personeelslid {
	private static enum Rol { PERSONEEL, SYSADMIN };
	
	private String naam;
	private int databaseID;
	private Rol rol;
	public Personeelslid(int databaseID, String naam,Rol rol) {
		this.databaseID = databaseID;
		this.naam = naam;
		this.rol = rol;
	}
	//default constructor toegevoegd
	public Personeelslid() {
		
	}
	
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public int getDatabaseID() {
		return databaseID;
	}
	public void setDatabaseID(int databaseID) {
		this.databaseID = databaseID;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
}
