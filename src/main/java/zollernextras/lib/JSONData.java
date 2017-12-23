package zollernextras.lib;

import java.io.File;
import com.google.gson.JsonObject;

public class JSONData {
	
	public static void init() {
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("Name", "ZollernWolf");
		File jsonFile = new File("player.json");
		
	}
	
}