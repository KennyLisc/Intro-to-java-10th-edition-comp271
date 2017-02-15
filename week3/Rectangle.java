
public class Rectangle {
	
	private double width;
	 private double length;
	 
	 
	public Rectangle(double width, double length) {
		//this.width = width;
		this.setWidth(width);
		//this.length = length;
		this.setLength(length);
	}


	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		if (width <= 0)
			width = 1;
		this.width = width;
	}


	public double getLength() {
		return length;
	}


	public void setLength(double length) {
		if (length <= 0)
			length = 1;
		this.length = length;
	}

public double findArea() {
	return width * length;
	}

	@Override
public String toString() {
	return "Rectangle [width=" + width + ", length=" + length + ", findArea()="
			+ findArea() + "]";
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle myrect = new Rectangle( -5, 10 );
		System.out.println( myrect );
 
	}

}
