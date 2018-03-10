public class Stack {

	private static final int CAPACITY = 1000;
	private int[] data;
	private int top = -1;

	public Stack() {
		this(CAPACITY);
	}

	public Stack(int capacity) {
		data = new int[capacity];
	}

	public int size() {
		return (top + 1);
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public void push(int value) throws IllegalStateException {
		if (size() == data.length) {
			throw new IllegalStateException("StackOvarflowException");
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
		return topVal;
	}

	public void print() {
		for (int i = top; i > -1; i--) {
			System.out.print(" " + data[i]);
		}
	}

	public static void main(String[] args) {
		Stack s = new Stack(1000);
		for (int i = 1; i <= 100; i++) {
			s.push(i);
		}
		for (int i = 1; i <= 50; i++) {
			s.pop();
		}
		s.print();
	}
}