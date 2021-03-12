package rootProblem.Models;

import java.util.ArrayList;

public class RootDriver implements Comparable<RootDriver>{
	
	String name;
	float milesDriven;
	float avgSpeed;
	
	ArrayList<RootTrip> trips = new ArrayList<RootTrip>();
	
	public RootDriver() {
		
	}
	
	public RootDriver(String name) {
		super();
		this.name = name;
	}

	@Override
	public int compareTo(RootDriver rootDriver) {
		// compare by miles driven
		return (int)(this.milesDriven - rootDriver.milesDriven);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<RootTrip> getTrips() {
		return trips;
	}

	public void addTrips(RootTrip trips) {
		this.trips.add(trips);
	}

	public float getMilesDriven() {
		return milesDriven;
	}

	public void setMilesDriven(float milesDriven) {
		this.milesDriven = milesDriven;
	}

	public float getAvgSpeed() {
		return avgSpeed;
	}

	public void setAvgSpeed(float avgSpeed) {
		this.avgSpeed = avgSpeed;
	}

	@Override
	public String toString() {
		return "RootDriver [name=" + name + ", milesDriven=" + milesDriven + ", avgSpeed=" + avgSpeed + ", trips="
				+ trips + "]";
	}

}
