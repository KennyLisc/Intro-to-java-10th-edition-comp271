// Used to show binary I/O - Write
import java.util.*;
import java.io.*;

public class TestObjectOutputStream 
{
	public static void main(String[] args) throws IOException
	{
		
		FileOutputStream efile = new FileOutputStream("object.txt");

		
		ObjectOutputStream  outdata = new ObjectOutputStream( efile );
		Date now = new Date();
		
		// Use writeUTF or writeDouble
		outdata.writeObject( now );
		outdata.writeUTF("Howie ");
		outdata.writeDouble( 85.5 );
		

		outdata.close(); // close the file		
	}

}