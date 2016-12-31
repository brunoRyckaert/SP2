package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.fasterxml.jackson.databind.JsonNode;

public class Stop {
	private String naam;
	private int spoor;
	private LocalDateTime aankomst;
	private LocalDateTime werkelijkeAankomst;
	private LocalDateTime vertrek;
	private LocalDateTime werkelijkvertrek;
	
	
	public Stop(JsonNode node) {
		naam = node.get("Name").asText();
		spoor = (node.get("ArrivalPlatform") != null? node.get("ArrivalPlatform").asInt():node.get("DeparturePlatform").asInt());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss['+01:00']");
		//System.out.println(node.get("Time").get("Arrival").asText());
		aankomst = LocalDateTime.parse(node.get("Time").get("Arrival").asText(), formatter);
		werkelijkeAankomst = LocalDateTime.parse(node.get("Time").get("ActualArrival").asText(), formatter);
		vertrek = LocalDateTime.parse(node.get("Time").get("Departure").asText(), formatter);
		werkelijkvertrek = LocalDateTime.parse(node.get("Time").get("ActualDeparture").asText(), formatter);
		//aankomst = LocalDateTime.parse("2016-12-05T13:13:00+01:00",formatter);
	}
	
	public String toString() {
		return "Station: " + naam + " op spoor " + spoor + ". Aankomsttijd: " + aankomst + ". Vertrektrijd: " + vertrek;
	}
}
