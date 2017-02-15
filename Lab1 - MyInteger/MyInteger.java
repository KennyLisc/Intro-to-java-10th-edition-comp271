// Lab1 
// Gustavo Assis Cardoso
// 10/3/2016
package proj;
public class MyInteger {
 private int value;
 
 	// A constructor that creates a MyInteger object for the specified int value
	public MyInteger(int value) {
	this.value = value;
}
	// A getter method that returns the int value
	public int getValue() {
		return value;
	}
	
	// Determine an even number and return true if num is even
	public static boolean isEven(int num) {
		if ((num %2) == 0)
			return true;
		else
			return false;		
	}
	
	// Determine an odd number and return true if num is odd
	public static boolean isOdd(int num) {
		return (!MyInteger.isEven(num));
	}
	
	// Determine a prime number and return true if num is prime
	public static boolean isPrime(int num) {
		if (num ==2)
			return true;
		for(int i=2; i<num/2; i++){
			if(num%i==0)
				return false;
		}
		return true;
	}
	
	// The static method isEven(MyInteger) that return true if the specified value is even
	public boolean isEven() {
		return MyInteger.isEven(this.value);
	}
	
	// The static method isOdd(MyInteger) that return true if the specified value is odd
	public boolean isOdd() {
		return MyInteger.isOdd(this.value);
	}

	// The static method isPrime(MyInteger) that return true if the specified value is prime
	public boolean isPrime() {
		return MyInteger.isPrime(this.value);
	}
	
	// The methods equals(int) that return true if the value in this object is equal to the specified value
	public boolean equals(int num) {
		return this.value == num;
	}
	
	// The method equals(MyInteger) that return true if the value in this object is equal to the specified value
	public boolean equals (MyInteger my) {
		return my.value == this.value;		
	}
	
	public static void main(String[] args) {
        MyInteger n1 = new MyInteger(5);
        System.out.println("n1 is even? " + n1.isEven());
        System.out.println("n1 is odd? " + n1.isOdd());
        System.out.println("n1 is prime? " + n1.isPrime());
        
        System.out.println("15 is even? " + MyInteger.isEven(15));
        System.out.println("15 is odd? " + MyInteger.isOdd(15));
        System.out.println("15 is prime? " + MyInteger.isPrime(15));


        MyInteger n2 = new MyInteger(24);
        System.out.println("\nn2 is even? " + n2.isEven());
        System.out.println("n2 is odd? " + n2.isOdd());
        System.out.println("n2 is prime? " + n2.isPrime());      
        
        System.out.println("Is n1 equal to n2? " + n1.equals(n2));
        System.out.println("Is n1 equal to 5? " + n1.equals(5));

    }
}

/* OUTPUT:
n1 is even? false
n1 is odd? true
n1 is prime? true
15 is even? false
15 is odd? true
15 is prime? false

n2 is even? true
n2 is odd? false
n2 is prime? false
Is n1 equal to n2? false
Is n1 equal to 5? true 
 */