public class Stack {
	private int capacity;
	private int[] data;
	private int top = -1;
	private int minCapacity; // for dynamic stack

	public Stack() {
		this(1000);
	}

	public Stack(int s) {
		data = new int[s];
		capacity = s;
		minCapacity = s; // for dynamic stack
	}
	/* Other methods */

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public void push(int value) throws IllegalStateException {
		if (top + 1 == capacity) {
			throw new IllegalStateException("StackOverflowException");
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
		for (int i = top; i >= 0; i--) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

	public static void main1() {
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.print();
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

	/*
	3 2 1 
	3
	2
	*/

	public void push2(int value) {
		if (top + 1 == capacity) {
			System.out.println("size doubled");
			int[] newData = new int[capacity * 2];
			System.arraycopy(data, 0, newData, 0, capacity);
			data = newData;
			capacity = capacity * 2;
		}
		top++;
		data[top] = value;
	}

	public int pop2() {
		if (isEmpty()) {
			throw new IllegalStateException("StackEmptyException");
		}

		int topVal = data[top];
		top--;

		if (top + 1 < (capacity / 2) && capacity > minCapacity) {
			System.out.println("size halved top ");
			capacity = capacity / 2;
			int[] newData = new int[capacity];
			System.arraycopy(data, 0, newData, 0, capacity);
			data = newData;
		}
		return topVal;
	}

	public static void main2() {
		Stack s = new Stack(5);
		for (int i = 0; i <= 11; i++) {
			s.push2(i);
		}
		for (int i = 0; i <= 11; i++) {
			System.out.print(s.pop2() + " ");
		}
	}

	/*
	size doubled
	size doubled
	11 10 size halved top 
	9 8 7 6 5 size halved top 
	4 3 2 1 0 
	*/
	public static void main(String[] args) {
		//main1();
		main2();
	}
}
