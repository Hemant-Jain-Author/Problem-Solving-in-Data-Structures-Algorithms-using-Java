public class QueueLL {
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
        int value;
        if (tail == tail.next)
            value = tail.value;
        else
            value = tail.next.value;
        
        return value;
    }

    public void add(int value) {
        Node temp = new Node(value, null);
        if (tail == null){
            tail = temp;
            tail.next = tail;
        } else {
            temp.next = tail.next;
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public int remove() throws IllegalStateException {
        if (size == 0)
            throw new IllegalStateException("StackEmptyException");
        
        int value=0;
        if (tail == tail.next){
            value = tail.value;
            tail = null;
        } else {
            value = tail.next.value;
            tail.next = tail.next.next;
        }
        size--;
        return value;
    }

    void print(){
        if(size == 0) {
            System.out.print("Queue is empty.");
            return;    
        }
        Node temp = tail.next;
        System.out.print("Queue is : ");
        for(int i=0;i<size;i++){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueLL que = new QueueLL();
        for(int i=0;i<5;i++){
            que.add(i);
        }
        que.print();
        for (int i = 0; i < 5; i++)
            System.out.print(que.remove() + " ");
    }
}
/*
Queue is : 0 1 2 3 4 
0 1 2 3 4 
*/