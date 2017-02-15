// Used to show text I/O - Write
import java.util.*;
import java.io.*;

public class Empio 
{
	public static void main(String[] args) throws IOException
	{
		File efile = new File("emp.txt");

		// create a PrintWriter and associate to File
		PrintWriter outdata = new PrintWriter( efile );

		// Use print, printf, println to write out some data
		outdata.print("Barry Smith ");
		outdata.println( 50000.00 );

		outdata.print("Lillian Smith ");
		outdata.println( 75000.00 );

		outdata.close(); // close the printwriter		
	}
}