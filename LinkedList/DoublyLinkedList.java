public class DoublyLinkedList {
    private Node head;
    private Node tail;
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
            next = null;
            prev = null;
        }
    }

    /* Other methods */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("EmptyListException");
        return head.value;
    }

    public void addHead(int value) {
        Node newNode = new Node(value, null, null);
        if (size == 0) {
            tail = head = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addTail(int value) {
        Node newNode = new Node(value, null, null);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public int removeHead() {
        if (isEmpty())
            throw new IllegalStateException("EmptyListException");
        int value = head.value;
        head = head.next;

        if (head == null)
            tail = null;
        else
            head.prev = null;

        size--;
        return value;
    }

    public boolean removeNode(int key) {
        Node curr = head;
        if (curr == null)// empty list
            return false;

        if (curr.value == key)// head is the node with value key.
        {
            head = head.next;
            size--;
            if (head != null)
                head.prev = null;
            else
                tail = null; // only one element in list.
            return true;
        }

        while (curr.next != null) {
            if (curr.next.value == key) {
                curr.next = curr.next.next;
                if (curr.next == null)// last element case.
                    tail = curr;
                else
                    curr.next = curr;
                size--;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public boolean isPresent(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.value == key)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public void deleteList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    // SORTED INSERT DECREASING
    public void sortedInsert(int value) {
        Node temp = new Node(value);

        Node curr = head;
        if (curr == null)// first element
        {
            head = temp;
            tail = temp;
        }

        if (head.value <= value)// at the begining
        {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }

        while (curr.next != null && curr.next.value > value)// treversal
        {
            curr = curr.next;
        }

        if (curr.next == null)// at the end
        {
            tail = temp;
            temp.prev = curr;
            curr.next = temp;
        } else/// all other
        {
            temp.next = curr.next;
            temp.prev = curr;
            curr.next = temp;
            temp.next.prev = temp;
        }
    }

    /*
     * Reverse a doubly linked List iteratively
     */

    public void reverseList() {
        Node curr = head;
        Node tempNode;
        while (curr != null) {
            tempNode = curr.next;
            curr.next = curr.prev;
            curr.prev = tempNode;

            if (curr.prev == null) {
                tail = head;
                head = curr;
                return;
            }

            curr = curr.prev;
        }
        return;
    }

    /* Remove Duplicate */
    public void removeDuplicate() {
        Node curr = head;
        Node deleteMe;
        while (curr != null) {
            if ((curr.next != null) && curr.value == curr.next.value) {
                deleteMe = curr.next;
                curr.next = deleteMe.next;
                curr.next.prev = curr;
                if (deleteMe == tail) {
                    tail = curr;
                }
            } else {
                curr = curr.next;
            }
        }
    }

    public DoublyLinkedList copyListReversed() {
        DoublyLinkedList dll = new DoublyLinkedList();
        Node curr = head;

        while (curr != null) {
            dll.addHead(curr.value);
            curr = curr.next;
        }
        return dll;
    }

    public DoublyLinkedList copyList() {
        DoublyLinkedList dll = new DoublyLinkedList();
        Node curr = head;

        while (curr != null) {
            dll.addTail(curr.value);
            curr = curr.next;
        }
        return dll;
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
        ll.deleteList();
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
