public class CircularLinkedList {
    private Node tail;
    private int size = 0;

    private static class Node {
        private int value;
        private Node next;

        public Node(int v, Node n) {
            value = v;
            next = n;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("EmptyListException");
        return tail.next.value;
    }

    public void addTail(int value) {
        Node temp = new Node(value, null);
        if (isEmpty()) {
            tail = temp;
            temp.next = temp;
        } else {
            temp.next = tail.next;
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public void addHead(int value) {
        Node temp = new Node(value, null);
        if (isEmpty()) {
            tail = temp;
            temp.next = temp;
        } else {
            temp.next = tail.next;
            tail.next = temp;
        }
        size++;
    }

    public int removeHead() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("EmptyListException");
        }
        int value = tail.next.value;
        if (tail == tail.next)
            tail = null;
        else
            tail.next = tail.next.next;

        size--;
        return value;
    }

    public boolean removeNode(int key) {
        if (isEmpty()) {
            return false;
        }
        Node prev = tail;
        Node curr = tail.next;
        Node head = tail.next;

        if (curr.value == key)// head and single node case.
        {
            if (curr == curr.next)// single node case
                tail = null;
            else // head case
                tail.next = tail.next.next;
            return true;
        }

        prev = curr;
        curr = curr.next;

        while (curr != head) {
            if (curr.value == key) {
                if (curr == tail)
                    tail = prev;
                prev.next = curr.next;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }

        return false;
    }

    public CircularLinkedList copyListReversed() {
        CircularLinkedList cl = new CircularLinkedList();
        Node curr = tail.next;
        Node head = curr;

        if (curr != null) {
            cl.addHead(curr.value);
            curr = curr.next;
        }
        while (curr != head) {
            cl.addHead(curr.value);
            curr = curr.next;
        }
        return cl;
    }

    public CircularLinkedList copyList() {
        CircularLinkedList cl = new CircularLinkedList();
        Node curr = tail.next;
        Node head = curr;

        if (curr != null) {
            cl.addTail(curr.value);
            curr = curr.next;
        }
        while (curr != head) {
            cl.addTail(curr.value);
            curr = curr.next;
        }
        return cl;
    }

    public boolean searchList(int data) {
        Node temp = tail;
        for (int i = 0; i < size; i++) {
            if (temp.value == data)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public void deleteList() {
        tail = null;
        size = 0;
    }

    public void print() {
        if (isEmpty()) {
            return;
        }
        Node temp = tail.next;
        while (temp != tail) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.print(temp.value);
    }

    public static void main(String[] args) {
        CircularLinkedList ll = new CircularLinkedList();
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.print();
    }
}
