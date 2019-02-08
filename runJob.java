
public class runJob {
	
	int seconds = 0;
	int arrival;
	int runTime;
	int endTime = 0;
	int startTime = 0;
	int executionTime = 0;
	boolean end = false;
	int waitTime = 0;
	
	public runJob(Job max) {
		this.arrival = max.getArrival();
		this.runTime = max.getRunTime();
				
	}
	
	public void changeArrival(Job max) {
		this.arrival = max.getArrival();
	}
	
	public void addSec() {
		this.seconds++;
	}
	
	public int getElapsed() {
		return this.seconds;
	}
	
	public int getArrival() {
		return this.arrival;
	}
	
	public void jobStart() {
		this.startTime = this.seconds;
		
	}
	
	public void jobEnd() {
		//this.endTime = this.seconds;
		this.end = true;
	}
	
	public void resetEndTime() {
		this.end = false;
	}
	
	public int getExecutionTime(int startTime, int endTime) {
		this.executionTime = endTime - startTime;
		return this.executionTime;
	}
	
	public int getWaitTime(int startTime, int arrival) {
		this.waitTime = startTime - arrival; 
		return this.waitTime;
	}
	
	public boolean finished() {
		if (this.end) {
			return true;
		}
		return false;
		
	}

	
	
	
}
