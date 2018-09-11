public class QueueLL {
    private Node head = null;
    private Node tail = null;
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

    public int peek() throws IllegalStateException {
        if (isEmpty())
            throw new IllegalStateException("StackEmptyException");
        return head.value;
    }

    public void add(int value) {
        Node temp = new Node(value, null);

        if (head == null)
            head = tail = temp;
        else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public int remove() throws IllegalStateException {
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
        q.add(1);
        q.add(2);
        q.add(3);
        for (int i = 0; i < 3; i++)
            System.out.println(q.remove());
        q.print();
    }
}