
public class runJob {
	
	int seconds = 0;
	int execution = 0;
	int arrival;
	int runTime;
	
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
	
	public boolean finished() {
		if (this.runTime == this.seconds) {
			return true;
		}
		return false;
		
	}

	
	
	
}
