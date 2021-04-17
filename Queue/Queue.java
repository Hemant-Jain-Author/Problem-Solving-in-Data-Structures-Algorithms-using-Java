
public class Queue {
    private int size;
    private int capacity = 100;
    private int[] data;
    int front = 0;
    int back = 0;

    public Queue() {
        size = 0;
        data = new int[100];
    }

    public boolean add(int value) {
        if (size >= capacity) {
            System.out.println("Queue is full.");
            return false;
        } else {
            size++;
            data[back] = value;
            back = (++back) % (capacity - 1);
        }
        return true;
    }

    public int remove() {
        int value;
        if (size <= 0) {
            System.out.println("Queue is empty.");
            return -999;
        } else {
            size--;
            value = data[front];
            front = (++front) % (capacity - 1);
        }
        return value;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    public static void main(String[] args) {
        Queue que = new Queue();
        que.add(1);
        que.add(2);
        que.add(3);
        for (int i = 0; i < 3; i++)
            System.out.println(que.remove());
    }
}

/*
1
2
3
*/