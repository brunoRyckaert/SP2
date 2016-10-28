package controller;

import java.security.MessageDigest;

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
	public static Personeelslid checkLogin(String username, String wachtwoord) {
		Personeelslid perslid = null;
		return perslid;
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
