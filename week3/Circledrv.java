
public class Circledrv  {
	
	public static void main(String[] args) {
		Circle mycircle = new Circle(5);
		
		// show your stuff
		System.out.println( mycircle );

	// Now a Cylinder
		Cylinder mycyl = new Cylinder(5, 10);
		System.out.println( mycyl );
	}
} // end of circledrv

 class Circle  {
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
				+ " and area is " + findArea() + super.toString()); // parents toString method
	}
	
} // end of circle

class Cylinder extends Circle {

	private double height;	
	
	public Cylinder(double radius, double height) {
		super(radius);
		this.height = height;		
	}

	public double findArea() {
		return super.findArea() * 2 +
			2 * radius * Math.PI * height;
	}

	@Override
	public String toString() {
		return "Cylinder [height=" + height + ", radius=" + radius
			+ ", findArea()=" + findArea() + "]";
	// +			super.toString();
	}	

} // end of cylinder
