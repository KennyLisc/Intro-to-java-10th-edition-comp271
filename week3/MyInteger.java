
public class MyInteger {
 private int value;
 
	public MyInteger(int value) {
	this.value = value;
}
	

	public int getValue() {
		return value;
	}
	
	public static boolean isEven(int num) {
		if ((num %2) == 0)
			return true;
		else
			return false;		
	}
	 
	public static boolean isOdd(int num) {
		return (!MyInteger.isEven(num));
	}
	
	public boolean isEven() {
		return MyInteger.isEven(this.value);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
