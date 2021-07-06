package CA;

public class Fibo {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fibonacciBU(int n) {
        if (n <= 1)
            return n;
        
        int first = 0, second = 1;
        int temp = 0;

        for ( int i=2; i <= n; i++) {
            temp = first + second;
            first = second;
            second = temp;
        }
        return temp;
    }

    public static int fibonacciTD(int n) {
        if (n <= 1)
            return n;
        
        int first = 0, second = 1;
        int temp = 0;

        for ( int i=2; i <= n; i++) {
            temp = first + second;
            first = second;
            second = temp;
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
