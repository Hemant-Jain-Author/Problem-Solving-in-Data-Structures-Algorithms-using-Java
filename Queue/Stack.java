import java.util.ArrayDeque;

public class Stack {
    ArrayDeque<Integer> que1 = new ArrayDeque<Integer>();
    ArrayDeque<Integer> que2 = new ArrayDeque<Integer>();
    int size = 0;

    public void push(int value) {
        que1.add(value);
        size += 1;
    }

    public int pop() {
        int value=0, s = size;        
        while(s > 0){
            value = que1.peek();
            que1.remove();
            if(s > 1)
                que2.add(value);
            s--;
        }
        ArrayDeque<Integer> temp = que1;
        que1 = que2;
        que2 = temp;
        size -= 1;
        return value;
    }

    public void push2(int value) {
        que1.add(value);
        size += 1;
    }

    public int pop2() {
        int value=0, s = size;        
        while(s > 0){
            value = que1.peek();
            que1.remove();
            if(s > 1)
                que1.add(value);
            s--;
        }
        size -= 1;
        return value;
    }



    public static void main(String[] args) {
        Stack s = new Stack();
        for(int i=0; i<5; i++)
            s.push(i);
        for(int i=0; i<5; i++)
            System.out.print(s.pop2() + " ");
    }
}
