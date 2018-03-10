import java.util.LinkedList;

public class LinkedListDemo {

	public LinkedListDemo() {
	}

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();

		ll.addFirst(10);
		ll.addLast(20);
		ll.addFirst(9);
		ll.addLast(21);
		ll.addFirst(8);
		ll.addLast(22);

		System.out.println("Contents of Linked List: " + ll);

		ll.removeFirst();
		ll.removeLast();

		System.out.println("Contents of Linked List: " + ll);
	}

}
