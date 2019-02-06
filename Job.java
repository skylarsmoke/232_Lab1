
public class Job {
	
	int num;
	int priority;
	int arrival;
	int runTime;
	int duration = 0;
	int waitTime = 0;
	
	public Job(int num, int priority, int arrival, int runTime) {
		this.num = num;
		this.priority = priority;
		this.arrival = arrival;
		this.runTime = runTime;
	}
	
	public int getNum(){
		return this.num;
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public int getArrival() {
		return this.arrival;
	}
	
	public int getRunTime() {
		return this.runTime;
	}
	
	public void runOneSec() {
		this.duration++;
	}
	
	public void waitOneSec() {
		this.waitTime++;
	}
}
