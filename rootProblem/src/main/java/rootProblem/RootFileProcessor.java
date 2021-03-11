package rootProblem;

import java.util.HashMap;

import rootProblem.Models.RootDriver;

public class RootFileProcessor {
	
	public static void processFile(String filePath) {
		
		RootDriverLogic driverLogic = new RootDriverLogic();
		
		HashMap<String, RootDriver> drivers = RootFileReader.readFile(filePath);
		
		for(RootDriver driver : drivers.values()) {
			
			driverLogic.calculateTrips(driver);
			
		}
		
		RootFileWriter.WriteFile(drivers);
		
	}

}
