package controller;

import java.awt.TextField;
import java.security.MessageDigest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import model.Personeelslid;

public class Login {
	/**
	 * Deze functie gaat na of de combinatie van username en wachtwoord correct is of niet. Indien correct, dan stuurt het het personeelslid terug; zoniet dan stuurt het null terug.
	 * 
	 * Basic flow: Wachtwoord hashen - database aanspreken (afsplitsen naar PersoneelsDAO maybe?) - Personelslid object aanmaken, invullen met data en returnen
	 * @param username
	 * @param wachtwoord
	 * @return Personeelslid indien combinatie juist; null indien fout.
	 */
private String username;
private String wachtwoord;
private Integer id;

	public static Personeelslid checkLogin(Login log) {
		Personeelslid perslid = null;
		LoginDAO login = new LoginDAO();
		login.checkLogin(log);
		return perslid;
	}
	
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getWachtwoord() {
		return wachtwoord;
	}


	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	/**
	 * Deze functie dient eerst via checkLogin() na te gaan of de combinatie juist is. 
	 * Zoja, dan moet het de lopende instellingen aanpassen om dit personeelslid bij te houden. (Settings.setIngelogdPersoneel())
	 * @param username
	 * @param wachtwoord
	 */
	public static void login(String username, String wachtwoord) {

	}
	
	public static String Sha512(String string) {
		return Sha512(string,"");
	}
	public static String Sha512(String string, String salt) {
		String returnString = "";
		try {
			MessageDigest m = MessageDigest.getInstance("SHA-512");
			m.update(salt.getBytes("UTF-8"));
			byte[] b = m.digest(string.getBytes("UTF-8"));
			 StringBuilder sb = new StringBuilder();
	         for(int i=0; i< b.length ;i++){
	            sb.append(Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1));
	         }
	         returnString = sb.toString();
		} catch (Exception e) { e.printStackTrace(); }
		return returnString;
	}
}
