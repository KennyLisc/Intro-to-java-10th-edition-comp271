//  Gustavo Assis Cardoso
// Lab3 Pg. 530 # 13.9

public class Circle extends GeometricObject implements Comparable<Circle>{
  private double radius;

  public Circle() {
  }

  public Circle(double radius) {
    this.radius = radius;
  }

  /** Return radius */
  public double getRadius() {
    return radius;
  }

  /** Set a new radius */
  public void setRadius(double radius) {
    this.radius = radius;
  }

  /** Return area */
  public double getArea() {
    return radius * radius * Math.PI;
  }

  /** Return diameter */
  public double getDiameter() {
    return 2 * radius;
  }

  /** Return perimeter */
  public double getPerimeter() {
    return 2 * radius * Math.PI;
  }

  /* Print the circle info */
  public void printCircle() {
    System.out.println("The circle is created " + getDateCreated() +
      " and the radius is " + radius);
  }

@Override
	public int compareTo(Circle o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean equals(Circle obj) {
		return this.getRadius() == obj.getRadius();
	}

	public static void main(String[] args) {
		Circle c1 = new Circle(2);
		Circle c2 = new Circle(3);
		System.out.println("Are equal? " +c1.equals(c2));
		
		c2.setRadius(2);
		System.out.println("Are equal? " +c1.equals(c2));
	}
}

