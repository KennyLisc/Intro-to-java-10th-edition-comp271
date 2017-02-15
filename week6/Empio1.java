// Used to show text I/O - Read
import java.util.*;
import java.io.*;


public class Empio1 
{
	public static void main(String[] args) throws Exception
	{
		File efile = new File("emp.txt");
		// create a Scanner and associate to File
		// use Scanner methods to read in some data
		// the method hasNext indicates end of file
		Scanner indata = new Scanner(efile);
		double total = 0;
		while (indata.hasNext()) {
			String fname = indata.next();
			String lname = indata.next();
			double salary = indata.nextDouble();
			total += salary;
		}

		indata.close();	
		System.out.printf("Total salary is $%.2f" , total);
	}
}