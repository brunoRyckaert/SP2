package controller;
import java.sql.*;
import java.util.Scanner;

import controller.Login;

public class Main {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("geef je gebruikersnaam: ");
		String naam = sc.nextLine();
		System.out.print("geef je wachtwoord: ");
		String ww = sc.nextLine();
		LoginDAO loginDAO = new LoginDAO();
		if(loginDAO.checkLogin(naam, ww))
		{
			System.out.println("gelukt");
			try
			{
				Login log = loginDAO.getLogin(naam,ww);

				PersoneelDAO personeelDAO = new PersoneelDAO();
				Personeel user = personeelDAO.getPersoon(log.getId());
				user.setLogin(log);
				System.out.println("Persoon is ingelogd");
				System.out.println("naam: "+user.getNaam());
				System.out.println("usernaam: "+user.getLogin().getUsername());
				System.out.println("ww: "+user.getLogin().getWachtwoord());
				System.out.println("stad: "+user.getAdres().getStad());
				System.out.println("straat: "+user.getAdres().getStraat());
				System.out.println("nr: "+user.getAdres().getNr());
				System.out.println("gemeente: "+user.getAdres().getGemeente());
				System.out.println("bus: "+user.getAdres().getBus());
			}
			catch(SQLException exc)
			{
				System.out.println("PROBLEEM: "+exc.getMessage());
				System.out.println("fout code: "+ exc.getErrorCode());
			}
		}
		else 
		{
			System.out.println("login gegevens zijn foutief");
		}
	}
}
