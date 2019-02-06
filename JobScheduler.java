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
			readFile();
		}
		catch(Exception e)
		{
			System.out.println("Could not find File");
		}
	}
	
	public void readFile()
	{
		while(sc.hasNext())
		{
			int job = sc.nextInt();
			int priority = sc.nextInt();
			int arrival = sc.nextInt();
			int duration = sc.nextInt();
			
			System.out.print(job + ", " + priority + ", " +arrival+ ", " + duration + "\n");
			
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
