package rootProblem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import rootProblem.Models.RootDriver;
import rootProblem.Models.RootTrip;

class TestRootDriverLogic {

	@Test
	//should should calculate average speed and total distance after trip is added
	void testCalculateTrips() {
		
		RootDriver driver = new RootDriver();
		RootTrip trip = new RootTrip();
		RootDriverLogic driverLogic = new RootDriverLogic();
		
		trip.setDistance(15);
		trip.setTotalTime(45);
		
		driver.addTrips(trip);
		
		driverLogic.calculateTrips(driver);
		
		assertEquals(15, driver.getMilesDriven());
		assertEquals(20, driver.getAvgSpeed());
		
	}
	
	@Test
	//Should create new driver object
	public void testCreateDriver() {
		
		RootDriver driver = new RootDriver("Dan");
		
		assertEquals(0, driver.getMilesDriven());
		assertEquals(0, driver.getAvgSpeed());
		assertEquals(true, driver.getTrips().isEmpty());
		
	}
	
	@Test
	//should add all trips and names except for trips under 5mph or over 100mph
	public void testAddValues() {
		
		HashMap<String, RootDriver> drivers = new HashMap<String, RootDriver>();
		
		RootDriver dan = new RootDriver();
		RootDriver lauren = new RootDriver();
		RootDriver kumi = new RootDriver();
		
		RootTrip trip1 = new RootTrip();
		RootTrip trip2 = new RootTrip();
		RootTrip trip3 = new RootTrip();
		
		RootDriverLogic driverLogic = new RootDriverLogic();
		
		//add drivers to map
		drivers.put("Dan", dan);
		drivers.put("Lauren", lauren);
		drivers.put("Kumi", kumi);
		
		//expect 89mph
		trip1.setDistance(74);
		trip1.setTotalTime(50);
		
		//expect 120mph
		trip2.setDistance(100);
		trip2.setTotalTime(50);
		
		//expect 3mph
		trip3.setDistance(3);
		trip3.setTotalTime(60);
		
		dan.addTrips(trip1);
		lauren.addTrips(trip2);
		kumi.addTrips(trip3);
		
		driverLogic.calculateTrips(dan);
		driverLogic.calculateTrips(lauren);
		driverLogic.calculateTrips(kumi);
		
		assertEquals(74, dan.getMilesDriven());
		assertEquals(89, dan.getAvgSpeed());
		assertEquals(false, dan.getTrips().isEmpty());
		
		assertEquals(0, lauren.getMilesDriven());
		assertEquals(0, lauren.getAvgSpeed());
		assertEquals(false, lauren.getTrips().isEmpty());
		
		assertEquals(0, kumi.getMilesDriven());
		assertEquals(0, kumi.getAvgSpeed());
		assertEquals(false, kumi.getTrips().isEmpty());
		
	}

}
