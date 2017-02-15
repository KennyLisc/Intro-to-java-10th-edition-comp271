// Lab 4 - File I/O - page 490 #12.15
// Gustavo Assis Cardoso

import java.util.*;
import java.io.*;

public class file {

	public static void main(String[] args) throws IOException {
		int x;
		File efile = new File("Exercise12_15.txt");	
		// Check if file does not exist
		if(efile.exists()) {
			System.out.println("File already exists");
			System.exit(1);
		}
		
		// create a file
		try (PrintWriter output = new PrintWriter (efile);) {
			
			// write 100 integers created randomly into the file using text I/O. Int separated by space
			for(int i=0; i<100; i++)
			{
				x = (int)(Math.random() * 100);
				output.write(x + " ");
			}
			output.close();
		}
		catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

		// read the data from the file and display it in increasing order
		ArrayList<Integer> list = new ArrayList<>();
		try {
			Scanner input = new Scanner(efile);
			while (input.hasNextInt()) {
                list.add(input.nextInt());
            }

        } 
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
        }
		// simple solution to sort *** see book page 438 - sort method
        Collections.sort(list);

        // Manual solution 
        //sort(list);
        //System.out.println(list);
	}
/*
	public static void sort(ArrayList<Integer> list) {
	
	    for (int i = 0; i < list.size(); i++) {
	        int currentMin = list.get(i);
	        int currentIndex = i;
	        for (int j = i + 1; j < list.size(); j++) {
	            if (list.get(j) < currentMin) {
	                currentIndex = j;
	                currentMin = list.get(j);
	            }
	        }
	
	        if (currentIndex != i) {
	            list.set(currentIndex, list.get(i));
	            list.set(i, currentMin);
	        }
	    }
	}*/
}