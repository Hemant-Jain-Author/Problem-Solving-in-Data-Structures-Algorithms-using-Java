package CA;

public class Fibo {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fibonacci2(int n) {
        int first = 0;
        int second = 1;
        int temp = 0;

        if (n == 0)
            return first;
        else if (n == 1)
            return second;
        int i = 2;
        while (i <= n) {
            temp = first + second;
            first = second;
            second = temp;
            i += 1;
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(7));
        System.out.println(fibonacci2(7));
    }
}

/*
13
13
*/
