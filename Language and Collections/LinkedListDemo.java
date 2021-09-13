import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.addFirst(1);
        ll.addLast(3);
        ll.addFirst(2);
        ll.addLast(4);
        System.out.println("Linked List: " + ll);
        ll.removeFirst();
        ll.removeLast();
        System.out.println("Linked List: " + ll);
    }
}

/* 
Linked List: [2, 1, 3, 4]
Linked List: [1, 3] 
*/