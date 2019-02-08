import java.io.File;
import java.util.Scanner;

public class JobScheduler {
	
	// initializes scanner
	Scanner sc;
	
	// initializes JobScheduler which takes in file name
	public JobScheduler(String in) {
		
		File inf = new File(in);
		openFile(inf);
	}
	
	// initializes openFile using the new File inf
	public void openFile(File in)
	{
		try
		{
			sc = new Scanner(in);
			
		}
		catch(Exception e)
		{ // tells user if file can not be found
			System.out.println("Could not find file");
		}
		readFile();
	}
	
	public void readFile()
	{
		
		
		PQueue pq = new PQueue();
		PQueueArrival pqA = new PQueueArrival();
				
		while(sc.hasNext())
		{
			int job = sc.nextInt();
			int priority = sc.nextInt();
			int arrival = sc.nextInt();
			int duration = sc.nextInt();
			
			pqA.add(new Job(job, priority, arrival, duration));
			
		}
		
		int seconds = 0;
		int startTime = 0;
		int endTime = 0;
			
		
		pq.add(pqA.max());
		pqA.remove();
		runJob runJob = new runJob(pq.max());
		
		
		
		while (seconds != 2000) {
			
			if (seconds == pqA.max().getArrival()) {
				pq.add(pqA.max());
				pqA.remove();
				System.out.println("yo");
			}
			
			if (runJob.end == true) {
				startTime = seconds;
				//runJob.jobStart();
				runJob.changeArrival(pq.max());
				runJob.end = false;
			}
			
			if (seconds == pq.max().getArrival()) {
				startTime = seconds;
				//runJob.jobStart();
			}
			
			
			
			if (seconds == startTime + pq.max().getRunTime()) {
				runJob.jobEnd();
				endTime = startTime + pq.max().getRunTime();
				
			}
			
			
			if (runJob.finished()) {
				System.out.println("Job#: " + pq.max().getNum() + ", Priority: " + pq.max().getPriority() + ", Arrival: " + pq.max().getArrival() + "sec" + ", Wait Time: " + runJob.getWaitTime(startTime, pq.max().getArrival()) + ", Execution Time: " + runJob.getExecutionTime(startTime, endTime) + "sec" + ", Seconds Elapsed: " + seconds + "sec");
				pq.remove();
				
				//runJob.resetEndTime();
				
			}
			
			seconds++;
			//runJob.addSec();
			System.out.println(seconds);
					
		}
		
		
		sc.close();
	}
	
	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		
		String i = input.next();
		
		JobScheduler js = new JobScheduler(i);
		
		
		input.close();
	}
}
