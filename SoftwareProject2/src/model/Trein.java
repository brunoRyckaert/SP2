package model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;

public class Trein extends Voertuig {
	private String fullId;
	private String departureStation;
	private String terminusStation;
	private ArrayList<Stop> stops = new ArrayList<Stop>();

	public Trein(JsonNode node) {
		fullId = node.get("FullId").asText();
		departureStation = node.get("DepartureStation").asText();
		terminusStation = node.get("TerminusStation").asText();
		for (JsonNode stop : node.get("Stops").get("Stations")) {
			stops.add(new Stop(stop));
		}
	}
	
	public String toString() {
		String string = fullId + " van " + departureStation + " naar " + terminusStation;
		for (Stop stop : stops)
			string += "\n" + stop;
		return string;
	}
}
