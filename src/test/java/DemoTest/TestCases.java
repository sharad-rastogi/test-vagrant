package DemoTest;

import DataHandling.JsonHandling;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class TestCases extends JsonHandling {
	
	
	@Test
	public void checkNumInternationalPlayers() throws IOException, ParseException {
		JSONArray arr = JsonRead();
		boolean status = validateInternationalPlayersCount(arr);
		assertEquals(status, true, "Team do not have only 4 international players");
		
	}
	
	@Test
	public void checkOneWicketKeeper() throws IOException, ParseException {
		JSONArray arr = JsonRead();
		boolean status = validateAtLeastOneWicketKeeper(arr);
		assertEquals(status, true, "Wicket keeper do not exist");	
	}
	
}
