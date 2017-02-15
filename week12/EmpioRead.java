// Used to show text I/O - Read
import java.util.*;
import java.io.*;

public class EmpioRead 
{
	public static void main(String[] args)//throws IOException
	{
		File efile = new File("emp.txt");
		double total = 0;
		try
		{
			// create a Scanner and associate to File
			Scanner indata = new Scanner( efile );
			String fname, lname;
			double salary;
		
			while (indata.hasNext())
			{		
				fname = indata.next();
				lname = indata.next();
				salary = indata.nextDouble();
				total += salary;
			} // end of while

			indata.close(); // close the Scanner	
		}
		catch (IOException e)
		{
			System.out.println("File Error");	
		}
			
		System.out.println("The total salary is " + total);		
		
	}
}