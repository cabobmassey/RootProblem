package rootProblem;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import rootProblem.Models.RootDriver;

public class RootFileProcessor {

	public static void processFile(String filePath) {

		RootDriverLogic driverLogic = new RootDriverLogic();

		HashMap<String, RootDriver> drivers = RootFileReader.readFile(filePath);

		for (RootDriver driver : drivers.values()) {

			driverLogic.calculateTrips(driver);

		}
		
		//sort the drivers by most miles driven
		sortMap(drivers);

		RootFileWriter.WriteFile(drivers);

	}

	public static HashMap<String, RootDriver> sortMap(HashMap<String, RootDriver> drivers) {

		// Create a list from elements of HashMap
		List<Map.Entry<String, RootDriver>> list = new LinkedList<Map.Entry<String, RootDriver>>(drivers.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, RootDriver>>() {
			public int compare(Map.Entry<String, RootDriver> o1, Map.Entry<String, RootDriver> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
		
		// put data from sorted list to hashmap  
        HashMap<String, RootDriver> sortedDrivers = new HashMap<String, RootDriver>(); 
        for (Map.Entry<String, RootDriver> entry : list) { 
        	
        	System.out.println(entry.getValue());
        	
            sortedDrivers.put(entry.getKey(), entry.getValue()); 
        }

		return sortedDrivers;

	}

}
