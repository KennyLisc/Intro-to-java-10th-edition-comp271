 // Lab 10 - Binary I/O - pg 701 # 17.3
 // Gustavo Assis Cardoso
import java.io.*;

public class Exercise17_03 {

	public static void main(String[] args) throws IOException {

		try (DataOutputStream output = new DataOutputStream(new FileOutputStream("Exercise17_03.dat"))) {
			for (int i = 0; i < 100; i++) {
				output.writeInt((int) (Math.random() * 100));
			}
		}
		
		int sum = 0;
		try {
			try (DataInputStream input = new DataInputStream(new FileInputStream("Exercise17_03.dat"))) {
				while (true) {
					sum += input.readInt();
				}
			}
		} catch (EOFException ex) {
			System.out.println("The sum is: " + sum);
		}

	}

}
