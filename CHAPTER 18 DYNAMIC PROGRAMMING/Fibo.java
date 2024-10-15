public class Fibo {
	public static int fibonacci(int n) {
		if (n < 2) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static int fibonacciBU(int n) {
		if (n < 2)
			return n;

		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}

		return dp[n];
	}

	public static int fibonacciBU2(int n) {
		if (n < 2)
			return n;

		int first = 0, second = 1;
		int temp = 0;

		for (int i = 2; i <= n; i++) {
			temp = first + second;
			first = second;
			second = temp;
		}
		return temp;
	}

	public static int fibonacciTD(int n) {
		int[] dp = new int[n + 1];
		fibonacciTD(n, dp);
		return dp[n];
	}

	public static int fibonacciTD(int n, int[] dp) {
		if (n < 2)
			return dp[n] = n;

		if (dp[n] != 0)
			return dp[n];

		dp[n] = fibonacciTD(n - 1, dp) + fibonacciTD(n - 2, dp);
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(fibonacci(10));
		System.out.println(fibonacciBU(10));
		System.out.println(fibonacciBU2(10));
		System.out.println(fibonacciTD(10));

	}
}

/*
55
55
55
55
*/