package rootProblem;

import rootProblem.Models.RootDriver;
import rootProblem.Models.RootTrip;

public class RootDriverLogic {

	// Equation for determining average: miles * (60/time)
	public void calculateTrips(RootDriver driver) {

		float totalMiles = 0f;
		float totalTime = 0f;

		if (!driver.getTrips().isEmpty()) {

			for (RootTrip trip : driver.getTrips()) {

				float tripSpeed = 0f;

				tripSpeed = trip.getDistance() * (60 / trip.getTotalTime());

				if (tripSpeed > 5 && tripSpeed < 100) {

					totalMiles += trip.getDistance();
					totalTime += trip.getTotalTime();

				} else {

					System.out.println("****Trip " + trip.toString() + " for " + driver.getName()
							+ " was not within the desired range****");

				}

			}
			
			if (totalMiles > 0 && totalTime > 0) {
				
				driver.setMilesDriven(Math.round(totalMiles));
				driver.setAvgSpeed(Math.round(totalMiles * (60 / totalTime)));
				
			} else {
				
				driver.setMilesDriven(0);
				driver.setAvgSpeed(0);
				
			}
			
		} else {
			
			driver.setMilesDriven(0);
			driver.setAvgSpeed(0);
			
		}

	}

}
