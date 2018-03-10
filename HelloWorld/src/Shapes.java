public class Shapes {
	enum ShapeSize {
		SMALL, MEDIUM, LARGE
	};

	ShapeSize size;

	public Shapes() {
		size = Shapes.ShapeSize.MEDIUM;
	}
}
