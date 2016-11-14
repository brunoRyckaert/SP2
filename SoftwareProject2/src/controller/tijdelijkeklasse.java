package controller;

import java.sql.SQLException;

import model.Korting;

public class tijdelijkeklasse {
	public static void main(String[] args) {
		Korting k = new Korting();
		KortingDAO dao = new KortingDAO();
			k = dao.getKorting(1);
			System.out.println(k.getPrijs());

	}
}
