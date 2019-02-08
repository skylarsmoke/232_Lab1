
public class runJob {
	
	int seconds = 0;
	int arrival;
	int runTime;
	int endTime = 0;
	int startTime = 0;
	boolean end = false;
	
	public runJob(Job max) {
		this.arrival = max.getArrival();
		this.runTime = max.getRunTime();
				
	}
	
	
	public void addSec() {
		this.seconds++;
	}
	
	public int getElapsed() {
		return this.seconds;
	}
	
	public boolean arrived() {
		return this.arrival == this.seconds;
	}
	
	public void jobStart() {
		this.startTime = this.seconds;
		
	}
	
	public void jobEnd() {
		this.endTime = this.seconds;
		this.end = true;
	}
	
	int executionTime = endTime - startTime;
	
	public boolean finished() {
		if (this.end) {
			return true;
		}
		return false;
		
	}

	
	
	
}
