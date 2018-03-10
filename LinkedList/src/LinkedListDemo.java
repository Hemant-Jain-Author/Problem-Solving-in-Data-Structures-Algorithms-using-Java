public class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.addHead(1);
		ll.addHead(2);
		ll.addHead(3);
		ll.addHead(3);
		ll.print();
		System.out.println();
		
		/*		
		LinkedList l2 = ll.copyList();
 		l2.print();
		LinkedList l3 = ll.CopyListReversed();
		l3.print()
		*/;
		System.out.println(ll.nthNodeFromBegining(2));
		System.out.println(ll.nthNodeFromEnd(2));
		System.out.println(ll.nthNodeFromEnd2(2));
	}
}