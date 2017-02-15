// Used to find some errors
public class Circle333 
{
	private double radius;
	public Circle333 (double radius)
	{
		radius = radius;
	}
	public double getRadius(){
		return radius;
	}
	public double getarea() {
		return radius * radius * Math.PI;
	}
}
class B1 extends Circle333 
{
	private double length;

	B1(double radius, double length)
	{
		Circle333(radius); 
		length = length;
	}
	public double getArea(){
		return getArea() * length;
	}
}
