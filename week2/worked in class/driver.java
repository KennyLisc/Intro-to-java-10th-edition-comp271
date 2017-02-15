
public class driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		myDate today = new myDate(9, 19, 2016);
		System.out.println("today is "+ today.toString());
		//today.month = 31;
		today.setDay(20);
		System.out.println("tomorrow is "+ today);
		
	}
}