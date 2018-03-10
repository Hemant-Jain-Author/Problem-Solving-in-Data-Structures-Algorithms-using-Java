public class Circle extends Shape {
	private double radius;

	public Circle() {
		this(1);
	}

	public Circle(double r) {
		radius = r;
	}

	public void setRadius(double r) {
		radius = r;
	}

	public double area() {
		return Math.PI * Math.pow(radius, 2);
	}

	public double perimeter() {
		return 2 * Math.PI * radius;
	}
}