public class Calculator {
	private int value;

	public Calculator() {
		value = 0;
	}

	public Calculator(int arr) {
		value = arr;
	}

	public void reset() {
		value = 0;
	}

	public int getValue() {
		return value;
	}

	public void add(int data) {
		value = value + data;
	}

	public void increment() {
		value += 1;
	}

	public void subtract(int data) {
		value = value - data;
	}

	public void decrement() {
		value -= 1;
	}
}
