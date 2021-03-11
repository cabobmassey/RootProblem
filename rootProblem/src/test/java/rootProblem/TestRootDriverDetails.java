package rootProblem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import rootProblem.Models.RootDriver;
import rootProblem.Models.RootTrip;

class TestRootDriverDetails {
	
	RootDriver driver = new RootDriver();
	RootTrip trip = new RootTrip();
	RootDriverLogic driverLogic = new RootDriverLogic();
	

	@Test
	void testCalculateTrips() {
		
		System.out.println("Testing calculateTrips");
		
		trip.setDistance(15);
		trip.setTotalTime(45);
		
		driver.addTrips(trip);
		
		driverLogic.calculateTrips(driver);
		
		assertEquals(15, driver.getMilesDriven());
		assertEquals(20, driver.getAvgSpeed());
		
	}

}
