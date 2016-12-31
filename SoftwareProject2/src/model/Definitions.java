package model;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public abstract class Definitions {
static TreeSet<String> stations = new TreeSet<String>(); //kan je geen instantie van maken

public static TreeSet<String> getStations() {
	try {
		File bestand = new File("../SoftwareProject2/src/controller/stations.csv");
		Scanner inputStream = new Scanner(bestand);
		inputStream.next();//de kolomnamen
		while(inputStream.hasNext())
		{
			String data = inputStream.next();//zit een hele lijn in 
			String[] values = data.split(",");//string parsen
			stations.add(values[1]);
		}
		inputStream.close();
	} catch ( IOException e) {//catched io exception en file not found
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	return stations;
}

public void setStations(TreeSet<String> stations) {
	this.stations = stations;
}
}
