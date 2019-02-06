
/**
 * 
 * @author Skylar Smoker
 * 
 */

import java.io.File;
import java.util.Collections;
import java.util.Scanner;

public class JobSchedular {
	
	public static void main(String[] args) {
		
		PQueue pq = new PQueue(Collections.reverseOrder());
		
		try {
			
			Scanner input = new Scanner(System.in);
			
			String i = input.next();
			
			File file = new File(i);
			
			input = new Scanner(file);
			
			while (input.hasNextLine()) {
				int jobNum = input.nextInt();
				int priority = input.nextInt();
				int arrival = input.nextInt();
				int duration = input.nextInt();
				pq.add(priority);
				
				
			}
			input.close();
			
		} catch (Exception e){
			
			System.out.println("Error: file not found");
		
		}
		
		System.out.println(pq.max());		
		
	}	
	
}
