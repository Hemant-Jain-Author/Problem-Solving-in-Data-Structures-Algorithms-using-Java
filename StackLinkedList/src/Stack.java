public class Stack {

	private static class Node {
		private int value;
		private Node next;

		public Node(int v, Node n) {
			value = v;
			next = n;
		}
	}

	private Node head = null;
	private int size = 0;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int peek() throws IllegalStateException {
		if (isEmpty()) {
			throw new IllegalStateException("StackEmptyException");
		}
		return head.value;
	}

	public void push(int value) {
		head = new Node(value, head);
		size++;
	}

	public int pop() throws IllegalStateException {
		if (isEmpty()) {
			throw new IllegalStateException("StackEmptyException");
		}
		int value = head.value;
		head = head.next;
		size--;
		return value;
	}

	public void insertAtBottom(int value) {
		if (isEmpty()) {
			push(value);
		} else {
			int temp = pop();
			insertAtBottom(value);
			push(temp);
		}
	}

	public void print() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		Stack s = new Stack();
		for (int i = 1; i <= 100; i++) {
			s.push(i);
		}
		for (int i = 1; i <= 50; i++) {
			s.pop();
		}
		s.print();
	}
}