package controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Route;

public class Api {
	public static ArrayList<Route> getRoutes(String beginStation, String eindStation) {
		return getRoutes(beginStation, eindStation, String.valueOf(System.currentTimeMillis()/1000L + 3600));
	}
	
	public static ArrayList<Route> getRoutes(String beginStation, String eindStation, String timeStamp) {
		ArrayList<Route> routes = new ArrayList<>();
		try {
			URL url = new URL("https://traintracks.online/api/Route/"+ beginStation + "/" + eindStation + "/" + timeStamp);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readValue(url, JsonNode.class);
			for (JsonNode route : rootNode.get("Routes")) {
				if (route.get("Trains").size() != 0) routes.add(new Route(route));
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return routes;
	}
	
	public static void main(String[] args) {
		ArrayList<Route> routes = Api.getRoutes("Koksijde", "Mechelen");
		int i = 1;
		for (Route route : routes) {
			System.out.println("Route " + i + ":\n------\n");
			System.out.println(route);
			i++;
		}
	}
}
