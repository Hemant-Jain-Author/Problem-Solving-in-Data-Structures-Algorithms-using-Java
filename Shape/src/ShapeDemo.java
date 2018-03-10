public class ShapeDemo {
	public static void main(String[] args) {

		double width = 2, length = 3;
		Shape rectangle = new Rectangle(width, length);
		System.out.println("Rectangle width: " + width + " and length: " + length + " Area: " + rectangle.area()
				+ " Perimeter: " + rectangle.perimeter());

		double radius = 10;
		Shape circle = new Circle(radius);
		System.out
				.println("Circle radius: " + radius + " Area: " + circle.area() + " Perimeter: " + circle.perimeter());

	}
}