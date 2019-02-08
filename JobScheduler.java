import java.io.File;
import java.util.Scanner;

public class JobScheduler {
	Scanner sc;
	
	public JobScheduler(String in) {
		
		File inf = new File(in);
		openFile(inf);
	}
	
	public void openFile(File in)
	{
		try
		{
			sc = new Scanner(in);
			
		}
		catch(Exception e)
		{
			System.out.println("Could not find file");
		}
		readFile();
	}
	
	public void readFile()
	{
		
		
		PQueue pq = new PQueue();
				
		while(sc.hasNext())
		{
			int job = sc.nextInt();
			int priority = sc.nextInt();
			int arrival = sc.nextInt();
			int duration = sc.nextInt();
			
			pq.add(new Job(job, priority, arrival, duration));
			
			
		}
		
		runJob runJob = new runJob(pq.max());
		
		while (!pq.isEmpty()) {
			
			if (runJob.arrived()) {
				System.out.println("Arrived");
			}
			
			runJob.addSec();
			if (runJob.finished()) {
				System.out.println("Job#: " + pq.max().getNum() + ", Priority: " + pq.max().getPriority() + ", Arrival: " + pq.max().getArrival() + ", Seconds Elapsed: " + runJob.getElapsed());
				pq.remove();
				runJob.seconds = 0;
			}
			
			System.out.println(runJob.getElapsed());
					
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
