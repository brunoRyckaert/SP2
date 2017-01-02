package controller;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import model.Abonnement;
import model.Definitions;
import model.Ticket;

public class CacheController {
	public static void push() {
		
	}
	private CacheController() {
		
	}
	
	public static void main(String[] args) {
		//new File("Caches").mkdir();
		File cacheRoot = Definitions.getCacheRoot();
		if (cacheRoot.exists()) {
			System.out.println("Cache root folder bevindt zich op: " + cacheRoot.getAbsolutePath());
		}
		else {
			cacheRoot.mkdir();
			System.out.println("Cache root folder aangemaakt op: " + cacheRoot.getAbsolutePath());
		}
		
		Ticket t = new Ticket();
		t.setBeginStation("Koksijde");
		t.setEindStation("Gent-Dampoort");
		t.setAantalReizigers(1);
		System.out.println(t.serialize());
		//System.out.println("Eerste deserialize in main: " +CacheController.deserialize(new File(cacheRoot + "\\ticket.ser")));
		Abonnement a = new Abonnement();
		a.setGeldig(true);
		a.setKlantId(5);
		System.out.println(a.serialize());
		//System.out.println("Tweede deserialize in main" + CacheController.deserialize(new File(cacheRoot + "\\ticket.ser")));
		System.out.println("-----\n");
		ArrayList<Serializable> ser = CacheController.deserialize(Definitions.getCacheFile());
		for (int i = 0; i < ser.size(); i++) {
			System.out.println(ser.get(i).getClass().getSimpleName());
		}
		
	}
	public static ArrayList<Serializable> deserialize(File source) {
		System.out.println("Absoluut pad: " + source.getAbsolutePath());
		ArrayList<Serializable> objecten = null;
		try {
			FileInputStream fileIn = new FileInputStream(source);
			ObjectInputStream in = new ObjectInputStream(fileIn) ;
			
			try {
				objecten = (ArrayList<Serializable>)in.readObject();
			} catch (EOFException e) {
				
			}
			
			in.close();
			fileIn.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return objecten;
	}
	
	public static boolean serialize(Serializable source) {
		return serialize(source, Definitions.getCacheFile());
	}
	
	public static boolean serialize(Serializable source, File destination) {
		boolean geslaagd = true;
		try {
			//System.out.println(destination.getAbsolutePath() + "\\ticket.ser");
			//System.out.println("Bestaat bestand? : " + destination.exists());
			ArrayList<Serializable> tickets = CacheController.deserialize(destination);
			FileOutputStream fileOut = new FileOutputStream(destination);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			if (tickets == null) { 
				tickets = new ArrayList<Serializable>();
				System.out.println("Geen objecten gevonden; nieuwe lijst gemaakt");
			}
			else {
				System.out.println("Objecten reeds in cache: " + tickets.size());
			}
			tickets.add(source);
	        out.writeObject(tickets);
	        out.close();
	        fileOut.close();
		} catch (IOException e) {
			geslaagd = false;
			e.printStackTrace();
		}
		return geslaagd;
	}
}
