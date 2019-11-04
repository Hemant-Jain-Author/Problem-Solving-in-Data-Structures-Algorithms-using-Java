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

    public static void main(String[] args) {
        TwoStack st = new TwoStack();
        for (int i = 0; i < 10; i++) {
            st.StackPush1(i);
        }
        for (int j = 0; j < 10; j++) {
            st.StackPush2(j + 10);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("stack one pop value is : " + st.StackPop1());
            System.out.println("stack two pop value is : " + st.StackPop2());
        }
    }

    public void StackPush1(int value) {
        if (top1 < top2 - 1) {
            data[++top1] = value;
        } else {
            System.out.print("Stack is Full!");
        }
    }

    public void StackPush2(int value) {
        if (top1 < top2 - 1) {
            data[--top2] = value;
        } else {
            System.out.print("Stack is Full!");
        }
    }

    public int StackPop1() {
        if (top1 >= 0) {
            int value = data[top1--];
            return value;
        } else {
            System.out.print("Stack Empty!");
        }
        return -999;
    }

    public int StackPop2() {
        if (top2 < MAX_SIZE) {
            int value = data[top2++];
            return value;
        } else {
            System.out.print("Stack Empty!");
        }
        return -999;
    }
}
