
public class Stack2 {
    private int[] data;
    private int top = -1;
    private int minCapacity;
    private int capacity;

    public Stack2() {
        this(1000);
    }

    public Stack2(int size) {
        data = new int[size];
        capacity = minCapacity = size;
    }

    /* Other methods */

    public int size() {
        return (top + 1);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public void push(int value) {
        if (size() == capacity) {
            System.out.println("size doubled");
            int[] newData = new int[capacity * 2];
            System.arraycopy(data, 0, newData, 0, capacity);
            data = newData;
            capacity = capacity * 2;
        }
        top++;
        data[top] = value;
    }
    
    public int top() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("StackEmptyException");
        }
        return data[top];
    }
    
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("StackEmptyException");
        }
    
        int topVal = data[top];
        top--;
        if (size() == capacity / 2 && capacity > minCapacity) {
            System.out.println("size halved");
            capacity = capacity / 2;
            int[] newData = new int[capacity];
            System.arraycopy(data, 0, newData, 0, capacity);
            data = newData;
        }
        return topVal;
    }

    public void print() {
        for (int i = top; i > -1; i--) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack2 s = new Stack2(5);
        for (int i = 1; i <= 11; i++) {
            s.push(i);
        }
        s.print();
        for (int i = 1; i <= 11; i++) {
            s.pop();
        }
    }
}
/*
size doubled
size doubled
11 10 9 8 7 6 5 4 3 2 1 
size halved
size halved
*/