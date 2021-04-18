import java.util.*;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack : " + stack);
        System.out.println("Stack size : " + stack.size());
        System.out.println("Stack pop : " + stack.pop());
        System.out.println("Stack top : " + stack.peek());
        System.out.println("Stack isEmpty : " + stack.isEmpty());
    }
}

/* 
Stack : [1, 2, 3]
Stack size : 3
Stack pop : 3
Stack top : 2
Stack isEmpty : false
*/