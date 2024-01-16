public class Knapsack {
	public static int maxCost01Knapsack(int[] wt, int[] cost, int capacity) {
		int n = wt.length;
		return maxCost01KnapsackUtil(wt, cost, n, capacity);
	}

	public static int maxCost01KnapsackUtil(int[] wt, int[] cost, int n, int capacity) {
		// Base Case
		if (n == 0 || capacity == 0)
			return 0;

		// Return the maximum of two cases:
		// (1) nth item is included
		// (2) nth item is not included
		int first = 0;
		if (wt[n - 1] <= capacity)
			first = cost[n - 1] + maxCost01KnapsackUtil(wt, cost, n - 1, capacity - wt[n - 1]);

		int second = maxCost01KnapsackUtil(wt, cost, n - 1, capacity);
		return Math.max(first, second);
	}

	public static int maxCost01KnapsackTD(int[] wt, int[] cost, int capacity) {
		int n = wt.length;
		int[][] dp = new int[capacity + 1][n + 1];
		return maxCost01KnapsackTD(dp, wt, cost, n, capacity);
	}

	public static int maxCost01KnapsackTD(int[][] dp, int[] wt, int[] cost, int i, int w) {
		if (w == 0 || i == 0)
			return 0;

		if (dp[w][i] != 0)
			return dp[w][i];

		// Their are two cases:
		// (1) ith item is included
		// (2) ith item is not included
		int first = 0;
		if (wt[i - 1] <= w)
			first = maxCost01KnapsackTD(dp, wt, cost, i - 1, w - wt[i - 1]) + cost[i - 1];

		int second = maxCost01KnapsackTD(dp, wt, cost, i - 1, w);
		return dp[w][i] = Math.max(first, second);
	}

	public static int maxCost01KnapsackBU(int[] wt, int[] cost, int capacity) {
		int n = wt.length;
		int[][] dp = new int[capacity + 1][n + 1];

		// Build table dp[][] in bottom up approach.
		// Weights considered against capacity.
		for (int w = 1; w <= capacity; w++) {
			for (int i = 1; i <= n; i++) {
				// Their are two cases:
				// (1) ith item is included
				// (2) ith item is not included
				int first = 0;
				if (wt[i - 1] <= w)
					first = dp[w - wt[i - 1]][i - 1] + cost[i - 1];

				int second = dp[w][i - 1];
				dp[w][i] = Math.max(first, second);
			}
		}
		printItems(dp, wt, cost, n, capacity);
		return dp[capacity][n]; // Number of weights considered and final capacity.
	}

	public static void printItems(int[][] dp, int[] wt, int[] cost, int n, int capacity) {
		int totalCost = dp[capacity][n];
		System.out.print("Selected items are:");
		for (int i = n - 1; i > 0; i--) {
			if (totalCost != dp[capacity][i - 1]) {
				System.out.print(" (wt:" + wt[i] + ", cost:" + cost[i] + ")");
				capacity -= wt[i];
				totalCost -= cost[i];
			}
		}
	}

	public static int KS01UnboundBU(int[] wt, int[] cost, int capacity) {
		int n = wt.length;
		int[] dp = new int[capacity + 1];

		// Build table dp[] in bottom up approach.
		// Weights considered against capacity.
		for (int w = 1; w <= capacity; w++) {
			for (int i = 1; i <= n; i++) {
				// Their are two cases:
				// (1) ith item is included
				// (2) ith item is not included
				if (wt[i - 1] <= w)
					dp[w] = Math.max(dp[w], dp[w - wt[i - 1]] + cost[i - 1]);
			}
		}
		// printItems(dp, wt, cost, n, capacity);
		return dp[capacity]; // Number of weights considered and final capacity.
	}

	public static void main(String[] args) {
		int[] wt = { 10, 40, 20, 30 };
		int[] cost = { 60, 40, 90, 120 };
		int capacity = 50;

		double maxCost = KS01UnboundBU(wt, cost, capacity);
		System.out.println("Maximum cost obtained = " + maxCost);
		maxCost = maxCost01Knapsack(wt, cost, capacity);
		System.out.println("Maximum cost obtained = " + maxCost);
		maxCost = maxCost01KnapsackBU(wt, cost, capacity);
		System.out.println("Maximum cost obtained = " + maxCost);
		maxCost = maxCost01KnapsackTD(wt, cost, capacity);
		System.out.println("Maximum cost obtained = " + maxCost);
	}
}

/*
Maximum cost obtained = 300.0
Maximum cost obtained = 210.0
Selected items are: (wt:30, cost:120) (wt:20, cost:90)
Maximum cost obtained = 210.0
Maximum cost obtained = 210.0
*/