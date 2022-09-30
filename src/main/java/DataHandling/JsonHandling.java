package DataHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonHandling {
	
	//Method to read Json File
	public static JSONArray JsonRead() throws IOException, ParseException{
		String Path = "testData.txt";
		JSONParser parser = new JSONParser();
		JSONArray arr = new JSONArray();
		try {
			FileReader reader = new FileReader(Path.trim());
			JSONObject obj = (JSONObject)parser.parse(reader);
			arr = (JSONArray)obj.get("player");	//Fetch the array
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return arr;
		
	}
	
	public static boolean validateInternationalPlayersCount(JSONArray arr) {
		int counter = 0;
		boolean status = true;
		
		//Read the JsonObject and fetch the values
		for(int i=0;i<arr.size();i++) {
			JSONObject obj1 = (JSONObject) arr.get(i);
			String s1 = obj1.get("country").toString();
			if(!s1.equalsIgnoreCase("India")) {
				counter++;
			}
		}
		if(counter>4 || counter<4) {
			status =  false;
		}
		return status;
	}
	
	public static boolean validateAtLeastOneWicketKeeper(JSONArray arr) {
		boolean status = false;
		
		for(int i =0; i<arr.size(); i++) {
			JSONObject obj1 = (JSONObject) arr.get(i);
			String s1 = obj1.get("role").toString();
			if (s1.equalsIgnoreCase("Wicket-keeper")) {
				status = true;
				break;
			}else {
				continue;
			}
		}
		return status;
		
	}
	
	

}
