
public class ArrayDemo {

	int[] numbers;

	public ArrayDemo() {
		numbers = new int[100];
	}

	public void addValue(int index, int data) {
		numbers[index] = data;
	}

	public int getValue(int index) {
		return numbers[index];
	}
}
