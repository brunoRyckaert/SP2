package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.databind.*;

public class Route {
	private ArrayList<Trein> treinen = new ArrayList<Trein>();
	private ArrayList<Transfer> overstappen = new ArrayList<Transfer>();
	
	public Route(JsonNode node) {
		for (JsonNode trein : node.get("Trains")) {
			treinen.add(new Trein(trein));
		}
		for (JsonNode overstap : node.get("TransferStations")) {
			overstappen.add(new Transfer(overstap));
		}
	}
	
	public String toString() {
		String string = "";
		
		int i = 1;
		for (Transfer transfer : overstappen) {
			string += "Trein " + i + ": " + transfer + "\n";
			i++;
		}
		string += "\n\nDetails:\n";
		i = 1;
		for (Trein trein : treinen) {
			string += "\nTrein " + i + ":\n" + trein + "\n";
			i++;
		}
		
		return string;
	}
	
	
	
	public static void main(String[] args) {
		try {
			URL url = new URL("https://traintracks.online/api/Route/Mechelen/Koksijde");
			//InputStream is = url.openStream();
			//BufferedReader br = new BufferedReader(new FileReader("D:\\Bruno\\Documents\\EhB\\2016-2017\\Software_Project_2\\demoapiresult.txt"));
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readValue(url, JsonNode.class);
			//JsonNode rootNode = mapper.readValue(br, JsonNode.class);
			ArrayList<Trein> treinen = new ArrayList<Trein>();
			ArrayList<Transfer> overstappen = new ArrayList<>();
			for (int i = 0; i < rootNode.get("Routes").path(0).get("Trains").size(); i++) {
				treinen.add(new Trein(rootNode.get("Routes").path(0).get("Trains").path(i)));
			}
			int aantalTransfers = rootNode.get("Routes").path(0).get("TransferStations").size();
			if (aantalTransfers > 0) {
				for (int i = 0; i < aantalTransfers; i++) {
					overstappen.add(new Transfer(rootNode.get("Routes").path(0).get("TransferStations").get(i)));
				}
			}
			int i = 1;
			for (Transfer transfer : overstappen) {
				System.out.println("Trein " + i + ": " + transfer);
				i++;
			}
			System.out.println("\nDetails:\n");
			i = 1;
			for (Trein trein : treinen) {
				System.out.println("Trein " + i + ":\n" + trein);
				i++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
