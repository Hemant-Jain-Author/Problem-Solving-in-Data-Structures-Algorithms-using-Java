public class Fibo {
    public static int fibonacci(int n) {
        if (n <= 2) {
            return n-1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void fibonacciSeries(int n) {
        for(int i=1;i<=n;i++)
            System.out.print(fibonacci(i) + " ");
    }


    public static int fibonacciBU(int n) {
        if (n <= 2)
            return n-1;
        
        int first = 0, second = 1;
        int temp = 0;

        for ( int i=2; i < n; i++) {
            temp = first + second;
            first = second;
            second = temp;
        }
        return temp;
    }

    public static void fibonacciSeriesBU(int n) {
        if(n < 1)
            return;

        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;

        for ( int i=2; i < n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        for(int i=0;i<n;i++)
            System.out.print(dp[i] + " ");
    }

    public static void fibonacciSeriesTD(int n) {
        if(n < 1)
            return;
        int[] dp = new int[n];

        fibonacciSeriesTD(n-1, dp);

        for(int i=0;i<n;i++)
            System.out.print(dp[i] + " ");
    }

    public static int fibonacciSeriesTD(int n, int[] dp) {
        if (n <= 1)
            return dp[n] = n;
        
        if(dp[n] != 0)
            return dp[n];

        dp[n] = fibonacciSeriesTD(n-1, dp) + fibonacciSeriesTD(n-2, dp); 
        return dp[n];
    }

    public static void main(String[] args) {       
        for(int i=6;i<7;i++) {
            fibonacciSeries(i);
                System.out.println();

            fibonacciSeriesBU(i);
                System.out.println();

            fibonacciSeriesTD(i);
                System.out.println();

        }
        System.out.println(fibonacci(6));
        System.out.println(fibonacciBU(6));
    }
}

/*
13
13
*/