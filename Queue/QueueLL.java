public class QueueLL {

	private static class Node {
		private int value;
		private Node next;

		public Node(int v, Node n) {
			value = v;
			next = n;
		}
	}

	private Node head = null;
	private Node tail = null;
	private int size = 0;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int peek() throws IllegalStateException {
		if (isEmpty())
			throw new IllegalStateException("StackEmptyException");
		return head.value;
	}

	public void push(int value) {
		Node temp = new Node(value, null);

		if (head == null)
			head = tail = temp;
		else {
			tail.next = temp;
			tail = temp;
		}
		size++;
	}

	public int pop() throws IllegalStateException {
		if (isEmpty())
			throw new IllegalStateException("StackEmptyException");
		int value = head.value;
		head = head.next;
		size--;
		return value;
	}

	public void print() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		QueueLL q = new QueueLL();
		for (int i = 1; i <= 100; i++) {
			q.push(i);
		}
		for (int i = 1; i <= 50; i++) {
			q.pop();
		}
		q.print();
	}
}