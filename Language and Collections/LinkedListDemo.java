import java.util.LinkedList;

public class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.addFirst(2); // 8 is added to the list
		ll.addLast(10); // 9 is added to last of the list.
		ll.addFirst(1); // 7 is added to first of the list.
		ll.addLast(11); // 20 is added to last of the list
		System.out.println("Contents of Linked List: " + ll);
		ll.removeFirst();
		ll.removeLast();
		System.out.println("Contents of Linked List: " + ll);
	}
}