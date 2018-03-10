public class Rectangle extends Shape {

	private double width, length;

	public Rectangle() {
		this(1, 1);
	}

	public Rectangle(double w, double l) {
		width = w;
		length = l;
	}

	public void setWidth(double w) {
		width = w;
	}

	public void setLength(double l) {
		length = l;
	}

	@Override
	public double area() {
		// Area = width * length
		return width * length;
	}

	@Override
	public double perimeter() {
		// Perimeter = 2(width + length)
		return 2 * (width + length);
	}
}