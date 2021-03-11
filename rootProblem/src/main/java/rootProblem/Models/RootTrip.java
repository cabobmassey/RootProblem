package rootProblem.Models;

public class RootTrip {
	
	float totalTime;
	float distance;
	
	public RootTrip() {
		
	}
	
	public RootTrip(float totalTime, float distance) {
		super();
		this.totalTime = totalTime;
		this.distance = distance;
	}

	public float getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "RootTrip [totalTime=" + totalTime + " minutes , distance=" + distance + " miles]";
	}
	
}
