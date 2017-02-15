// Lab1 
// Gustavo Assis Cardoso
// 10/10/2016
public class Triangle extends GeometricObject {
	private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;


	public Triangle() {
	}
	
	public Triangle (double side1, double side2, double side3) {
		this.side1=side1; 
		this.side2=side2; 
		this.side3=side3;
	}
	
	public double getSide1( )  {
		return side1;
		}
	
	public double setSide2( )  {
		return side2;
		}
	
	public double setSide3( )  {
		return side3;
		}
	
	public void setSide1 (double side1)  {
		this.side1=side1;
		}
	
	public void setSide2 (double side2)  {
		this.side2=side2;
		}
	
	public double getArea( ) { 
		return (side1+side2+side3)/2;
	}
	
	public double getPerimeter( ) { 
		return side1+side2+side3;
		}
	
	public String toString( ) { 
		return "Side 1 = " + side1 + " Side 2 = " + side2 + " Side 3 = " + side3;  
		}


	public static void main (String [ ] args)  
	{
	Triangle Triangle = new Triangle(1,1.5,1);
	System.out.println("The Triangle Sides are "  + Triangle.toString());  
	System.out.println("The Triangle’s Area is "  + Triangle.getArea());
	System.out.println("The Triangle’s Perimeter is " +  Triangle.getPerimeter());
	System.out.println("The Triangle's Color is " + Triangle.getColor());
	System.out.println("The Triangle is " + Triangle.isFilled());
	}
}

