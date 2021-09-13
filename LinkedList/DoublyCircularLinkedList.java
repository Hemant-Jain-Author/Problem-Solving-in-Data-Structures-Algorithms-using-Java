public class DoublyCircularLinkedList {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    private static class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int v, Node nxt, Node prv) {
            value = v;
            next = nxt;
            prev = prv;
        }
    }
    /* Other methods */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peekHead() {
        if (isEmpty())
            throw new IllegalStateException("EmptyListException");
        return head.value;
    }

public void addHead(int value) {
    Node newNode = new Node(value, null, null);
    if (size == 0) {
        tail = head = newNode;
        newNode.next = newNode;
        newNode.prev = newNode;
    } else {
        newNode.next = head;
        newNode.prev = head.prev;
        head.prev = newNode;
        newNode.prev.next = newNode;
        head = newNode;
    }
    size++;
}

public void addTail(int value) {
    Node newNode = new Node(value, null, null);
    if (size == 0) {
        head = tail = newNode;
        newNode.next = newNode;
        newNode.prev = newNode;
    } else {
        newNode.next = tail.next;
        newNode.prev = tail;
        tail.next = newNode;
        newNode.next.prev = newNode;
        tail = newNode;
    }
    size++;
}

public int removeHead() {
    if (size == 0)
        throw new IllegalStateException("EmptyListException");

    int value = head.value;
    size--;

    if (size == 0) {
        head = null;
        tail = null;
        return value;
    }

    Node next = head.next;
    next.prev = tail;
    tail.next = next;
    head = next;
    return value;
}

public int removeTail() {
    if (size == 0)
        throw new IllegalStateException("EmptyListException");

    int value = tail.value;
    size--;

    if (size == 0) {
        head = null;
        tail = null;
        return value;
    }

    Node prev = tail.prev;
    prev.next = head;
    head.prev = prev;
    tail = prev;
    return value;
}

public boolean search(int key) {
    Node temp = head;
    if (head == null)
        return false;

    do {
        if (temp.value == key)
            return true;
        temp = temp.next;
    } while (temp != head);

    return false;
}

public void deleteList() {
    head = null;
    tail = null;
    size = 0;
}

public void print() {
    if (isEmpty()) {
        System.out.println("Empty List.");    
        return;
    }
    Node temp = head;
    while (temp != tail) {
        System.out.print(temp.value + " ");
        temp = temp.next;
    }
    System.out.println(temp.value);
}

public static void main1() {
    DoublyCircularLinkedList ll = new DoublyCircularLinkedList();
    ll.addHead(1);
    ll.addHead(2);
    ll.addHead(3);
    ll.print();
    System.out.println(ll.size());
    System.out.println(ll.isEmpty());
    System.out.println(ll.peekHead());
    System.out.println(ll.search(3));
}

/*
3 2 1
3
false
3
true
*/

public static void main2() {
    DoublyCircularLinkedList ll = new DoublyCircularLinkedList();
    ll.addTail(1);
    ll.addTail(2);
    ll.addTail(3);
    ll.print();
    
    ll.removeHead();
    ll.print();
    ll.removeTail();
    ll.print();
    ll.deleteList();
    ll.print();
}

/*
1 2 3
2 3
2
Empty List.
*/

public static void main3() {
    DoublyCircularLinkedList ll = new DoublyCircularLinkedList();
    ll.addHead(1);
    ll.addHead(2);
    ll.addHead(3);
    ll.print();
    
    ll.removeHead();
    ll.print();

}
/*
3 2 1
2 1
*/
public static void main4() {
    DoublyCircularLinkedList ll = new DoublyCircularLinkedList();
    ll.addHead(1);
    ll.addHead(2);
    ll.addHead(3);
    ll.print();

    ll.removeTail();
    ll.print();
}
/*
3 2 1
3 2
*/
public static void main(String[] args) {
    //main1();
    //main2();
    main3();
    main4();
}
}