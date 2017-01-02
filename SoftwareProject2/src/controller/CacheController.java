package controller;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Abonnement;
import model.Definitions;
import model.Ticket;

public class CacheController {
	private static Thread thread;
	private static CacheThread cacheThread;
	public static void push() {
		System.out.println("Pushing...");
		ArrayList<Serializable> objecten = deserialize(Definitions.getCacheFile());
		for (Serializable object : objecten) {
			// Switch werkt hier niet omdat cases een constante expressie verwachten.
			String klasseNaam = object.getClass().getName();
			if (klasseNaam.equals(Ticket.class.getName())) {
				System.out.println("Ticket wegschrijven");
				TicketDAO tdao = new TicketDAO();
				/*try {
					//tdao.setTicket((Ticket) object);
					//objecten.remove(object);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} */
			}
			else {
				System.out.println("Error: u kunt deze klasse (" + klasseNaam + ") niet wegschrijven naar de database.");
			}
		}
		//CacheController.serialize(objecten);
	}
	private CacheController() {
		
	}
	public static void init() {
		cacheThread = new CacheThread(5);
		thread = new Thread(cacheThread);
		thread.start();
	}
	
	public static void stop() {
		thread.interrupt();
		cacheThread.disable();
	}
	
	static {
		System.out.println("Caching ingeschakeld.");
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
		t.setKlasse(2);
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
			ArrayList<Serializable> objecten = CacheController.deserialize(destination);
			FileOutputStream fileOut = new FileOutputStream(destination);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			if (objecten == null) { 
				objecten = new ArrayList<Serializable>();
				System.out.println("Geen objecten gevonden; nieuwe lijst gemaakt");
			}
			else {
				System.out.println("Objecten reeds in cache: " + objecten.size());
			}
			System.out.println(source.getClass());
			objecten.add(source);
	        
			out.writeObject(objecten);
	        out.close();
	        fileOut.close();
		} catch (IOException e) {
			geslaagd = false;
			e.printStackTrace();
		}
		return geslaagd;
	}
}
