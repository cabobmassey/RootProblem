package rootProblem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import rootProblem.Models.RootDriver;
import rootProblem.Models.RootTrip;


public class RootFileReader {
	
	public static HashMap<String, RootDriver> readFile(String filePath) {
		
	    String fileLine = null;
	    int linesInFile = 0;
	    
	    // Hold each bit of data we want in a list
    	float timeDifference;
    	float distance;
    	
    	//Make an array to hold all of the drivers
    	//RootDriver[] drivers = new RootDriver[0];
    	HashMap<String, RootDriver> drivers = new HashMap<String, RootDriver>();

	    // We use try with resources to close the buffered reader
	    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	    	
	    	// As long as there are lines in the file, keep going line by line
	        while ((fileLine = br.readLine()) != null) {
	        	
	        	linesInFile++;
	        	
	        	// Create a date format to read the times
	        	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

	        	// Take each line and send it as a string object to the FileProcessor to be split
	        	// delimited by a space
	        	String[] lineArray = fileLine.split(" ");
	        	
	        	//If the first word in the line is Driver...
	        	if (lineArray[0].equals("Driver")) {
	        		
	        		//Create a new driver with the name in line
	        		RootDriver newDriver = new RootDriver(lineArray[1]);
	        		
	        		//Add the new driver to our list of current drivers
	        		drivers.put(lineArray[1], newDriver);

	        		
	        	//If the first word in the line is Trip...
	        	} else if (lineArray[0].equals("Trip")) {
	        			
	        		// Find difference between the two time stamps
	        		Date time1 = sdf.parse(lineArray[2]);
	        		Date time2 = sdf.parse(lineArray[3]);
	        		
	        		timeDifference = ((time2.getTime() - time1.getTime()) / 60000);

	        		// Add total distance
	        		distance = Float.parseFloat(lineArray[4]);
	        		
	        		//Create new Trip
	        		RootTrip newTrip = new RootTrip(timeDifference, distance);
	        		
	        		//Add the trip to the corresponding driver object
	        		if (drivers.containsKey(lineArray[1])) {
	        			
	        			drivers.get(lineArray[1]).addTrips(newTrip);
	        		
	        		} else {
	        			
	        			System.out.println("***NO DRIVER FOR TRIP DATA AT LINE " + linesInFile + "***");
	        			
	        		}
	        		
	        	} else {
	        		
	        		System.out.println("***INCORRECT DATA AT LINE " + linesInFile + "***");
	        		
	        	}
	            
	        }
	        
	    } catch (FileNotFoundException fnf) {
	    	
	        System.out.println("***ERROR:" + filePath + " does not exist***");
	        
	    } catch (IOException ioe) {
	    	
	        ioe.printStackTrace();
	        
	    } catch (ParseException pe) {
	    	
	    	pe.printStackTrace();
	    	
	    } 
	    
	    return drivers;
	    
	}
	
	// Possibly add a pop up if there is no file
	
	/*public static void errorPopUp(String text) {
		
        final JFrame parent = new JFrame();

        JOptionPane.showMessageDialog(parent, text);

    }*/

}
