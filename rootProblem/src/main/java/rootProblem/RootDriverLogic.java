package rootProblem;

import rootProblem.Models.RootDriver;
import rootProblem.Models.RootTrip;

public class RootDriverLogic {
	
	// Equation for determining average: miles * (60/time)
	public void calculateTrips(RootDriver driver) {
		
		float totalMiles = 0;
		float totalTime = 0;
		
		for(RootTrip trip : driver.getTrips()) {
			
			totalMiles += trip.getDistance();
			totalTime += trip.getTotalTime();

		}
		
		driver.setMilesDriven(totalMiles);
		driver.setAvgSpeed(totalMiles * (60/totalTime));
		
		
		
	}

}
