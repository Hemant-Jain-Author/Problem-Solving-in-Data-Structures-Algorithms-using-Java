
public class Stack2 {

	private static final int MIN_CAPACITY = 1000;
	private int[] data;
	private int top = -1;
	private int minCapacity;
	private int maxCapacity;

	public Stack2() {
		this(MIN_CAPACITY);
		maxCapacity = minCapacity = MIN_CAPACITY;
	}

	public Stack2(int capacity) {
		data = new int[capacity];
		maxCapacity = minCapacity = capacity;
	}

	public int size() {
		return (top + 1);
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public void push(int value) throws IllegalStateException {
		if (size() == maxCapacity) {
			System.out.println("size dubbelled");
			int[] newData = new int[maxCapacity * 2];
			System.arraycopy(data, 0, newData, 0, maxCapacity);
			data = newData;
			maxCapacity = maxCapacity * 2;
		}
		top++;
		data[top] = value;
	}

	public int top() throws IllegalStateException {
		if (isEmpty()) {
			throw new IllegalStateException("StackEmptyException");
		}
		return data[top];
	}

	public int pop() {
		if (isEmpty()) {
			throw new IllegalStateException("StackEmptyException");
		}

		int topVal = data[top];
		top--;

		if (size() == maxCapacity / 2 && maxCapacity > minCapacity) {
			System.out.println("size halfed");
			maxCapacity = maxCapacity / 2;
			int[] newData = new int[maxCapacity];
			System.arraycopy(data, 0, newData, 0, maxCapacity);
			data = newData;
		}
		return topVal;
	}

	public void print() {
		for (int i = top; i > -1; i--) {
			System.out.print(" " + data[i]);
		}
	}

	public static void main(String[] args) {
		Stack2 s = new Stack2(10);
		for (int i = 1; i <= 100; i++) {
			s.push(i);
		}
		for (int i = 1; i <= 100; i++) {
			s.pop();
		}
		s.print();
	}
}