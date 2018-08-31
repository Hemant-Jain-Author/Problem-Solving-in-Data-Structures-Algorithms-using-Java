public class DoublyLinkedListDemo {

	public DoublyLinkedListDemo() {
	}

	public static void main(String[] args) {
		DoublyLinkedList ll = new DoublyLinkedList();
		ll.addHead(1);
		ll.addHead(2);
		ll.addHead(3);
		ll.addHead(4);
		ll.addHead(5);
		ll.addHead(6);
		ll.removeHead();
		ll.freeList();
		ll.print();
		ll.addHead(11);
		ll.addHead(21);
		ll.addHead(31);
		ll.addHead(41);
		ll.addHead(51);
		ll.addHead(61);
		ll.print();
	}

}