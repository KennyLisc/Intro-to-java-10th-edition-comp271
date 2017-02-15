// Lab3 Page 529 #13.1
// Gustavo Assis Cardoso
// 10/17/2016

public class Triangle extends GeometricObject {
	public double side1,side2,side3;
  
  public Triangle (double side1, double side2, double side3) {
    this.side1=side1; 
    this.side2=side2; 
    this.side3=side3;
  }
  
  @Override
  public double getArea( ) { 
	  return Math.sqrt((getPerimeter()/2)*((getPerimeter()/2)-this.side1)*((getPerimeter()/2)-this.side2)*((getPerimeter()/2)-this.side3));
  }
  
  @Override
  public double getPerimeter( ) { 
    return side1+side2+side3;
    }
  
  public String toString( ) { 
    return super.toString()+"\nArea: " + getArea() + "\nPerimeter: "+getPerimeter();
    }


  public static void main (String [ ] args)  
  {
  Triangle Triangle = new Triangle(1,1.5,1);
  Triangle.setColor("white");
  Triangle.isFilled();
  System.out.println(Triangle);
  
  }
}