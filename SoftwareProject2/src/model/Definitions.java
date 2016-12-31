package model;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public abstract class Definitions {
static ArrayList<Station> stations = new ArrayList<>(); //kan je geen instantie van maken

static {
	stations = getStations(); // terug uncommenten
}

public static void main(String[] args) {
	System.out.println(getStationsNamen());
	/*String st = "http://irail.be/stations/NMBS/008883006,Braine-le-Comte,,'s Gravenbrakel,,,be,4.137662,50.605079,160.14161849711";
	String[] values = st.split(",");
	for (int i = 0; i < values.length; i++) {
		System.out.println("values["+i+"] = " + values[i]);
	}*/
	
}

public static TreeSet<String> getStationsNamen() {
	TreeSet<String> stationsNamen = new TreeSet<>();
	for (Station station : stations) {
		stationsNamen.add(station.getNaam().get(0));
	}
	
	return stationsNamen;
}

public static ArrayList<Station> getStations() {
	ArrayList<Station> stations = new ArrayList<>();
	try {
		File bestand = new File("../SoftwareProject2/src/controller/stations.csv");
		Scanner inputStream = new Scanner(bestand);
		inputStream.nextLine();//de kolomnamen
		while(inputStream.hasNext())
		{
			
			String data = inputStream.nextLine();//zit een hele lijn in 
			String[] values = data.split(",");//string parsen
			ArrayList<String> namen = new ArrayList<>();
			namen.add(values[1]);
			stations.add(new Station(namen,values[7],values[8]));
		}
		inputStream.close();
	} catch ( IOException e) {//catched io exception en file not found
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	return stations;
}

public void setStations(ArrayList<Station> stations) {
	this.stations = stations;
}
}
