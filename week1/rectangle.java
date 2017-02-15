
public class rectangle {
	private double length;
	private double width;
	
	public rectangle() {
		length = width = 1.0;
	}

	public rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
	public double findArea() {
		return width * length;
	}

	@Override
	public String toString() {
		return "rectangle [length=" + length + ", width=" + width + ", findArea()=" + findArea() + "]";
	}

	public static void main(String[] args) {
		rectangle myrect = new rectangle(5,10);
		System.out.println(myrect);
	}

}
