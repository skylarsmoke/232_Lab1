import java.io.File;
import java.util.Arrays;
import java.util.Collections;
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
			readFile();
		}
		catch(Exception e)
		{
			System.out.println("Could not find file");
		}
	}
	
	public void readFile()
	{
		
		
		
		PQueue pq = new PQueue(Collections.reverseOrder());
		
		while(sc.hasNext())
		{
			int job = sc.nextInt();
			int priority = sc.nextInt();
			int arrival = sc.nextInt();
			int duration = sc.nextInt();
			
			Job job1 = new Job(job, priority, arrival, duration);
			
			pq.add(job1);
			
			
				System.out.println(pq.max().getArrival());
				pq.remove();
			
								
			System.out.print(job + ", " + priority + ", " + arrival + ", " + duration + "\n");
			
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
