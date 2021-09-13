public class Stack {

    private int capacity = 1000;
    private int[] data;
    private int top = -1;

    public Stack() {
        data = new int[capacity];
    }

    public Stack(int size) {
        data = new int[size];
        capacity = size;
    }
    /* Other methods */

    public int size() {
        return (top + 1);
    }
    
    public boolean isEmpty() {
        return (top == -1);
    }
    
    public void push(int value) throws IllegalStateException {
        if (size() == data.length) {
            throw new IllegalStateException("StackOverflowException");
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
        return topVal;
    }
    
    public void print() {
        for (int i = top; i > -1; i--) {
            System.out.print(data[i] + " ");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.print();
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
/*
3 2 1 
3
2
*/