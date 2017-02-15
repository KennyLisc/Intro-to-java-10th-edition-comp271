// Used to show binary I/O - Read
import java.util.*;
import java.io.*;

public class TestObjectInputStream 
{
	public static void main(String[] args) 
		throws IOException, ClassNotFoundException
	{
		
		FileInputStream efile = new FileInputStream("object.txt");

		
		ObjectInputStream  indata = new ObjectInputStream( efile );
		Date today ;
		
		// Use readUTF or readDouble
		today = (Date) indata.readObject(  );
		String name = indata.readUTF();
		double score = indata.readDouble(  );

		System.out.println(name + " " + score + " " + today.toString() );
		

		indata.close(); // close the file		
	}

}