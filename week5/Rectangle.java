
public class Rectangle extends GeometricObject{
private int width;
private int length;


	public Rectangle(int width, int length) {
	 this.setWidth(width);
	this.setLength ( length );
}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		if (width < 0)
			width = 1;
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		if (length < 0)
			length = 1;
		this.length = length;
	}

	public double getArea() {
		return width * length;
	}
	
	public double getPerimeter() {
		return width * 2 + length * 2;
	}


	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", length=" + length
				+ ", getArea()=" + getArea() + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle myrect = new Rectangle(5, 10);
		
		System.out.println(myrect); // invokes toString
	}

}
