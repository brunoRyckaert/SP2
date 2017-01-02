package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.databind.JsonNode;

public class Transfer {
	private String fullId;
	private String terminus;
	private String transferAt;
	private String aankomstSpoor;
	private String vertrekSpoor;
	private LocalDateTime aankomstTijd;
	private LocalDateTime vertrekTijd;
	private LocalTime overstapTijd;
	public Transfer(String fullId, String terminus, String transferAt, String aankomstSpoor, String vertrekSpoor,
			LocalDateTime aankomstTijd, LocalDateTime vertrekTijd, LocalTime overstapTijd) {
		super();
		this.fullId = fullId;
		this.terminus = terminus;
		this.transferAt = transferAt;
		this.aankomstSpoor = aankomstSpoor;
		this.vertrekSpoor = vertrekSpoor;
		this.aankomstTijd = aankomstTijd;
		this.vertrekTijd = vertrekTijd;
		this.overstapTijd = overstapTijd;
	}
	public Transfer(JsonNode node) {
		terminus = node.get("TerminusStation").asText();
		fullId = node.get("FullId").asText();
		if (node.get("TransferAt").asText() != "null") transferAt = node.get("TransferAt").asText();
		aankomstSpoor = node.get("ArrivalPlatform").asText();
		vertrekSpoor = node.get("DeparturePlatform").asText();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss['+01:00']");
		if (transferAt != null) {
			aankomstTijd = LocalDateTime.parse(node.get("ArrivalTime").asText(),formatter);
			vertrekTijd = LocalDateTime.parse(node.get("DepartureTime").asText(),formatter);
			overstapTijd = LocalTime.parse(node.get("StepOverTime").asText(),DateTimeFormatter.ofPattern("HH:mm:ss"));
		}
		else {
			vertrekTijd = LocalDateTime.parse(node.get("ArrivalTime").asText(),formatter);
		}
	}
	
	public String toString() {
		String string = "";
		string += fullId + " richting " + terminus + ".";
		if (transferAt != null) string += " Overstap in " + transferAt + " (aankomst: " + aankomstTijd + " op spoor " + aankomstSpoor + ").";
		string += " Vertrek: " + vertrekTijd + " op spoor " + vertrekSpoor + ".";
		if (transferAt != null) string += " Tijd voor overstap: " + overstapTijd + ".";
		return string;
	}
}
