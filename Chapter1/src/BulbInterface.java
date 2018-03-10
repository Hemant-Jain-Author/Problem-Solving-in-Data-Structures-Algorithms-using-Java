public interface BulbInterface {
	public void turnOn();

	public void turnOff();

	public boolean isOnFun();
}

// implements BulbInterface
class Bulb {
	// This is an example of single line comment

	/*
	 * This is also an example of multiple line comment.
	 */

	// Enums
	enum BulbSize {
		SMALL, MEDIUM, LARGE
	}

	BulbSize size;

	// Class Variables
	private static int TotalBulbCount = 0;

	// Instance Variables
	private boolean isOn = false;

	// Constructor
	public Bulb() {
		TotalBulbCount++;
	}

	// Class Method
	public static int getBulbCount() {
		return TotalBulbCount;
	}

	// Instance Method
	public void turnOn() {
		isOn = true;
	}

	// Instance Method
	public void turnOff() {
		isOn = false;
	}

	// Instance Method
	public boolean isOnFun() {
		return isOn;
	}
}

class AdvanceBulb extends Bulb {
	// Instance Variables
	int intensity;

	// Instance Method
	public void setIntersity(int i) {
		intensity = i;
	}
}