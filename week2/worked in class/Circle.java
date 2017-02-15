
public class Circle {
	protected double radius;
	
	public Circle(){ 
		radius = 1.0; 
	}

	public Circle (double radius){
		this.radius = radius;
	}

	public double findArea(){
		return radius * radius * Math.PI;
	}

	public String toString(){
		return ("Circle's radius is " + radius
				+ " and area is " + findArea());
	}
	public static void main(String[] args) {
		Circle mycircle = new Circle(5);
		System.out.println( mycircle.toString() );
		// or
		System.out.println( mycircle );
	}
}