
public class Rectangle {
	
	private double width;
	 private double length;
	 
	 
	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}


	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}


	public double getLength() {
		return length;
	}


	public void setLength(double length) {
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
		Rectangle myrect = new Rectangle( 5, 10 );
		System.out.println( myrect );
 
	}

}
