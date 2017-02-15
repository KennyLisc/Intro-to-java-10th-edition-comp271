// Used to show  I/O - Write
import java.util.*;
import java.io.*;


public class Empio 
{
	public static void main(String[] args) throws IOException
	{
		//try {			
		
		File efile = new File("emp.txt");
		// create a PrintWriter and associate to File
		// Use print, printf, println to write out some data
		PrintWriter fileout = new PrintWriter( efile );
		fileout.print("Barry Smith ");
		fileout.println(51000);
		
		fileout.print("Lillian Smith ");
		fileout.println(62000);

		fileout.close();	
		//}
		//catch (IOException exp) {
		//	System.out.println("Error writing file");
		//}
	}
}