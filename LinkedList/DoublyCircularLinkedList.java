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

        public Node(int v) {
            value = v;
            next = this;
            prev = this;
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

    public boolean isPresent(int key) {
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
            return;
        }
        Node temp = head;
        while (temp != tail) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.print(temp.value);
    }

    public static void main(String[] args) {
        DoublyCircularLinkedList ll = new DoublyCircularLinkedList();
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.print();
    }
}