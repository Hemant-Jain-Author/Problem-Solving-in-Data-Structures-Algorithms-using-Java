public class TwoStack {
    private final int MAX_SIZE = 50;
    int top1;
    int top2;
    int[] data;

    public TwoStack() {
        top1 = -1;
        top2 = MAX_SIZE;
        data = new int[MAX_SIZE];
    }

    public void push1(int value) {
        if (top1 < top2 - 1) {
            data[++top1] = value;
        } else {
            System.out.print("Stack is Full!");
        }
    }

    public void push2(int value) {
        if (top1 < top2 - 1) {
            data[--top2] = value;
        } else {
            System.out.print("Stack is Full!");
        }
    }

    public int pop1() {
        if (top1 >= 0) {
            int value = data[top1--];
            return value;
        } else {
            System.out.print("Stack Empty!");
        }
        return -999;
    }

    public int pop2() {
        if (top2 < MAX_SIZE) {
            int value = data[top2++];
            return value;
        } else {
            System.out.print("Stack Empty!");
        }
        return -999;
    }
    public static void main(String[] args) {
        TwoStack st = new TwoStack();
        st.push1(1);
        st.push1(2);
        st.push1(3);
        st.push2(4);
        st.push2(5);
        st.push2(6);
        System.out.println("stk1 pop: " + st.pop1());
        System.out.println("stk1 pop: " + st.pop1());
        System.out.println("stk2 pop: " + st.pop2());
        System.out.println("stk2 pop: " + st.pop2());
    }
}

/*
stk1 pop: 3
stk1 pop: 2
stk2 pop: 6
stk2 pop: 5
*/
